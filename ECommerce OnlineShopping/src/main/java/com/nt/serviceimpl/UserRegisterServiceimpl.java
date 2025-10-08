package com.nt.serviceimpl;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Dao.UserRegisterRepo;
import com.nt.entity.UserRegister;
import com.nt.model.UserRequest;
import com.nt.model.UserRequestDto;
import com.nt.service.UserRegisterService;
@Service
public class UserRegisterServiceimpl implements UserRegisterService {
	
	
	@Autowired
	private UserRegisterRepo userRegisterRepo;

	@Override
	public UserRegister insertUserRegister(UserRequestDto userRequestDto) {
		UserRegister user=new UserRegister();
		try {
			user.setFirstname(userRequestDto.getFirstName());
			user.setLastname(userRequestDto.getLastName());
			user.setEmail(userRequestDto.getEmail());
			user.setPassword(Base64.getEncoder().encodeToString(userRequestDto.getPassword().getBytes()));
			user.setMobileno( userRequestDto.getMobileno());
		userRegisterRepo.save(user);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;


}
	
@Override
public UserRequest getUserRegisterDetails(Long id) {
	 Optional<UserRegister> byId = userRegisterRepo.findById(id);
	UserRegister userRegister = byId.get();
	return new UserRequest(userRegister.getFirstname(), userRegister.getLastname());
}

@Override
public UserRegister checkUserDetails(UserRequestDto userRequestDto) {
	
	UserRegister findbyEmail = userRegisterRepo.findByEmail(userRequestDto.getEmail());
	
	if(findbyEmail!=null) {
		
		String decode = new String(Base64.getDecoder().decode(findbyEmail.getPassword()));
		
		if(decode.equals(userRequestDto.getPassword())) {
			
			return findbyEmail;
		}
		
	}
	return findbyEmail;
	
//	return Optional.ofNullable(userRegisterRepo.findByEmail(userRequestDto.getEmail()))
//			       .filter(user -> new String(Base64.getDecoder().decode(user.getPassword()))
//			       .equals(userRequestDto.getPassword()))
//                   .orElse(null); 


	
	
	
	
}

}
