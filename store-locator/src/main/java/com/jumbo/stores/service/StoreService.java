package com.jumbo.stores.service;

import java.util.List;
import java.util.Optional;

import com.jumbo.stores.dto.StoreDTO;

public interface StoreService {

	void addStore(StoreDTO storeDTO);

	Optional<List<StoreDTO>> findStoresNearbyTo(double longitude, double latitude, int limit);

	Optional<List<StoreDTO>> findAllStores();

}
