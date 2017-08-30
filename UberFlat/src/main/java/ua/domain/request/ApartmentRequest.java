package ua.domain.request;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Area;
import ua.entity.ComentForApartment;
import ua.entity.RentType;
import ua.entity.Street;
import ua.entity.UserEntity;

public class ApartmentRequest {

	private Integer id;
	
	private MultipartFile file;
	
	private String price;
	
	private RentType rentType;
	
	private String rooms;
	
	private Area area;
	
	private Street street;
	
	private String number;

	private String description;
	
	private UserEntity owner;
	
	private ComentForApartment comentForApartment;
	

	
	
	public ApartmentRequest() {
	}

	


	public ApartmentRequest(Integer id, MultipartFile file, String price, RentType rentType, String rooms, Area area,
			Street street, String number, String description, UserEntity owner, ComentForApartment comentForApartment) {
		super();
		this.id = id;
		this.file = file;
		this.price = price;
		this.rentType = rentType;
		this.rooms = rooms;
		this.area = area;
		this.street = street;
		this.number = number;
		this.description = description;
		this.owner = owner;
		this.comentForApartment = comentForApartment;
	}




	public ComentForApartment getComentForApartment() {
		return comentForApartment;
	}




	public void setComentForApartment(ComentForApartment comentForApartment) {
		this.comentForApartment = comentForApartment;
	}




	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public RentType getRentType() {
		return rentType;
	}

	public void setRentType(RentType rentType) {
		this.rentType = rentType;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
