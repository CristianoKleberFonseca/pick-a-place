package br.com.dbserver.pickaplace.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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

public class TestVoteController extends PickAPlaceApplicationTests {

	private static final Logger LOGGER = LogManager.getLogger(TestVoteController.class);
	public static final String URL_SERVICE = "/api/votes";
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
	public void testVoting() throws Exception {
		String webMethod = "/voting";
		MvcResult result = null;
		List<String> requestsJson = new ArrayList<String>();
		requestsJson.add("{\"user\":{\"userName\":\"userone\",\"password\": \"123456\"},\"restaurant\":{\"id\":1}}");
		requestsJson.add("{\"user\":{\"userName\":\"usertwo\",\"password\": \"234567\"},\"restaurant\":{\"id\":1}}");
		requestsJson.add("{\"user\":{\"userName\":\"userthree\",\"password\": \"345678\"},\"restaurant\":{\"id\":2}}");
		requestsJson.add("{\"user\":{\"userName\":\"userfour\",\"password\": \"456789\"},\"restaurant\":{\"id\":3}}");
		requestsJson.add("{\"user\":{\"userName\":\"userfive\",\"password\": \"567890\"},\"restaurant\":{\"id\":5}}");
		requestsJson.add("{\"user\":{\"userName\":\"usersix\",\"password\": \"678901\"},\"restaurant\":{\"id\":5}}");
		requestsJson.add("{\"user\":{\"userName\":\"userseven\",\"password\": \"789012\"},\"restaurant\":{\"id\":5}}");

		for (String requestJson : requestsJson) {
			result = this.mockMvc.perform(post(URL_SERVICE + webMethod)
					.contentType(TestFavoritesController.APPLICATION_JSON_UTF8).content(requestJson))
					.andExpect(status().isOk()).andReturn();
			LOGGER.info("Result TestVoting -> " + result.getResponse().getContentAsString());
		}
	}

}
