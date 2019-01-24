//package com.gd.azure.poc.dao.daoimpl;
//
//import com.gd.azure.poc.domain.Store;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class StoresDaoImpl implements IStoresDao {
//
//    @Override
//    public List<Store> fetchActiveByStoreIds(List<Long> storeIds) {
//        return findAllById(storeIds).stream().filter(Store::isActive).collect(Collectors.toList());
//    }
//}
