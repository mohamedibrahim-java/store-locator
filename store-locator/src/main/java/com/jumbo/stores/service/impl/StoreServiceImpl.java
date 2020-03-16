package com.jumbo.stores.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumbo.stores.dto.Location;
import com.jumbo.stores.dto.StoreDTO;
import com.jumbo.stores.mapper.StoreMapper;
import com.jumbo.stores.repo.StoreRepository;
import com.jumbo.stores.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private StoreMapper storeMapper;

	@Override
	public void addStore(StoreDTO storeDTO) {

		storeRepository.save(storeMapper.convertToEntity(storeDTO));
	}

	@Override
	public Optional<List<StoreDTO>> findStoresNearbyTo(double longitude, double latitude, int limit) {
		return Optional.ofNullable(
				findStoresNearbyTo(Location.builder().latitude(latitude).longitude(longitude).build(), limit).keySet()
						.stream().collect(Collectors.toList()));
	}

	@Override
	public Optional<List<StoreDTO>> findAllStores() {

		return Optional.ofNullable(
				storeRepository.findAll().stream().map(storeMapper::convertToDto).collect(Collectors.toList()));
	}

	private Map<StoreDTO, Double> findStoresNearbyTo(Location location, int limit) {
		return calculateStoreDistancesFromGivenLocation(location).entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).limit(limit)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private Map<StoreDTO, Double> calculateStoreDistancesFromGivenLocation(Location location) {

		List<StoreDTO> stores = storeRepository.findAll().stream().map(storeMapper::convertToDto)
				.collect(Collectors.toList());

		return stores.stream()
				.collect(Collectors.toMap(store -> store, store -> store.getLocation().distanceTo(location, "M")));
	}
}
