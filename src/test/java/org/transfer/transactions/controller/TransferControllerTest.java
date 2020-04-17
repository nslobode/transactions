package org.transfer.transactions.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TransferControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void performTransaction() throws Exception {
		mockMvc.perform(post("/transfer")
				.param("source", "11")
				.param("target", "33")
				.param("amount", "100"))
				.andExpect(status().isOk());
	}

	@Test
	public void getAllUsers() throws Exception {
		mockMvc.perform(get("/users"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray());
	}

	@Test
	public void getAmount() throws Exception {
		mockMvc.perform(get("/users/{id}", 11))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("1000"));
	}
}