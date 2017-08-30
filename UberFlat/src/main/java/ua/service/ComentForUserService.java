package ua.service;

import java.util.List;

import ua.entity.ComentForUser;

public interface ComentForUserService extends CrudService<ComentForUser, Integer>{
	
	List<ComentForUser> findComentsByUserId(int id);

}
