package com.javaee6.webmvc.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javaee6.webmvc.demo.model.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return BookDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Title not null
		//Must start with capital letter
		log.info("BookDTO validation started");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.book.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required.book.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.book.description");
		BookDto book = (BookDto)target;
		if(!book.getTitle().isEmpty())
		{
			String firstChar = book.getTitle().charAt(0)+"";
			if(!firstChar.toUpperCase().equals(firstChar))
			{
				errors.rejectValue("title", "uppercase");
			}

		}
	}

}
