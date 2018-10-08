package br.com.dbserver.pickaplace.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

public class TestFavoritesController extends PickAPlaceApplicationTests {

	private static final Logger LOGGER = LogManager.getLogger(TestFavoritesController.class);
	public static final String URL_SERVICE = "/api/favorites";
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
		String webMethod = "/saveFavorites";
		String requestJson = "{\"idEmployee\": 1,\"idRestaurant\": 1}";

		MvcResult result = this.mockMvc.perform(post(URL_SERVICE + webMethod)
				.contentType(TestFavoritesController.APPLICATION_JSON_UTF8).content(requestJson))
				.andExpect(status().isOk()).andReturn();

		LOGGER.info("Result TestSaveFavorites -> " + result.getResponse().getContentAsString());
	}

	@Test
	public void testFindFavoritesByIdEmployee() throws Exception {
		String webMethod = "/findByEmployee/";
		Long idEmployee = 1L;

		MvcResult result = this.mockMvc
				.perform(get(URL_SERVICE + webMethod + idEmployee)
						.contentType(TestFavoritesController.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andReturn();

		LOGGER.info("Result TestFindFavoritesByIdEmployee -> " + result.getResponse().getContentAsString());
	}

	@Test
	public void testSaveFavoritesInvalidIdEmployee() throws Exception {
		String webMethod = "/saveFavorites";
		String requestJson = "{\"idEmployee\": 1000,\"idRestaurant\": 1}";
		
		MvcResult result = this.mockMvc.perform(post(URL_SERVICE + webMethod)
				.contentType(TestFavoritesController.APPLICATION_JSON_UTF8).content(requestJson))
				.andExpect(status().isInternalServerError()).andReturn();

		LOGGER.info("Result TestSaveFavoritesInvalidIdEmployee -> " + result.getResponse().getContentAsString());
	}
}
