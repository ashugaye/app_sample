package com.gd.azure.poc.service.clients;

import com.gd.azure.poc.domain.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dao-spring-boot", url = "http://dao-spring-boot")
public interface StoreClient {

    @GetMapping(path = "/stores/{storeId}")
    Store getStore(
        @PathVariable("storeId") String storeIds);
}
