package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LBController {
	
	 @Autowired
	 LBService lBService;
	
	@RequestMapping(value = "/loadbalance")
    public String hi(){
        return lBService.hi();
    }


}
