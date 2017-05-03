package demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("USER-LOGIN")
public interface UserClient {

    @RequestMapping(value="/hi", method=RequestMethod.GET)
    public String hi();
    
    @RequestMapping(value="/", method=RequestMethod.GET)
	public String home();

}
