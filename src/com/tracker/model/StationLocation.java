package com.tracker.model;

public class StationLocation {
	
	int station_lat_long_id;
	String station_code;
	String station_name;
	Double latitude;
	Double longitude;
	
	public int getStation_lat_long_id() {
		return station_lat_long_id;
	}
	public void setStation_lat_long_id(int station_lat_long_id) {
		this.station_lat_long_id = station_lat_long_id;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	

}
