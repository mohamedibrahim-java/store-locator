package com.jumbo.stores.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Store", description = "All details about the store.")
public class StoreDTO {

	@ApiModelProperty(notes = "city")
	private String city;

	@ApiModelProperty(notes = "postal code")
	private String postalCode;

	@ApiModelProperty(notes = "street")
	private String street;

	@ApiModelProperty(notes = "street2")
	private String street2;

	@ApiModelProperty(notes = "street3")
	private String street3;

	@ApiModelProperty(notes = "address Name")
	private String addressName;

	@ApiModelProperty(notes = "uuid")
	private String uuid;

	@ApiModelProperty(notes = "longitude")
	private double longitude;

	@ApiModelProperty(notes = "latitude")
	private double latitude;

	@ApiModelProperty(notes = "complex number")
	private String complexNumber;

	@ApiModelProperty(notes = "show warning message")
	private boolean showWarningMessage;

	@ApiModelProperty(notes = "today open")
	private String todayOpen;

	@ApiModelProperty(notes = "location type")
	private String locationType;

	@ApiModelProperty(notes = "collection point")
	private boolean collectionPoint;

	@ApiModelProperty(notes = "sap store id")
	private String sapStoreID;

	@ApiModelProperty(notes = "today close")
	private String todayClose;

	@JsonIgnore
	public Location getLocation() {
		return Location.builder().latitude(latitude).longitude(longitude).build();
	}

}
