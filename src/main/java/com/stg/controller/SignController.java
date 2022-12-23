package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stg.dto.UserSign;
import com.stg.entity.Admin;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.service.SignServiceInterface;

@RestController
//@RequestMapping("Sign")
public class SignController {
	@Autowired
	private SignServiceInterface signServiceInterface;

	//@GetMapping(value = "value")
	public List<User> showUser() {
		return signServiceInterface.showUser();

	}
}
