package com.filrouge.filrouge.controller;

import com.filrouge.filrouge.entity.Formations;
import com.filrouge.filrouge.service.FormationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formations")
public class FormationsController {

    private final FormationsService formationsService;

    @Autowired
    public FormationsController(FormationsService formationsService) {
        this.formationsService = formationsService;
    }

    @RequestMapping("/create")
    public Formations createFormation(@RequestBody Formations formations) {
        return formationsService.formationsSave(formations);
    }

}
