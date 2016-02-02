package ibm.ob.web.restful.services;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import ibm.ob.web.rest.services.UserWebService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/testing-context.xml" })
public class TestPublicWebService extends AbstractTestService{

	@Autowired
	private UserWebService userWebService;
	
	@Before
	@Override
	public void setUp() {		
		super.setUp();		
	} 
	
	
	
}
