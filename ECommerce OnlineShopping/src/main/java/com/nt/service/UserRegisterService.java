package com.nt.service;

import com.nt.entity.UserRegister;
import com.nt.model.UserRequest;
import com.nt.model.UserRequestDto;

public interface UserRegisterService {
	public UserRegister  insertUserRegister(UserRequestDto userRequestDto);

	public UserRegister checkUserDetails(UserRequestDto userRequestDto);

	public UserRequest getUserRegisterDetails(Long id);

}