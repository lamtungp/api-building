package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import models.Company;
import services.CompanyService;

@RestController
@RequestMapping(path = "/api/v1/company", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<Company> index(Model model) {
    	return service.index(); 
    }

    @GetMapping("/{id}")
    public Company show(@PathVariable("id") String id, Model model) {
    	return service.show(id); 
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public Company create(@RequestBody() Company c, Model model) {
    	return service.create(c);
    }
    
    @PutMapping("/{id}")
    public Company update(@RequestBody() Company c, @PathVariable("id") String id, Model model) {
    	return service.update(c, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}