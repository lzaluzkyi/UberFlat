package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.filter.SimpleFilter;
import ua.entity.RentType;
import ua.service.RentTypeService;

@Controller
@RequestMapping("/admin/rentType")
@SessionAttributes("rentType")
public class AdminRentTypeController {

	private final RentTypeService service;

	
	@Autowired
	public AdminRentTypeController(RentTypeService service) {
		this.service = service;
	}
	
	@ModelAttribute("rentType")
	public RentType getForm(){
		return new RentType();
	}
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("rentTypes", service.findAll(pageable, filter));
		return "rentType";
	}
	
	@PostMapping
	public String add(@ModelAttribute("rentType") @Valid RentType rentType, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		if(br.hasErrors()){
			show(model, pageable, filter);
			return "rentType";
		}
		service.save(rentType);
		status.setComplete();
		return "redirect:/admin/rentType"+buildParams(pageable, filter);
}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("rentType", service.findOne(id));
		show(model, pageable, filter);
		return "rentType";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id ,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		service.delete(id);
		return "redirect:/admin/rentType"+buildParams(pageable, filter);
	}
	private String buildParams(Pageable pageable, SimpleFilter filter) {
		StringBuilder sb = new StringBuilder();
		sb.append("?page=");
		sb.append(pageable.getPageNumber());
		sb.append("&size=");
		sb.append(pageable.getPageSize());
		if(!filter.getSearch().isEmpty()) {
			sb.append("&search=");
			sb.append(filter.getSearch());
		}
		if(pageable.getSort()!=null){
			sb.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				sb.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC) sb.append(",desc");
			});
		}
		return sb.toString();
	}
	
	
}
