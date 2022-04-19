# SpringBoot_User_REST-APi_RestTemplate

REST TEMPLATE URL


/template/getusers

/template/deleteuser/{id}

/template/createuser

/template/updateuser/{id}
____________________________________________IMP_____________________________________+_+_+_+__+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_
Both Application Port Must Be Different

Rest Template is used to create applications that consume RESTful Web Services. You can use the exchange() method to consume the web services for all HTTP methods.

RestTemplate is used to make HTTP Rest Calls.
____________________________________________IMP________________________________________+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+__+_+_+_++_+_+_

There RestTemplate class is interacting with the Already running Spring Boot Application on another server 
this is accessing thaty URL and 


Example of All Methods GET/POST/PUT/DELETE using RestTemplate



_________________________________________________________________GET_________________________________________________________


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
	 
	 
	 
	 
	 
	 _________________________________________________________PUT_______________________________________________________________
	 
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
	
	
	_______________________________________________________________POST__________________________________________________________________
	
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
	
	
	
	
	______________________________________________________________________DELETE________________________________________________________________
	
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
	
	
	
	_____________________________________________________________IMPORTANT_____________________________________________________________________
	HERE>>>
	
	HttpEntity<String> en = new HttpEntity<String>(headers);        GET
	
	HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(rec,headers);   PUT
	
	HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(entityRec,headers);   POST
	
	HttpEntity<UserEntity> entity = new HttpEntity<UserEntity>(header);   DELETE    
	
	above When we have to update / Insert the Entry we pass it with headers 
	else When we have to Just get / Delete the Entry we just Pass headers
	
	
	
	#   Here The URL of Another Spring Boot Application should be proper AND that application SHOULD BE RUNNING on another port
	#The Thing Which We Use To do using Post man now Its Done By RestTemplate 
	#RestTemplate is used to Consume The Spring Boot Rest Application 
	
	Here It IS using the URL AUR MAKING THE REQUEST INTERNALLY USING exchange methods and accept the arguments is mentioned	below
	
	
	restTemplate.exchange( GET_ALL_USER, HttpMethod.GET ,entity , String.class).getBody();
	Arguments are ( URL OF APPLICATION , WHICH HTTP METHOD IT IS , ENTITY IN WHICH HEADER IS PASS(OBJECT OF HttpEntity<POJO JAVA CLASSTO REC OBJ> , Class In which you want Output )
	
	
