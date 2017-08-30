package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.filter.SimpleFilter;
import ua.entity.Street;

public interface StreetService extends CrudService<Street, Integer>{

	List<String> findNames();

	Street findByName(String name);
	
	Page<Street> findAll(Pageable pageable, SimpleFilter filter);
}
