package demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Random;

@Service
public class BookService {

	private Random random = new Random();

	private final RestTemplate restTemplate;

	public BookService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		int randomInt = random.nextInt(10);
		System.out.println("randomInt:"+randomInt);
		if (randomInt < 3) { // 模拟调用失败情况
			throw new RuntimeException("call dependency service fail.");
		} else {
			URI uri = URI.create("http://10.167.202.129:7000/recommended");
			return this.restTemplate.getForObject(uri, String.class);
		}

	}

	public String reliable() {
		return "fallbackMethod 错误回调页面";
	}

}
