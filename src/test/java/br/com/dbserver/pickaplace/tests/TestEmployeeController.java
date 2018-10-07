package br.com.dbserver.pickaplace.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.dbserver.pickaplace.PickAPlaceApplicationTests;

public class TestEmployeeController extends PickAPlaceApplicationTests {
	
	private static final Logger LOGGER = LogManager.getLogger(TestEmployeeController.class);	
	private static final String URL_SERVICE = "/api/employees";
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testListAllEmployee() throws Exception {
		String webMethod = "/listAll";
		MvcResult result = this.mockMvc.perform(get(TestEmployeeController.URL_SERVICE+webMethod).contentType(TestFavoritesController.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		LOGGER.info("Result TestListAllEmployee -> "+result.getResponse().getContentAsString());
	}
}
