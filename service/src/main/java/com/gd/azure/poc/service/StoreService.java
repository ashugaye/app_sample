package com.gd.azure.poc.service;

import com.gd.azure.poc.domain.Store;
import com.gd.azure.poc.dto.StoreDto;
import com.gd.azure.poc.service.clients.StoreClient;
import com.gd.azure.poc.service.mappers.StoreMapper;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StoreService {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private StoreMapper storeMapper;

//    public Collection<StoreDto> getStores(String[] storedIds) {
//        Collection<StoreDto> stores = new ArrayList<>();
//        try {
//            Collection<Store> storesRaw = storeClient.getStores(storedIds);
//            storesRaw.forEach(it -> stores.add(storeMapper.map(it, StoreDto.class)));
//        } catch (Exception e) {
//            log.error("Could not map dao to dto", e);
//        }
//
//        return stores;
//    }

    public StoreDto getStore(String storedId) {
        try {
            Store storeRaw = storeClient.getStore(storedId);
            return storeMapper.map(storeRaw, StoreDto.class);
        } catch (Exception e) {
            log.error("Could not map dao to dto", e);
        }

        return null;
    }

}
