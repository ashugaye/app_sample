package com.gd.azure.poc.dao;

import com.gd.azure.poc.dao.daoimpl.IStoresDao;
//import com.gd.azure.poc.dao.daoimpl.StoresDaoImpl;
import com.gd.azure.poc.domain.Address;
import com.gd.azure.poc.domain.Store;
import com.gd.azure.poc.domain.StoreType;
//import com.microsoft.azure.spring.autoconfigure.cosmosdb.DocumentDBAutoConfiguration;
//import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableDocumentDbRepositories;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EntityScan(basePackages = {"com.gd.azure.poc.domain"})
//@EnableDocumentDbRepositories
public class DaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(IStoresDao storesDao) {
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
