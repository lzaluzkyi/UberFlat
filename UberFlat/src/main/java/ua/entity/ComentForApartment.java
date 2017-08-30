package ua.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="coment_for_apartment")
public class ComentForApartment {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer comentId;
	
	@NotBlank
	private String coment;
	
	@ManyToOne(fetch = LAZY)
	private Apartment apartment;
	
	

	public ComentForApartment() {
		super();
	}

	public ComentForApartment(String coment) {
		super();
		this.coment = coment;
	}
	
	public ComentForApartment(Integer comentId, String coment, Apartment apartment) {
		super();
		this.comentId = comentId;
		this.coment = coment;
		this.apartment = apartment;
	}

	public ComentForApartment(String coment, Apartment apartment) {
		super();
		this.coment = coment;
		this.apartment = apartment;
	}

	

	public Integer getComentId() {
		return comentId;
	}

	public void setComentId(Integer comentId) {
		this.comentId = comentId;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}



}
