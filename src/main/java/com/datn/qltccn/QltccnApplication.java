package com.datn.qltccn;

import com.datn.qltccn.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class QltccnApplication {

    public static void main(String[] args) {
        SpringApplication.run(QltccnApplication.class, args);
    }

}
