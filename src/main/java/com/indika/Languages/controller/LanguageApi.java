package com.indika.Languages.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indika.Languages.Services.LanguageService;
import com.indika.Languages.models.Language;



@RestController
public class LanguageApi {
 private final LanguageService languageService;
 public LanguageApi(LanguageService languageService){
     this.languageService = languageService;
 }



 @RequestMapping("/api/languages")
 public List<Language> index() {
     return languageService.getAllLanguages();
 }

 @RequestMapping(value="/api/languages", method=RequestMethod.POST)
 public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String version) {
     Language lang = new Language(name,creator,version);
     return languageService.createLanguage(lang);
 }

 @RequestMapping("/api/languages/{id}")
 public Language show(@PathVariable("id") Long id) {
     Language lang = languageService.getLanguageById(id);
     return lang;
 }
 @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
 public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String version) {
     Language lang = languageService.updateLanguage(id,name,creator,version);
     return lang;
 }

 
 @DeleteMapping(value="/api/languages/{id}")
 public void destroy(@PathVariable("id") Long id) {
     languageService.deleteLanguage(id);
 }
 
 
}
