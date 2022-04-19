package springboot_user_Rest_Template;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerPost {
	private static final String CREATE_USER = "http://localhost:8080/createuser";
	
	@Autowired
	RestTemplate restTemplate;
	
	//this is to Create User Using UserApplication URL 
	@RequestMapping(method = RequestMethod.POST,value="/template/createuser")
	public String createUser(@RequestBody UserEntity entityRec) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(entityRec,headers);
		
		return restTemplate.exchange(CREATE_USER,HttpMethod.POST, entity,String.class).getBody();	
	}
	
	
	
	
}
