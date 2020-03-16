package com.jumbo.stores.mapper;

import com.jumbo.stores.dto.StoreDTO;
import com.jumbo.stores.model.Store;

public interface StoreMapper {

	Store convertToEntity(StoreDTO storeDTO);

	StoreDTO convertToDto(Store store);
}
