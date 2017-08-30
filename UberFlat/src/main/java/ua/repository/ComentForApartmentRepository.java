package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.ComentForApartment;

public interface ComentForApartmentRepository extends JpaRepository<ComentForApartment, Integer>, JpaSpecificationExecutor<ComentForApartment>{

	
	List<ComentForApartment> findComentsByApartmentId (int id);
	
	
}
