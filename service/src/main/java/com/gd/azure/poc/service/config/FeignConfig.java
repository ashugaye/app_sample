package com.gd.azure.poc.service.config;

import com.gd.azure.poc.service.clients.StoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactivefeign.rx2.Rx2ReactiveFeign;

@Configuration
public class FeignConfig {

    @Bean
    public StoreClient getStoreClient() {
        return Rx2ReactiveFeign
            .<StoreClient>builder()
            .target(StoreClient.class, "http://dao-spring-boot");
    }
}
