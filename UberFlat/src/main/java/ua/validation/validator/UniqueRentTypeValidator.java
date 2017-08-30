package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.RentTypeRepository;
import ua.validation.annotation.UniqueRentType;

@Component
	public class UniqueRentTypeValidator implements ConstraintValidator<UniqueRentType, String>{

		@Autowired
		private RentTypeRepository repository;
		
		@Override
		public void initialize(UniqueRentType annotation) {
			
		}

		@Override
		public boolean isValid(String name, ConstraintValidatorContext context) {
			return repository.findByName(name) == null;
		}

	}