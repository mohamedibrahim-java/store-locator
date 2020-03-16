package com.jumbo.stores.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Document(collection = "STORE")
public class Store {

	@Id
	private BigInteger id;

	private String city;
	private String postalCode;
	private String street;
	private String street2;
	private String street3;
	private String addressName;
	private String uuid;
	private String longitude;
	private String latitude;
	private String complexNumber;
	private boolean showWarningMessage;
	private String todayOpen;
	private String locationType;
	private boolean collectionPoint;
	private String sapStoreID;
	private String todayClose;
}
