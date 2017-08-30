package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.entity.RentType;

public interface RentTypeRepository extends JpaRepository<RentType, Integer>, JpaSpecificationExecutor<RentType>{

	@Query("SELECT rt.name FROM RentType rt")
	List<String> findNames();

	RentType findByName(String name);

	
}
