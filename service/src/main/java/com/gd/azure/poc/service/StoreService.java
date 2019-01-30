package com.gd.azure.poc.service;

import com.gd.azure.poc.domain.Store;
import com.gd.azure.poc.dto.StoreDto;
import com.gd.azure.poc.service.clients.StoreClient;
import com.gd.azure.poc.service.mappers.StoreMapper;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StoreService {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private Cache<String, Store> cache;

    public Collection<StoreDto> getStores(List<String> storeIds, boolean fromDb) {
        List<StoreDto> storeDtos = new ArrayList<>();
        StringJoiner str = new StringJoiner(",");
        storeIds.forEach(str::add);
        try {
            Flowable<Store> storeRaw;
            if (fromDb) {

                storeRaw = storeClient.findStoresByIds(str.toString());

                storeRaw.observeOn(Schedulers.io())
                    .blockingForEach(it -> storeDtos.add(storeMapper.map(it, StoreDto.class)));
            } else {
                List<String> missedKeys = new ArrayList<>();
                storeIds.forEach(id -> {
                    if (cache.containsKey(id)) {
                        storeDtos.add(storeMapper.map(cache.get(id), StoreDto.class));
                    } else {
                        missedKeys.add(id);
                    }
                });
                if (!missedKeys.isEmpty()) {
                    storeClient.findStoresByIds(str.toString()).observeOn(Schedulers.io())
                        .blockingForEach(it -> {
                            cache.put(it.getId(), it);
                            storeDtos.add(storeMapper.map(it, StoreDto.class));
                        });
                }
            }
        } catch (Exception e) {
            log.error("Could not map dao to dto", e);
        }

        return storeDtos;
    }
}
