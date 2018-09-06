package com.codegym.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;

public class MyUploadForm implements Serializable {
    private String description;
    private CommonsMultipartFile[] fileDatas;

    public MyUploadForm() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile[] getFileDatas() {
        return fileDatas;
    }

    public void setFileDatas(CommonsMultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }
}
