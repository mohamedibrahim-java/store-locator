package com.jumbo.stores.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jumbo.stores.config.ErrorMessages;
import com.jumbo.stores.dto.StoreDTO;
import com.jumbo.stores.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/stores")
@Api(value = "Stores", tags = { "Stores API" })
@RestController
public class StoreLocatorController {

	@Autowired
	private StoreService storeService;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all near by stores to given location")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved closest 5 stores") })
	public ResponseEntity<List<StoreDTO>> findCloseStores(@RequestParam("longitude") Double longitude,
			@RequestParam("latitude") Double latitude,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit) {

		if (longitude == null) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					ErrorMessages.MANDATORY_PARAM_LONGTUDE.getDescription());
		} else if (latitude == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					ErrorMessages.MANDATORY_PARAM_LATITUDE.getDescription());
		}

		Optional<List<StoreDTO>> stores = storeService.findStoresNearbyTo(longitude, latitude, limit);

		if (!stores.isPresent()) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(stores.get(), HttpStatus.OK);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all stores ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved all stores") })
	public ResponseEntity<List<StoreDTO>> getAllStores() {

		Optional<List<StoreDTO>> stores = storeService.findAllStores();

		if (!stores.isPresent()) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(stores.get(), HttpStatus.OK);
	}

	@PostMapping("/")
	@ApiOperation(value = "Add New Store")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added Store") })
	public ResponseEntity<StoreDTO> addStore(@RequestBody StoreDTO storeDTO) {

		Optional<StoreDTO> store = storeService.addStore(storeDTO);

		if (!store.isPresent()) {
			return new ResponseEntity<>(new StoreDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(store.get(), HttpStatus.CREATED);
	}
}
