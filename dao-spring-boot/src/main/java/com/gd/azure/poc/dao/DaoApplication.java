package com.gd.azure.poc.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@ComponentScan
@EnableReactiveMongoRepositories
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(StoresRepository storesDao) {
//        return (args) -> {
//            storesDao.deleteAll();
//            for (int i = 1; i < 10000; i++) {
//                storesDao.save(new Store(String.valueOf(i), "Store" + i, new StoreType("name" + i, "displayName" + i), "(555) 555-5555", new Date(),
//                    "http://www.example.com/store/" + i, true,
//                    new Address("street " + i, "street " + i + "." + i, "Santa Clara", "CA", "95050")));
//            }
//        };
//    }
}
