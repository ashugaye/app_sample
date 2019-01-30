package com.gd.azure.poc.dao.rest;

import com.gd.azure.poc.dao.daoimpl.StoresRepository;
import com.gd.azure.poc.domain.Store;
import io.reactivex.Flowable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoresController {

    @Autowired
    private StoresRepository storesRepository;

    @GetMapping(value = "/stores/{storeIds}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flowable<Store> findStoresById(@PathVariable("storeIds") List<String> storeIds) {
        return storesRepository.findAllById(storeIds);
    }
}
