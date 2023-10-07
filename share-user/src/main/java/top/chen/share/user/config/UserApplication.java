package top.chen.share.user.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@SpringBootApplication
@ComponentScan("top.chen")
@Slf4j
public class UserApplication {
    public static void main(String[] args) {
//        SpringApplication.run(UserApplication.class, args);
        SpringApplication app = new SpringApplication(UserApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("启动成功！！");
        log.info("测试地址：http://127.0.0.1:{}{}/hello", env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
    }
}
