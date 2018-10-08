package br.com.dbserver.pickaplace.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.dbserver.pickaplace.PickAPlaceApplicationTests;
import br.com.dbserver.pickaplace.untils.DateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestResultController extends PickAPlaceApplicationTests {
	
	private static final Logger LOGGER = LogManager.getLogger(TestResultController.class);	
	public static final String URL_SERVICE = "/api/resutls";
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	public void voting() throws Exception {
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
			result = this.mockMvc.perform(post(TestVoteController.URL_SERVICE + webMethod)
					.contentType(TestFavoritesController.APPLICATION_JSON_UTF8).content(requestJson))
					.andExpect(status().isOk()).andReturn();
			LOGGER.info("Result TestVoting -> " + result.getResponse().getContentAsString());
		}
	}
	
	@Test
	public void testResult1() throws Exception {
		String webMethod = "/votingProcessingResult";
		this.voting();
		MvcResult result = this.mockMvc.perform(get(URL_SERVICE+webMethod).contentType(TestFavoritesController.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		LOGGER.info("Result TestVotingProcessingResult -> "+result.getResponse().getContentAsString());
	}

	@Test
	// ESTORIA 3 - Mostrar de alguma forma o resultado da votação.
	public void testResult2() throws Exception {
		String webMethod = "/checkingResult/";
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(DateUtil.USA_FORMAT);
		String parameters = simpleDateFormate.format(new Date());
	    String url = URL_SERVICE+webMethod+parameters;
		MvcResult result = this.mockMvc.perform(get(url).contentType(TestFavoritesController.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		LOGGER.info("Result TestVotingProcessingResult -> "+result.getResponse().getContentAsString());
	}

}
