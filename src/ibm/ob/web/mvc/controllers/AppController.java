package ibm.ob.web.mvc.controllers;

import ibm.ob.constants.Constants;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {	
	
	@RequestMapping("/")
	public ModelAndView app(){		
		return new ModelAndView(Constants.VIEW_APP);
	}
	
	@RequestMapping("/help")
	public ModelAndView help(){		
		return new ModelAndView(Constants.VIEW_HELP);
	}	
	
}
