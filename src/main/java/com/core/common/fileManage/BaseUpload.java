package com.core.common.fileManage;

import com.core.common.exception.SystemException;
import com.core.common.model.ResponseImage;

public interface BaseUpload {

    /**
     * 文件上传
     * @param filePath
     * @param fileByte
     * @return
     */
    public ResponseImage upload(String filePath, byte[] fileByte) throws SystemException;
}