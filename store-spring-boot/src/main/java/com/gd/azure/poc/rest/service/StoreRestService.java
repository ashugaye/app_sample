package com.gd.azure.poc.rest.service;

import com.gd.azure.poc.dto.StoreDto;
import com.gd.azure.poc.service.StoreService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreRestService {

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/{ids}", produces = "application/json")
    public ResponseEntity<Collection<StoreDto>> getStores(@PathVariable("ids") List<String> storeIds,
        @RequestParam(value = "fromDb", defaultValue = "false") boolean fromDb) {
        try {
            Collection<StoreDto> stores = storeService.getStores(storeIds, fromDb);
            return new ResponseEntity<>(stores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
