package com.ikeguang.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @ Author: keguang
 * @ Date: 2019/6/19 20:26
 * @ version: v1.0.0
 * @ description:
 */

@RestController
public class HelloController {
	
	@Autowired
	private ObjectMapper objectMapper;

    @RequestMapping("/hello")
    public Object hello(Locale locale, Model model) throws JsonProcessingException{
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("id", 1111);
    	map.put("name", "养生粥");
    	map.put("date", new Date());
        return objectMapper.writeValueAsString(map);
    }
}
