package com.filrouge.filrouge.controller;

import com.filrouge.filrouge.entity.CentreFormation;
import com.filrouge.filrouge.service.CentreFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/centreFormation")
public class CentreFormationController {

    private final CentreFormationService centreFormationService;

    @Autowired
    public CentreFormationController(CentreFormationService centreFormationService) {
        this.centreFormationService = centreFormationService;
    }

    @RequestMapping("/create")
    public CentreFormation createCentre(@RequestBody CentreFormation centreFormation) {
        return centreFormationService.centreSave(centreFormation);
    }

}
