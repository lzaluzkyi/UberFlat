package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.filter.SimpleFilter;
import ua.domain.request.RegistrationRequest;
import ua.entity.ComentForUser;
import ua.service.ComentForUserService;
import ua.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	private final UserService service;
	
	private final ComentForUserService comentService;


	@Autowired
	public UserController(UserService service, ComentForUserService comentService) {
		super();
		this.service = service;
		this.comentService = comentService;
	}

	@ModelAttribute("user")
	public RegistrationRequest getForm(){
		return new RegistrationRequest();
	}
	
	@ModelAttribute("comentForUser")
	public ComentForUser getComent(){
		return new ComentForUser();
	}
	
	@GetMapping("/registration")
	public String registration(){
		return "registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user") RegistrationRequest request, SessionStatus status){
		service.save(request);
		status.setComplete();
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/user/{id}")
	public String show(Model model,@PathVariable Integer id){
		model.addAttribute("userEntity", service.findById(id)) ;
		model.addAttribute("comentForUsers", comentService.findComentsByUserId(id));
		return "userMain";
	}
	
	@PostMapping("/user/{id}/addcoment")
	public String addComent(@ModelAttribute("comentForUser") ComentForUser coment, @PathVariable Integer id){
		
		coment.setUser(service.findById(id));
		comentService.save(coment);
		
		return "redirect:/user/"+id;
		}
	
		
	
}
