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

import models.Employee;
import services.EmployeeService;


@RestController
@RequestMapping(path = "/api/v1/employee", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<Employee> index(Model model) {
        return service.index();
    }

    @GetMapping("/{id}")
    public Employee show(@PathVariable("id") String id, Model model) {
        return service.show(id);
    }
    
    @GetMapping("list/{id}")
    public List<Employee> listEmployee(@PathVariable("id") String id, Model model) {
        return service.listEmployee(id);
    }
    
    @PostMapping()
    @ResponseStatus(value=HttpStatus.CREATED)
    public Employee create(@RequestBody() Employee e, Model model) {
    	return service.create(e);
    }
    
    @PutMapping("/{id}")
    public Employee update(@RequestBody() Employee e, @PathVariable("id") String id, Model model) {
    	return service.update(e, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, Model model) {
    	service.delete(id);
    }
}