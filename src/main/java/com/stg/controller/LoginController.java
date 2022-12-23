/*
 * package com.stg.controller;
 * 
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * com.stg.service.LoginServiceInterface;
 * 
 * 
 * 
 * @RestController
 * 
 * @RequestMapping(value = "login") public class LoginController {
 * 
 * @Autowired private LoginServiceInterface loginService;
 * 
 * 
 * @GetMapping(value = "userLogin") public ResponseEntity<String>
 * userLogin(@RequestParam String emailId,@RequestParam String pasword){ return
 * new
 * ResponseEntity<String>(loginService.userLogin(emailId,pasword),HttpStatus.OK)
 * ; }
 * 
 * 
 * @GetMapping(value = "adminLogin") public ResponseEntity<String>
 * adminLogin(@RequestParam String emailId,@RequestParam String pasword){ return
 * new
 * ResponseEntity<String>(loginService.adminLogin(emailId,pasword),HttpStatus.OK
 * ); }
 * 
 * }
 */