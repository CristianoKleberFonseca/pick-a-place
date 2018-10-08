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

public class TestRestaurantController extends PickAPlaceApplicationTests {
	private static final Logger LOGGER = LogManager.getLogger(TestRestaurantController.class);
	private static final String URL_SERVICE = "/api/restaurants";
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
	public void testListAllRestaurant() throws Exception {
		String webMethod = "/listAll";
		MvcResult result = this.mockMvc.perform(get(URL_SERVICE + webMethod)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();

		LOGGER.info("Result TestListAll -> " + result.getResponse().getContentAsString());
	}

	@Test
	public void testFindByName() throws Exception {
		String webMethod = "/findByName/";
		String parameter = "Bode do Nô";

		MvcResult result = this.mockMvc
				.perform(get(URL_SERVICE + webMethod + parameter).contentType(APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andReturn();

		LOGGER.info("Result TestFindByName -> " + result.getResponse().getContentAsString());
	}

	@Test
	public void testFindByNameInvalid() throws Exception {
		String webMethod = "/findByName/";
		String parameter = "Teste Restaurante";

		MvcResult result = this.mockMvc
				.perform(get(URL_SERVICE + webMethod + parameter).contentType(APPLICATION_JSON_UTF8))
				.andExpect(status().isInternalServerError()).andExpect(content().contentType("application/json;charset=UTF-8"))
				.andReturn();

		LOGGER.info("Result TestFindByNameInvalid -> " + result.getResponse().getContentAsString());
	}
}
