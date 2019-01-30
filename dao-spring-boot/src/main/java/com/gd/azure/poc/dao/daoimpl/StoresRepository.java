package com.gd.azure.poc.dao.daoimpl;

import com.gd.azure.poc.domain.Store;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;

public interface StoresRepository extends RxJava2CrudRepository<Store, String> {
}
