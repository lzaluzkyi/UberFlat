package ua.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueArea;

@Entity
@Table(name="area")
public class Area {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@NotBlank
	@UniqueArea
	private String name;
	
	@OneToMany(mappedBy="area")
	private List<Apartment> apartments = new ArrayList<>();

	public Area(String name) {
		this.name = name;
	}

	public Area() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}
}
