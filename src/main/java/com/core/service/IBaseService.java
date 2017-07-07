package com.core.service;


import com.core.common.exception.BusinessException;
import com.core.common.exception.SystemException;
import com.core.common.model.ResponseImage;

import java.util.List;

/**
 * Created by Jemry.Liu on 2015/4/9.
 */
public interface IBaseService<T> {

    T getById(Object id);

    List<T> getByEntity(T entity);


    int save(T entity);

    int update(T entity);

    int delete(Object id);

    int saveSelective(T entity);

    int updateSelective(T entity);


    /**
     * 上传图片
     *
     * @param data base64转码文件
     * @param fileName 文件名
     * @return the response image
     * @throws SystemException the system exception
     * @throws BusinessException the business exception
     */
    public ResponseImage uploadImage(String data, String fileName) throws SystemException, BusinessException;


}
