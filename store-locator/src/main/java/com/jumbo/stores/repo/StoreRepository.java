package com.jumbo.stores.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jumbo.stores.model.Store;

public interface StoreRepository extends MongoRepository<Store, Long> {

}
