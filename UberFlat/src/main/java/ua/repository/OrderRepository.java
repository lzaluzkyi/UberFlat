package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.OrderEntity;

public interface OrderRepository  extends JpaRepository<OrderEntity, Integer>, JpaSpecificationExecutor<OrderEntity>{
	
	

}
