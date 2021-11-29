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

import models.WorkedTime;
import services.WorkedTimeService;

@RestController
@RequestMapping(path = "/api/v1/worked_time", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class WorkedTimeController {

    private final WorkedTimeService service;

    @Autowired
    public WorkedTimeController(WorkedTimeService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<WorkedTime> index(Model model) {
    	return service.index(); 
    }
    
    @GetMapping("/report")
    public List<WorkedTime> indexTime(@RequestParam("time") String time, Model model) {
    	return service.indexTime(time); 
    }

    @GetMapping("/{id}")
    public WorkedTime show(@PathVariable("id") String id, Model model) {
    	   return service.show(id);
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public WorkedTime create(@RequestBody() WorkedTime wt, Model model) {
    	return service.create(wt);
    }
    
    @PutMapping("/{id}")
    public WorkedTime update(@RequestBody() WorkedTime wt, @PathVariable("id") String id, Model model) {
    	return service.update(wt, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}