package ua.service;

import ua.entity.OrderEntity;

public interface OrderService extends CrudService<OrderEntity, Integer>{
	
	OrderEntity FindOneByStart();
	

}
