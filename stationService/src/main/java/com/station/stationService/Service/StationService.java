package com.station.stationService.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.station.stationService.models.Station;

public interface StationService {
	
	
	public void saveStation(Station station);
	
	
	public void deleteStation(Station station);

	public Station findByStationId(String stationId);
	
	public Station findByStationName(String stationName) ;
	
	
	public List<Station> findByHdEnabled(String hdEnabled) ;
	
	
	
	

}
