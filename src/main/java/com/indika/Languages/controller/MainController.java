package com.indika.Languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indika.Languages.Services.LanguageService;
import com.indika.Languages.models.Language;

@Controller
public class MainController {

        private final LanguageService languageService;

        public MainController(LanguageService languageService) {
            this.languageService = languageService;
        }

        @RequestMapping("/languages")
        public String index(Model model, @ModelAttribute("language") Language language) {
            List<Language> languages =languageService.getAllLanguages();
            model.addAttribute("languages", languages);
            return "index.jsp";
        }
        
        
//        @RequestMapping("/languages/new")
//        public String newLanguage(@ModelAttribute("language") Language language) {
//        	if (result.hasErrors()) {
//                return "index.jsp";
//            } else {
//            	languageService.createLanguage(language);
//                return "redirect:/languages";
//            }
//        //errors on the adding new language
//        
//        
        
        
        
        //create a new language
        @RequestMapping(value="/languages", method=RequestMethod.POST)
        public String create(@Valid @ModelAttribute("book") Language language, BindingResult result) {
            if (result.hasErrors()) {
                return "new.jsp";
            } else {
                languageService.createLanguage(language);
                return "redirect:/languages";
            }
        }
        
        //edit 
        @RequestMapping("/languages/{id}")
        public String show(@PathVariable("id")Long id, Model model) {
            Language oneLanguage = languageService.getLanguageById(id);
            model.addAttribute("language", oneLanguage);
            return "view.jsp";
        }
        
        

        
        //delete method 
        @GetMapping(value="/languages/{id}/delete")
        public String destroy(@PathVariable("id") Long id) {
            languageService.deleteLanguage(id);
            return "redirect:/languages";
        }
        
      
        @RequestMapping("/languages/{id}/show")
        public String show2(@PathVariable("id")Long id, Model model) {
            Language oneLanguage = languageService.getLanguageById(id);
            model.addAttribute("language", oneLanguage);
            return "langview.jsp";
        }

}
