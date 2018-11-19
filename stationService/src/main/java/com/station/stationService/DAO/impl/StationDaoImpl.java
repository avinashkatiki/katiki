package com.station.stationService.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.station.stationService.DAO.StationDAO;
import com.station.stationService.models.Station;

@Repository
public class StationDaoImpl implements StationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveStation(Station station) {
		getSession().beginTransaction();
		getSession().save(station);
		getSession().getTransaction().commit();
	}

	@Override
	public void deleteStation(Station station) {
		getSession().beginTransaction();
		getSession().delete(station);
		getSession().getTransaction().commit();
	}

	@Override
	public Station findByStationId(String stationId) {

		return getSession().find(Station.class, stationId);
	}

	@Override
	public Station findByStationName(String stationName) {

		Query query = getSession().createQuery("from Station where name =:name");

		query.setString("name", stationName);
		// List<UserDetails> data = (List<UserDetails> )query.list();

		return (Station) query.getSingleResult();

	}

	@Override
	public List<Station> findByHdEnabled(String hdEnabled) {
		Query query = getSession().createQuery("from Station where hdEnabled =:hdEnabled");

		query.setString("hdEnabled", hdEnabled);
		// List<UserDetails> data = (List<UserDetails> )query.list();

		return (List<Station>) query.list();
	}

}
