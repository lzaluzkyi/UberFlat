package ua.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.ComentForUser;
import ua.repository.ComentForUserRepository;
import ua.service.ComentForUserService;
@Service
public class ComentForUserServiceImpl extends CrudServiceImpl<ComentForUser, Integer> implements ComentForUserService{
	
	private final ComentForUserRepository repository;
	
	@Autowired
	public ComentForUserServiceImpl(ComentForUserRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<ComentForUser> findComentsByUserId(int id) {
		// TODO Auto-generated method stub
		return repository.findComentsByUserId(id);
	}



}
