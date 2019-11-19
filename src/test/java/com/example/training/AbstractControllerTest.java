package com.example.training;

import org.junit.Before;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public abstract class AbstractControllerTest {
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(getTestedController()).build();
	}

	protected MockMvc getMockMvc() {
	    return mockMvc;
    }

    protected abstract Object getTestedController();
	
}
