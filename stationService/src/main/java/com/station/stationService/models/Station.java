package com.station.stationService.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String stationId;

	private String name;

	private String hdEnabled;

	private String callSign;

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHdEnabled() {
		return hdEnabled;
	}

	public void setHdEnabled(String hdEnabled) {
		this.hdEnabled = hdEnabled;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

}
