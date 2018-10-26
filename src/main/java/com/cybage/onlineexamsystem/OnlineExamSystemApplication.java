package com.cybage.onlineexamsystem;

import com.cybage.onlineexamsystem.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineExamSystemApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger("OES");

    @Autowired
    private CategoryService service;

    public static void main(String[] args) {
        SpringApplication.run(OnlineExamSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        LOG.info("Current Object in DB: {}", service.countCategory());
    }
}
