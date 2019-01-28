package com.gd.azure.poc.service;

import com.gd.azure.poc.domain.Store;
import com.gd.azure.poc.dto.StoreDto;
import com.gd.azure.poc.service.clients.StoreClient;
import com.gd.azure.poc.service.mappers.StoreMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

    public StoreDto getStore(String storedId, boolean fromDb) {
        try {
            Store storeRaw;
            if (fromDb) {
                storeRaw = storeClient.getStore(storedId);
            } else {
                storeRaw = storeClient.getStoreWithCaching(storedId);
            }
            return storeMapper.map(storeRaw, StoreDto.class);
        } catch (Exception e) {
            log.error("Could not map dao to dto", e);
        }

        return null;
    }

    public Collection<StoreDto> getStores(String[] storesId, boolean fromDb) {
        try {
            List<Store> storeRaw = new ArrayList<>();
            if (fromDb) {
                for (String id: storesId) {
                    storeRaw.add(storeClient.getStore(id));
                }
            } else {
                for (String id: storesId) {
                    storeRaw.add(storeClient.getStoreWithCaching(id));
                }
            }
            if (!storeRaw.isEmpty()) {
                List<StoreDto> stores = new ArrayList<>();
                storeRaw.forEach(it -> stores.add(storeMapper.map(it, StoreDto.class)));
                return stores;
            }
        } catch (Exception e) {
            log.error("Could not map dao to dto", e);
        }

        return null;
    }

}
