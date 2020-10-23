package com.kach.tuts;

import com.kach.tuts.security.jwt.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
public class TutsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TutsApplication.class, args);
    }
}
