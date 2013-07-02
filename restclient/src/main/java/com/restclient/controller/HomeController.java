package com.restclient.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.restclient.domain.UserInfo;

@Controller
public class HomeController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/home")
	public ModelAndView homePage(Model model, HttpServletResponse response)
			throws IOException {
	
		Map<String,String> vars=new HashMap<String, String>();
		vars.put("name","Sujit");
		UserInfo userInfo=restTemplate.getForObject("http://localhost:8080/test/testrest/{name}", UserInfo.class, vars);
		System.out.println(userInfo.getName());
		System.out.println(userInfo.getAddress());
		return new ModelAndView("home");
	}	
}
