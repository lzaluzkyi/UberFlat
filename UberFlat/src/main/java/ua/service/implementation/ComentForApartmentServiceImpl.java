package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.ComentForApartment;
import ua.repository.ComentForApartmentRepository;
import ua.service.ComentForApartmentService;
@Service
public class ComentForApartmentServiceImpl extends CrudServiceImpl<ComentForApartment, Integer> implements ComentForApartmentService{

	private final ComentForApartmentRepository repository;

	@Autowired
	public ComentForApartmentServiceImpl(ComentForApartmentRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<ComentForApartment> findComentsByApartmentId(int id) {
		// TODO Auto-generated method stub
		return repository.findComentsByApartmentId(id);
	}
	
	
	
	 
	
}
