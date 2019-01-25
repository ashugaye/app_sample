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

    @Bean
    public CommandLineRunner demo(IStoresDao storesDao) {
        return (args) -> {
            storesDao.deleteAll();
            // save a couple of customers
            storesDao.save(new Store("1", "Store1", new StoreType("name1", "displayName1"), "(555) 555-5555", new Date(),
                "http://www.example.com/store/1", true,
                new Address("street 1", "street 1.1", "Santa Clara", "CA", "95050")));

            storesDao.save(new Store("2", "Store2", new StoreType("name2", "displayName2"), "(555) 555-5556", new Date(),
                "http://www.example.com/store/2", true,
                new Address("street 2", "street 2.1", "Dublin", "CA", "94568")));

            storesDao.save(new Store("3","Store3", new StoreType("name3", "displayName3"), "(555) 555-5557", new Date(),
                "http://www.example.com/store/3", true,
                new Address("street 3", "street 3.1", "Mountain View", "CA", "94039")));

            storesDao.save(new Store("4", "Store4", new StoreType("name4", "displayName4"), "(555) 555-5558", new Date(),
                "http://www.example.com/store/4", true,
                new Address("street 4", "street 4.1", "Cupertino", "CA", "94024")));

            storesDao.save(new Store("5", "Store5", new StoreType("name5", "displayName5"), "(555) 555-5559", new Date(),
                "http://www.example.com/store/5", false,
                new Address("street 5", "street 5.1", "San Bruno", "CA", "94066")));

            storesDao.save(new Store("6", "Store6", new StoreType("name6", "displayName6"), "(555) 555-5565", new Date(),
                "http://www.example.com/store/6", true,
                new Address("street 6", "street 6.1", "Frisco", "TX", "75035")));

            storesDao.save(new Store("7", "Store7", new StoreType("name7", "displayName7"), "(555) 555-5566", new Date(),
                "http://www.example.com/store/7", true,
                new Address("street 7", "street 7.1", "Plano", "TX", "75024")));

            storesDao.save(new Store("8", "Store8", new StoreType("name8", "displayName8"), "(555) 555-5567", new Date(),
                "http://www.example.com/store/8", false,
                new Address("street 8", "street 8.1", "Plano", "TX", "75025")));

            storesDao.save(new Store("9", "Store9", new StoreType("name9", "displayName9"), "(555) 555-5568", new Date(),
                "http://www.example.com/store/9", true,
                new Address("street 9", "street 9.1", "Conway", "AR", "72032")));

            storesDao.save(new Store("10", "Store10", new StoreType("name10", "displayName10"), "(555) 555-5569", new Date(),
                "http://www.example.com/store/10", false,
                new Address("street 10", "street 10.1", "Little Rock", "AR", "72033")));

        };
    }
}
