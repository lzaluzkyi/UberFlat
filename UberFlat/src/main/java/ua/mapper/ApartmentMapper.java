package ua.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import ua.domain.request.ApartmentRequest;
import ua.domain.view.ApartmentIndex;
import ua.entity.Apartment;

public interface ApartmentMapper {

	public static ApartmentIndex toApartmentIndex(Apartment apartment){
		Integer id = apartment.getId();
		String photoUrl = apartment.getPhotoUrl();
		Integer version = apartment.getVersion();
		BigDecimal price = apartment.getPrice();
		String rentType = apartment.getRentType().getName();
		String area = apartment.getArea().getName();
		BigDecimal rate = apartment.getRate();
		int rooms = apartment.getRooms();
		return new ApartmentIndex(id, photoUrl, version, price, rentType, area, rate, rooms);
	}
	
	public static List<ApartmentIndex> toApartmentIndex(List<Apartment> apartments){
		return apartments.stream()
				.map(ApartmentMapper::toApartmentIndex)
				.collect(Collectors.toList());
	}
	
	public static Apartment toApartment(ApartmentRequest request){
		Apartment apartment = new Apartment();
		apartment.setArea(request.getArea());
		apartment.setDescription(request.getDescription());
		apartment.setId(request.getId());
		apartment.setNumber(request.getNumber());
		apartment.setPrice(new BigDecimal(request.getPrice()));
		apartment.setRentType(request.getRentType());
		apartment.setRooms(Integer.valueOf(request.getRooms()));
		apartment.setStreet(request.getStreet());
		apartment.setOwner(request.getOwner());
		return apartment;
	}
}
