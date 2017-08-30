package ua.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.domain.view.ApartmentMain;
import ua.entity.ComentForApartment;
import ua.entity.OrderEntity;
import ua.service.ApartmentService;
import ua.service.ComentForApartmentService;
import ua.service.OrderService;

@Controller
@RequestMapping("/apartmentMain/{id}")
@SessionAttributes("apartmentMain")
public class AparnmentMainController {
	
	private final ApartmentService service;
	private final ComentForApartmentService comentService;
	private final OrderService orderService;

	


	@ModelAttribute("order")
	public OrderEntity getOrder(){
		return new OrderEntity();
	}
	
	@PostMapping("/addOrder")
	public String saveOrder(@ModelAttribute("order")OrderEntity order, @PathVariable Integer id){
		
		order.setApartmentId(service.findOne(id));
		orderService.save(order);
		
		
		
		return "redirect:/apartmentMain/"+id;
	}
	

	@Autowired
	public AparnmentMainController(ApartmentService service, ComentForApartmentService comentService,
			OrderService orderService) {
		super();
		this.service = service;
		this.comentService = comentService;
		this.orderService = orderService;
	}


	@ModelAttribute("apartmentMain")
	public ApartmentMain getForm(){
		return new ApartmentMain();
	}
	
	

	@ModelAttribute("comentForApartment")
	public ComentForApartment getComent(){
		return new ComentForApartment();
	}
	
	
	@GetMapping
	public String show(Model model,@PathVariable Integer id){
		model.addAttribute("apartment", service.findOne(id));
		model.addAttribute("rentType", service.findRentTypeNames());
		model.addAttribute("area", service.findAreaNames());
		model.addAttribute("street", service.findStreetNames());
		model.addAttribute("comentForApartments", comentService.findComentsByApartmentId(id));
		return "apartmentMain";
	}
	
	@PostMapping("/addcoment")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String addComent(@ModelAttribute("comentForApartment") ComentForApartment coment, @PathVariable Integer id){
		
		coment.setApartment(service.findOne(id));
		comentService.save(coment);
		
	return "redirect:/apartmentMain/"+id;
	}
	
}
