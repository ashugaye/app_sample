package com.gd.azure.poc.dao.daoimpl;

import com.gd.azure.poc.domain.Store;
//import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * This is the persistence api which is used to do CRUD operations with respect to the data base with respect stores
 * meta data TODO API documentation and clean up.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface IStoresDao extends MongoRepository<Store, String> {

}

