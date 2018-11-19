package com.station.stationService;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.station.stationService.controller.StationController;
import com.station.stationService.models.Station;

@RunWith(SpringRunner.class)
@WebMvcTest(StationController.class)
public class StationControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StationController stationController;
	
	@MockBean
	private DataSource dataSource;
	
	@MockBean
	private SessionFactory sessionFactory;
	
	@MockBean
	HibernateTransactionManager transactionManager;
	
	  @Test
	   public void findById() throws Exception {
	       Station station = new Station();
	       given(stationController.findById(station)).willReturn(station);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/searchByIDOrName")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }
	  
	  @Test
	   public void findByHDEnabled() throws Exception {
		  Station station = new Station();
		  station.setHdEnabled("true");
	       List<Station> stationList = singletonList(station);
	      
	   }

	  
	  
	  @Test
	   public void saveOrUpdateStation() throws Exception {
		  Station station = new Station();
		  station.setHdEnabled("true");
	       given(stationController.saveOrUpdate(station)).willReturn(station);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/saveOrUpdateStation")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }
	
	   @Test
	   public void removeStation() throws Exception {
		  Station station = new Station();
	       given(stationController.remove(station)).willReturn(station);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/removeStation")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }

}
