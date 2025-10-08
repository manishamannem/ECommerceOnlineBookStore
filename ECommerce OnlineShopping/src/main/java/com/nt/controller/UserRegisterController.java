package com.nt.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.UserRegister;
import com.nt.model.ResponseMessage;
import com.nt.model.UserRequest;
import com.nt.model.UserRequestDto;
import com.nt.service.UserRegisterService;
import com.nt.utility.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "UserRegisterController ",description = "UserRegister Regsiter and Login")
@RestController
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	 @Operation(summary = "Create User Register",description = "e commerece online books store  register the users")
	    @ApiResponses({
	     @ApiResponse(responseCode = "201",description = "user register successfully"),
	     @ApiResponse(responseCode = "400",description = "user register failure"),
	     @ApiResponse(responseCode = "500",description = "Internal server error")
	     })
	@PostMapping("/userregisters")
	public ResponseEntity<ResponseMessage> createUserRegister(@RequestBody UserRequestDto userRequestDto) {
	   
		try {
		if(userRequestDto.getEmail()==null || userRequestDto.getEmail().isEmpty() || userRequestDto.getPassword() ==null || userRequestDto.getPassword().isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "email and passowrd cannot be empty"));
		}
		 UserRegister userRegister = userRegisterService.insertUserRegister(userRequestDto);
		 if(userRegister!=null) {
//		       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "online bookstore save successfully", userRegister));
				return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "online bookstore save successfully" ,userRegister));
		 }else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "User Register Failed" ,userRegister));
 
		 }}catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED, "Internal server error"));
		}
	}
	
	 
	 @Operation(summary = "Create User Register",description = "e commerece online books store  register the users")
	    @ApiResponses({
	     @ApiResponse(responseCode = "200",description = "user Login successfully"),
	     @ApiResponse(responseCode = "400",description = "user Login failure"),
	     @ApiResponse(responseCode = "500",description = "Internal server error")
	     })
	@PostMapping("/userlogin")
	public ResponseEntity<ResponseMessage> checkLogin(@RequestBody UserRequestDto userRequestDto) {
	   
		try {
		if(userRequestDto.getEmail()==null || userRequestDto.getEmail().isEmpty() || userRequestDto.getPassword() ==null || userRequestDto.getPassword().isEmpty()) {
			
		       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "email and passowrd cannot be empty"));

		}
		  UserRegister checkUserDetails = userRegisterService.checkUserDetails(userRequestDto);
		 if(checkUserDetails!=null) {
			 
		       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_OK, Constants.SUCCESS, "Login successfully" ,checkUserDetails));

		 }else {
		       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Invalid creditials...!"));

		 }}catch (Exception e) {
			 e.printStackTrace();
		       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED, "Internal server error"));

		}
	}
	  
	 
	 @GetMapping("/userDetails/{id}")
	 public UserRequest	 getMethodName(@PathVariable Long id) {
		 UserRequest registerDetails = userRegisterService.getUserRegisterDetails(id);
		 return registerDetails;
	 	
	 }

}
