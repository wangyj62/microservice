package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LBService {

	@Autowired
	protected RestTemplate restTemplate;

	public String hi() { 
		String greeting = restTemplate.getForObject("http://usercheck", String.class);
		return String.format("%s, %s!", greeting, "meidi");
	}

}
