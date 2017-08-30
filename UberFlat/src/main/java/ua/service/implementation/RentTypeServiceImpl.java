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
import ua.entity.RentType;
import ua.repository.RentTypeRepository;
import ua.service.RentTypeService;

@Service
public class RentTypeServiceImpl extends CrudServiceImpl<RentType, Integer> implements RentTypeService{

	private final RentTypeRepository repository;
	
	@Autowired
	public RentTypeServiceImpl(RentTypeRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<String> findNames() {
		return repository.findNames();
	}

	@Override
	public RentType findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Page<RentType> findAll(Pageable pageable, SimpleFilter filter) {
		// TODO Auto-generated method stub
		return repository.findAll(getSpecification(filter), pageable);
	}

	private Specification<RentType> getSpecification(SimpleFilter filter) {
				return new Specification<RentType>() {
			@Override
			public Predicate toPredicate(Root<RentType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
	}
}