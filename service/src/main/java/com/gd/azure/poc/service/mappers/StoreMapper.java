package com.gd.azure.poc.service.mappers;

import com.gd.azure.poc.domain.Store;
import com.gd.azure.poc.dto.StoreDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {

        factory.classMap(Store.class, StoreDto.class)
            .field("id", "id")
            .field("displayName", "displayName")
            .field("storeType", "storeType")
            .field("phone", "phone")
            .field("openDate", "openDate")
            .field("url", "url")
            .field("active", "active")
            .field("address", "address")
            .byDefault()
            .register();
    }
}
