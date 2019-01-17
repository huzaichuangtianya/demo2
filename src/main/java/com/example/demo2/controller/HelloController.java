package com.example.demo2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.bean.User;
import com.example.demo2.mapper.UserMapper;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String index() {
		return "Hello Spring Boot 2.0!";
	}

	@RequestMapping("/index1")
	public String index1() {
		return "index";
	}

	@RequestMapping("/query")
	public List<Map<String, Object>> query() {

		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
		return list;
	}

	@RequestMapping("/query1")
	public List<User> query1() {
		List<User> users = userMapper.getAll();
        System.out.println("kan:"+users.toString());
        
//		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
		return users;
	}
}