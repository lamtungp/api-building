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

import models.Floor;
import services.FloorService;


@RestController
@RequestMapping(path = "/api/v1/floor", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class FloorController {

    private final FloorService service;

    @Autowired
    public FloorController(FloorService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<Floor> index(Model model) {
    	return service.index(); 
    }

    @GetMapping("/{id}")
    public Floor show(@PathVariable("id") String id, Model model) {
    	   return service.show(id);
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public Floor create(@RequestBody() Floor f, Model model) {
    	return service.create(f);
    }
    
    @PutMapping("/{id}")
    public Floor update(@RequestBody() Floor f, @PathVariable("id") String id, Model model) {
    	return service.update(f, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}