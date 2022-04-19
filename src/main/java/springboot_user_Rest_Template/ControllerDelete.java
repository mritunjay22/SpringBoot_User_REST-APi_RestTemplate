package springboot_user_Rest_Template;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerDelete {
	
	@Autowired
	RestTemplate restTemplate;
	
	// this is to delete User Using RestTemplate
	private static final String DELETE_USER = "http://localhost:8080/deleteuser/";  // removed id field for custom template pass
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/template/deleteuser/{id}")
	public String deleteUser(@PathVariable String id) {
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));   // for JSON format
		
		HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(header);  //here only have to delete so only Header
		
	return	restTemplate.exchange(DELETE_USER+id, HttpMethod.DELETE, entity, String.class).getBody();
	}

}
