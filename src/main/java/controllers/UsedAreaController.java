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

import models.UsedArea;
import services.UsedAreaService;
import ultis.GenerateID;


@RestController
@RequestMapping(path = "/api/v1/used_area", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class UsedAreaController {

    private final UsedAreaService service;

    @Autowired
    public UsedAreaController(UsedAreaService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<UsedArea> index(Model model) {
    	return service.index(); 
    }

    @GetMapping("/{id}")
    public UsedArea show(@PathVariable("id") String id, Model model) {
    	   return service.show(id);
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public UsedArea create(@RequestBody() UsedArea ua, Model model) {
    	ua.setId(new GenerateID().genID());
    	return service.create(ua);
    }
    
    @PutMapping("/{id}")
    public UsedArea update(@RequestBody() UsedArea ua, @PathVariable("id") String id, Model model) {
    	return service.update(ua, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}