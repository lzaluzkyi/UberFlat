package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.StreetRepository;
import ua.validation.annotation.UniqueStreet;

@Component
	public class UniqueStreetValidator implements ConstraintValidator<UniqueStreet, String>{

		@Autowired
		private StreetRepository repository;
		
		@Override
		public void initialize(UniqueStreet annotation) {
			
		}

		@Override
		public boolean isValid(String name, ConstraintValidatorContext context) {
			return repository.findByName(name) == null;
		}

	}
