package springboot_user_Rest_Template;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerGet {
	private static final String GET_ALL_USER = "http://localhost:8080/getuser";
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET,value ="/template/getusers")
	 public String getAllUser() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));   // for input format as json
		HttpEntity<String> en = new HttpEntity<String>(headers);     // here We are not updating anything so just headers
		
		
		
		System.out.println("Template get");
		return restTemplate.exchange(GET_ALL_USER, HttpMethod.GET,en,String.class).getBody();   //
	 }

	
	
	
	
}
