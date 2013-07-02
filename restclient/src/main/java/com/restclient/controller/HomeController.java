package com.restclient.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.restclient.domain.UserInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
public class HomeController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping(value = "/home")
	public ModelAndView homePage(Model model, HttpServletResponse response)
			throws IOException {
	
		//Using spring resttemplate
		Map<String,String> vars=new HashMap<String, String>();
		vars.put("name","Sujit");
		UserInfo userInfo=restTemplate.getForObject("http://localhost:8080/test/testrest/{name}", UserInfo.class, vars);
		System.out.println(userInfo.getName());
		System.out.println(userInfo.getAddress());
		
		
		//Using Jersey client
		Client client=new Client();
		WebResource resource=client.resource("http://localhost:8080/test");
		resource.accept("application/json");
		String clientResponse=resource.path("testrest").path("Sujit").get(String.class);
		UserInfo userInfo2=mapper.readValue(clientResponse,UserInfo.class);
		System.out.println(userInfo2.getName());
		System.out.println(userInfo2.getAddress());
		
		return new ModelAndView("home");
	}	
}
