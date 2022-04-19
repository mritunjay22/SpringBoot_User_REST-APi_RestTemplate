package springboot_user_Rest_Template;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerPut {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String URL = "http://localhost:8080/updateuser";  
	
	
	@RequestMapping(method = RequestMethod.PUT,value="/template/updateuser/{id}")
	public String updateUser(@RequestBody UserEntity rec , @PathVariable String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(rec,headers);
		
		 return restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class).getBody();
		 //above parameter sequence
		 //URL  ,  HttpMethod GET/POST/PUT  , entity(Object of HttpEntity , (required output class ) String.class
		
		
		
		
	}
	
	
	
	
	
	
	
}
