package com.udacity.pricing;

import com.udacity.pricingMicroservice.PricingServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//Done: at least one additional test has been implemented outside of contextLoads()
// for the overall Pricing Service Application.
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PricingServiceApplication.class)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;


	@Test
	public void contextLoads() {
	}

	/**
	 * Test spring data REST is working
	 */
	@Test
	public void callTest() throws Exception {
		mockMvc.perform(get("/prices"))
				.andExpect(status().isOk())
				.andExpect(content().json("{}"));
	}

}
