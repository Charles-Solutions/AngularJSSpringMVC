package ibm.ob.web.restful.services;

import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;

public class AbstractTestService {

    private MockMvc mockMvc;
    private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
    
	@Autowired	
	private AuthenticationManager authenticationManager;
	
	public void setUp() {
		this.httpServletRequest = mock(HttpServletRequest.class);
		this.httpServletResponse = mock(HttpServletResponse.class);
	}

	protected MockMvc getMockMvc() {
        return this.mockMvc;
    }
    
    protected void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
    
    protected HttpServletRequest getHttpServletRequest() {
		return this.httpServletRequest;
	}
    
    protected HttpServletResponse getHttpServletResponse() {
		return this.httpServletResponse;
	}

}
