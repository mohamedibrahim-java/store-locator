package com.jumbo.stores.mapper.impl;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.jumbo.stores.dto.StoreDTO;
import com.jumbo.stores.mapper.StoreMapper;
import com.jumbo.stores.model.Store;

@Component
public class StoreMapperImpl implements StoreMapper {

	@Override
	public Store convertToEntity(StoreDTO storeDTO) {

		if (Objects.isNull(storeDTO))
			return null;

		Store store = new Store();

		store.setAddressName(storeDTO.getAddressName());
		store.setCity(storeDTO.getCity());
		store.setLongitude(String.valueOf(storeDTO.getLongitude()));
		store.setLatitude(String.valueOf(storeDTO.getLatitude()));
		store.setCollectionPoint(storeDTO.isCollectionPoint());
		store.setComplexNumber(store.getComplexNumber());
		store.setLocationType(storeDTO.getLocationType());
		store.setPostalCode(storeDTO.getPostalCode());
		store.setSapStoreID(storeDTO.getPostalCode());
		store.setShowWarningMessage(storeDTO.isShowWarningMessage());
		store.setStreet(storeDTO.getStreet());
		store.setStreet2(storeDTO.getStreet2());
		store.setStreet3(storeDTO.getStreet3());

		return store;
	}

	@Override
	public StoreDTO convertToDto(Store store) {

		if (Objects.isNull(store))
			return null;

		StoreDTO storeDTO = new StoreDTO();

		storeDTO.setAddressName(store.getAddressName());
		storeDTO.setCity(store.getCity());
		storeDTO.setLongitude(Double.valueOf(store.getLongitude()));
		storeDTO.setLatitude(Double.valueOf(store.getLatitude()));
		storeDTO.setCollectionPoint(store.isCollectionPoint());
		storeDTO.setComplexNumber(store.getComplexNumber());
		storeDTO.setLocationType(store.getLocationType());
		storeDTO.setPostalCode(store.getPostalCode());
		storeDTO.setSapStoreID(store.getPostalCode());
		storeDTO.setShowWarningMessage(store.isShowWarningMessage());
		storeDTO.setStreet(store.getStreet());
		storeDTO.setStreet2(store.getStreet2());
		storeDTO.setStreet3(store.getStreet3());

		return storeDTO;
	}

}
