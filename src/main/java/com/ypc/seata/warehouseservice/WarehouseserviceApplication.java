package com.ypc.seata.warehouseservice;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoDataSourceProxy
@EnableTransactionManagement
@EnableFeignClients
@SpringBootApplication
public class WarehouseserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseserviceApplication.class, args);
    }

}
