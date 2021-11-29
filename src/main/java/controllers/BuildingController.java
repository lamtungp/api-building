package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exceptions.NotFoundHttpException;
import models.Building;
import services.BuildingService;


@RestController
@RequestMapping(path = "/api/v1/building", produces = "application/json")
@ResponseBody
@CrossOrigin(origins = "*")
public class BuildingController {

    private final BuildingService service;

    @Autowired
    public BuildingController(BuildingService service) {
        this.service = service;
    }

    @GetMapping()
    public Building show(Model model) {
    	try {
    		Building bd = service.show("b001");
	        return bd;
    	} catch(NotFoundHttpException error) {
    		throw new NotFoundHttpException();
    	}
    }
    
    @PutMapping()
    public Building update(@RequestBody() Building bd, Model model) {
    	service.save(bd);
        return bd;
    }
}