package edu.zut.chz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author anmingnuo
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MainApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainApplication.class, args);
    }
}
