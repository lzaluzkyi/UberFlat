package ua.service.implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.entity.OrderEntity;
import ua.service.OrderService;

@Service
public class OrderServiceImpl  extends CrudServiceImpl<OrderEntity, Integer> implements OrderService{

	public OrderServiceImpl(JpaRepository<OrderEntity, Integer> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrderEntity FindOneByStart() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
