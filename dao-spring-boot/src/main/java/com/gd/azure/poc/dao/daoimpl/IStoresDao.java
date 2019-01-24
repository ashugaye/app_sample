package com.gd.azure.poc.dao.daoimpl;

import com.gd.azure.poc.domain.Store;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * This is the persistence api which is used to do CRUD operations with respect to the data base with respect stores
 * meta data TODO API documentation and clean up.
 */
@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface IStoresDao extends CrudRepository<Store, Long> {

//    @GetMapping(value = "/{ids}/active", produces = "application/json")
//    Collection<Store> fetchActiveByStoreIds(
//        @PathVariable("ids") List<Long> storeIds);
}

