package com.da;

import com.da.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class QlttgdApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlttgdApplication.class, args);
    }

}
