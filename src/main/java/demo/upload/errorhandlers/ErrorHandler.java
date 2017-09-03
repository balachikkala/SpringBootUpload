package demo.upload.errorhandlers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(value=PATH)
	public String genericHandler()
	{
		
		return "This request not handled by our Spring Boot Application yet...";
	}

	@Override
	public String getErrorPath() {	
		return PATH;
	}

}
