package ua.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "_order")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer OrderId;

	@ManyToOne(fetch = LAZY)
	private Apartment apartmentId;
	
	private String start;
	
	private String end;
	
	@ManyToOne(fetch = LAZY)
	private UserEntity userId;
	
	



	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public Apartment getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(Apartment apartmentId) {
		this.apartmentId = apartmentId;
	}





	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}
	

}
