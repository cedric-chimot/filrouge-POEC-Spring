package com.filrouge.filrouge.controller;

import com.filrouge.filrouge.entity.SessionFormation;
import com.filrouge.filrouge.service.SessionFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
public class SessionFormationController {

    private final SessionFormationService sessionFormationService;

    @Autowired
    public SessionFormationController(SessionFormationService sessionFormationService) {
        this.sessionFormationService = sessionFormationService;
    }

    @RequestMapping("/create")
    public SessionFormation sessionSave(@RequestBody SessionFormation sessionFormation) {
        return sessionFormationService.sessionSave(sessionFormation);
    }

}
