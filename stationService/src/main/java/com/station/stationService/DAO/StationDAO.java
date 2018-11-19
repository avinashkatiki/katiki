package com.station.stationService.DAO;

import java.util.List;

import com.station.stationService.models.Station;

public interface StationDAO {
	
	public void saveStation(Station station);
	
	
	public void deleteStation(Station station);
	
	public Station findByStationId(String stationId);
	
	public Station findByStationName(String stationName);
	
	public List<Station> findByHdEnabled(String hdEnabled) ;

}
