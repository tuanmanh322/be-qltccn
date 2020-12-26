package com.datn.qltccn.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

// auto mapper file.** in application.profile files
// same @Value("${file.**}")
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
