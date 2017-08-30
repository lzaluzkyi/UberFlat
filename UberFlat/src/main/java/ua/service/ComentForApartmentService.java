package ua.service;

import java.util.List;

import ua.entity.ComentForApartment;

public interface ComentForApartmentService extends CrudService<ComentForApartment, Integer>{
	
	List<ComentForApartment> findComentsByApartmentId(int id);

}
