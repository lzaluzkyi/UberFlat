package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.ComentForUser;

public interface ComentForUserRepository extends JpaRepository<ComentForUser, Integer>, JpaSpecificationExecutor<ComentForUser>{
	
	List<ComentForUser> findComentsByUserId (int id);

}
