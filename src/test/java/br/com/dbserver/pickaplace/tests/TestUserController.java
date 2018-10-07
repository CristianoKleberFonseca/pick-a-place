package br.com.dbserver.pickaplace.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

public class TestUserController extends PickAPlaceApplicationTests {
	private static final Logger LOGGER = LogManager.getLogger(TestUserController.class);	
	private static final String URL_SERVICE = "/api/users";
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
	public void testSaveFavorites() throws Exception {
		String webMethod = "/login/";
		String parameters = "userone/123456";

		MvcResult result = this.mockMvc.perform(get(URL_SERVICE+webMethod+parameters).contentType(TestFavoritesController.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();

		LOGGER.info("Result TestSaveFavorites -> "+result.getResponse().getContentAsString());
	}
}
