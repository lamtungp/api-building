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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import models.UsedService;
import services.UsedSvService;

@RestController
@RequestMapping(path = "/api/v1/used_service", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class UsedServiceController {

    private final UsedSvService service;

    @Autowired
    public UsedServiceController(UsedSvService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<UsedService> index(Model model) {
    	return service.index(); 
    }
    
    @GetMapping("/list/{id}")
    public List<UsedService> list(@RequestParam("time") String time, @PathVariable("id") String id, Model model) {
    	return service.indexUsedService(id, time); 
    }

    @GetMapping("/{id}")
    public UsedService show(@PathVariable("id") String id, Model model) {
    	   return service.show(id);
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public UsedService create(@RequestBody() UsedService us, Model model) {
    	return service.create(us);
    }
    
    @PutMapping("/{id}")
    public UsedService update(@RequestBody() UsedService us, @PathVariable("id") String id, Model model) {
    	return service.update(us, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}