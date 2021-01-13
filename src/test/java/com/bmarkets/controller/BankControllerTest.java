package com.bmarkets.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bmarkets.BankAccountsApplication;
import com.bmarkets.controller.BankController;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountsApplication.class)
@AutoConfigureMockMvc
class BankControllerTest {

	
	 @Autowired
	 private MockMvc mockMvc;
	 
	@Test
	void testIndexRedirection() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/operations"))
        .andExpect(MockMvcResultMatchers.model().hasNoErrors())
        .andExpect(MockMvcResultMatchers.view().name("accountsOperations"))
        .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	

}
