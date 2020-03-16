package com.jumbo.stores.dto;

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
public class Location {

	private String name;
	private static final double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
	private static final double DISTANCE_IN_KM = 1.609344;
	private static final double DISTANCE_IN_METER = 1609.34;

	private double longitude;
	private double latitude;

	public Double distanceTo(Location targetLocation, String unit) {

		if ((targetLocation.latitude == this.latitude) && (targetLocation.longitude == this.longitude)) {
			return 0D;
		}

		final double lat1 = Math.toRadians(this.latitude);
		final double lon1 = Math.toRadians(this.longitude);
		final double lat2 = Math.toRadians(targetLocation.latitude);
		final double lon2 = Math.toRadians(targetLocation.longitude);

		// great circle distance in radians, using law of cosines formula
		double angle = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

		// each degree on a great circle of Earth is 60 nautical miles
		double nauticalMiles = 60 * Math.toDegrees(angle);
		double distance = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;

		if (unit.equalsIgnoreCase("KM")) {
			distance = DISTANCE_IN_KM * distance;
		} else if (unit.equalsIgnoreCase("Meter")) {
			distance = DISTANCE_IN_METER * distance;
		}
		return distance;
	}

//	public static void main(String[] args) {
//		Location loc1 = new Location("PRINCETON_NJ", 4.615551, 51.778461);
//		Location loc2 = new Location("ITHACA_NY", 6.245829, 51.874272);
//		double distance = loc1.distanceTo(loc2, "mile");
//		System.out.println(distance);
//	}
}
