package com.indika.Languages.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indika.Languages.models.Language;
import com.indika.Languages.repositories.LanguageRepositories;


@Service
public class LanguageService {
    public final LanguageRepositories languageRepo;

    public LanguageService(LanguageRepositories languageRepo) {
        this.languageRepo=languageRepo;
    }
    public List<Language>getAllLanguages(){
        return this.languageRepo.findAll();
    }

    public Language createLanguage(Language l) {
        return this.languageRepo.save(l);
    }
    public Language getLanguageById(Long id) {
        Optional <Language> optionalLanguage =languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        }
        return null;
    }
    public Language updateLanguage(Long id, String name,String creator, String version) {
        Language lang=this.getLanguageById(id);
        lang.setName(name);
        lang.setCreator(creator);
        lang.setVersion(version);


        return this.languageRepo.save(lang);
    }


    public void deleteLanguage(Long id) {
        this.languageRepo.deleteById(id);
    }


}