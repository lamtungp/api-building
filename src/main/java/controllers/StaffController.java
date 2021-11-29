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

import models.Staff;
import services.StaffService;

@RestController
@RequestMapping(path = "/api/v1/staff", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class StaffController {

    private final StaffService service;

    @Autowired
    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Staff> show(Model model) {
		return service.index();
    }
    
    @GetMapping("/{id}")
    public Staff show(@PathVariable("id") String id, Model model) {
    	return service.show(id); 
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public Staff create(@RequestBody() Staff st, Model model) {
    	return service.create(st);
    }
    
    @PutMapping("/{id}")
    public Staff update(@RequestBody() Staff st, @PathVariable("id") String id, Model model) {
    	return service.update(st, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}