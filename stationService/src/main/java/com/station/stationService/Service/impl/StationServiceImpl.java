package com.station.stationService.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.station.stationService.DAO.StationDAO;
import com.station.stationService.Service.StationService;
import com.station.stationService.models.Station;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationDAO stationDAO;

	@Override
	public void saveStation(Station station) {
		stationDAO.saveStation(station);

	}

	@Override
	public void deleteStation(Station station) {
		stationDAO.deleteStation(station);

	}

	@Override
	public Station findByStationId(String stationId) {
		return stationDAO.findByStationId(stationId);
	}

	@Override
	public Station findByStationName(String stationName) {
		return stationDAO.findByStationName(stationName);
	}

	@Override
	public List<Station> findByHdEnabled(String hdEnabled) {
		// TODO Auto-generated method stub
		return stationDAO.findByHdEnabled(hdEnabled);
	}

}
