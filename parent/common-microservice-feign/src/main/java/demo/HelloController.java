package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private UserClient userClient;

	@RequestMapping(value = "hi", method = RequestMethod.GET)
	public String getHello() {
		return userClient.hi();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return userClient.home();
	}

}
