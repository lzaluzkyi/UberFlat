package ua.service.implementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.domain.filter.SimpleFilter;
import ua.entity.Street;
import ua.repository.StreetRepository;
import ua.service.StreetService;

@Service
public class StreetServiceImpl extends CrudServiceImpl<Street, Integer> implements StreetService{

	private final StreetRepository repository;
	
	@Autowired
	public StreetServiceImpl(StreetRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<String> findNames() {
		return repository.findNames();
	}

	@Override
	public Street findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Page<Street> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}

	private Specification<Street> getSpecification(SimpleFilter filter) {
		return new Specification<Street>() {
			@Override
			public Predicate toPredicate(Root<Street> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
	}
}