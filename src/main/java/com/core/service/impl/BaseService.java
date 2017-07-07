package com.core.service.impl;

import com.core.common.exception.DBException;
import com.core.common.exception.SystemException;
import com.core.common.fileManage.FileManageContext;
import com.core.common.model.ResponseImage;
import com.core.service.IBaseService;
import com.core.util.ResourceUtil;
import com.github.abel533.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jemry.Liu on 2015/4/9.
 */
@Service
public abstract class BaseService<T> implements IBaseService<T> {

    private static Logger logger = LoggerFactory.getLogger(BaseService.class);


    public abstract Mapper<T> getBaseMapper();


    @Override
    public T getById(Object id) {
        return this.getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> getByEntity(T entity) {

        return this.getBaseMapper().select(entity);
    }



    /**
     * 保存对象，保存所有属性
     * @param entity
     * @return
     */
    @Override
    public int save(T entity) {
        return this.getBaseMapper().insert(entity);

    }

    /**
     * 更新对象中所有属性,主键不能为NULL
     * @param entity
     * @return
     */
    @Override
    public int update(T entity) {
        return this.getBaseMapper().updateByPrimaryKey(entity);
    }

    @Override
    public int delete(Object id) {
        return this.getBaseMapper().deleteByPrimaryKey(id);
    }

    /**
     * 保存对象，只保存对象中不为NULL的属性
     * @param entity
     * @return
     */
    @Override
    public int saveSelective(T entity)throws DBException {
        int result = this.getBaseMapper().insertSelective(entity);
        if(result<=0){
            throw new DBException("数据保存异常");
        }
        return result;
    }

    /**
     * 更新对象，只更新对象中不为NULL的属性，主键不能为NULL
     * @param entity
     * @return
     */
    @Override
    public int updateSelective(T entity) {
        return this.getBaseMapper().updateByPrimaryKeySelective(entity);
    }



    /**
     * 文件上传
     *
     * @param data base64转码的文件
     * @param fileName 文件名
     * @return
     * @throws SystemException
     * @throws
     */
    @Override
    public ResponseImage uploadImage(String data, String fileName) throws SystemException {

        //对字节数组字符串进行Base64解码并生成图片
        BASE64Decoder decoder = new BASE64Decoder();
        //Base64解码
        byte[] fileByte = new byte[0];
        try {
            fileByte = decoder.decodeBuffer(data);
        } catch (IOException e) {
            throw new SystemException("Base64转码错误",e);
        }
        for (int i = 0; i < fileByte.length; ++i) {
            //调整异常数据
            if (fileByte[i] < 0) {
                fileByte[i] += 256;
            }
        }
        //将字节数组存入文件系统，最后返回文件的路径
        //根据配置项获取图片存储路径
        String basePath = ResourceUtil.getConfigByName("upload.file.basePath");
        String filePath = basePath + fileName;
        //采用策略模式结合工厂模式，根据对应策略调用不同的存储方式
        FileManageContext uploadContext = new FileManageContext("localServer");

        return uploadContext.upload(filePath, fileByte);
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {
            reader.close();
        }
    }

}
