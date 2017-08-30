package ua.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.domain.request.RegistrationRequest;
import ua.entity.UserEntity;
import ua.repository.UserEntityRepository;
import ua.service.UserService;
import static ua.mapper.UserMapper.*;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{
	
	private final UserEntityRepository repository;
	
	private final PasswordEncoder encoder;
	
	@Autowired
	public UserServiceImpl(UserEntityRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity entity = repository.findForAuth(login);
		if(entity==null) throw new UsernameNotFoundException("User with "+login+" not found");
		return toUser(entity);
	}

	@Override
	public void save(RegistrationRequest request) {
		UserEntity entity = toUserEntity(request);
		entity.setPassword(encoder.encode(entity.getPassword()));
		repository.save(entity);
	}	
	
	
	public UserEntity findById(Integer id) {
		return repository.findById(id);
		
	}

	@Override
	public UserEntity findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
