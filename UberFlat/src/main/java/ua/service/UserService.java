package ua.service;

import ua.domain.request.RegistrationRequest;
import ua.entity.UserEntity;

public interface UserService extends CrudService<UserEntity, Integer>{

	void save(RegistrationRequest request);
	
	public UserEntity findById(Integer id);
	
}
