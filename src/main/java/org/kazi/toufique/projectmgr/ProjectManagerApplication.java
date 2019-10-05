package org.kazi.toufique.projectmgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// @EnableAutoConfiguration
@ComponentScan(basePackages = {"org.kazi.toufique.projectmgr"})
@EnableJpaRepositories(basePackages = "org.kazi.toufique.projectmgr.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "org.kazi.toufique.projectmgr.model")
public class ProjectManagerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger("ProjectManagerApplication");

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }
}
