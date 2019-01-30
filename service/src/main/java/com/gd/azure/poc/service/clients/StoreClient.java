package com.gd.azure.poc.service.clients;

import com.gd.azure.poc.domain.Store;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.reactivex.Flowable;

@Headers({"Accept: application/json;charset=UTF-8"})
public interface StoreClient {

    @RequestLine("GET /stores/{storeIds}")
    Flowable<Store> findStoresByIds(
        @Param("storeIds") String storeIds);

}
