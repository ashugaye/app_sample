package com.gd.azure.poc.service.clients;

import com.gd.azure.poc.domain.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("dao-spring-boot")
@RequestMapping(value = "/stores")
public interface StoreClient {

    @GetMapping(path = "/{storeId}")
    Store getStore(
        @PathVariable("storeId") String storeIds);
}
