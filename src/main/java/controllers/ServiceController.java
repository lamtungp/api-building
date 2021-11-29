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

import models.Service;
import services.SvService;

@RestController
@RequestMapping(path = "/api/v1/service", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class ServiceController {

    private final SvService service;

    @Autowired
    public ServiceController(SvService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<Service> index(Model model) {
    	return service.index(); 
    }

    @GetMapping("/{id}")
    public Service show(@PathVariable("id") String id, Model model) {
    	   return service.show(id);
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public Service create(@RequestBody() Service sv, Model model) {
    	return service.create(sv);
    }
    
    @PutMapping("/{id}")
    public Service update(@RequestBody() Service sv, @PathVariable("id") String id, Model model) {
    	return service.update(sv, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}