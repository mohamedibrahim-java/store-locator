package com.jumbo.stores.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

	MANDATORY_PARAM_LONGTUDE(0, "longitude can't be empty or null"),
	MANDATORY_PARAM_LATITUDE(1, "latitude can't be empty or null");

	private final int code;
	private final String description;
}
