package ibm.ob.web.restful.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import ibm.ob.web.rest.services.UserWebService;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/testing-context.xml" })
public class TestUserWebService extends AbstractTestService{

	@Autowired
	private UserWebService userWebService;
	
	@Before
	@Override
	public void setUp() {		
		super.setUp();		
	} 
	
	@Test
	public void checkHttpRquest() throws Exception{	

		getMockMvc().perform(MockMvcRequestBuilders.get("/webservice/user/save"))
														.andExpect(jsonPath("$.name").value("alex"))														
														.andDo(print())
														.andExpect(status().isOk());
		
	   
	}
	
	
}
