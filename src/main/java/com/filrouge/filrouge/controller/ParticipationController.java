package com.filrouge.filrouge.controller;

import com.filrouge.filrouge.entity.Participation;
import com.filrouge.filrouge.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participer")
public class ParticipationController {

    private final ParticipationService participationService;

    @Autowired
    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @PostMapping("/create")
    public Participation createParticipation(@RequestBody Participation participation) {
        return participationService.participationSave(participation);
    }
}
