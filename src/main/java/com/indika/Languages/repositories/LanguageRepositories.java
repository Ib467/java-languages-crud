package com.indika.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indika.Languages.models.Language;


public interface LanguageRepositories extends CrudRepository<Language, Long>{
	List<Language> findAll();
	
	
	
	
}
