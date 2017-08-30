package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.RentType;

public interface RentTypeService extends CrudService<RentType, Integer>{

	List<String> findNames();
	
	RentType findByName(String name);
	
	Page<RentType> findAll(Pageable pageable, SimpleFilter filter);
}
