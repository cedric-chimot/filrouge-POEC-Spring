package com.filrouge.filrouge.controller;

import com.filrouge.filrouge.entity.Formateurs;
import com.filrouge.filrouge.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formateurs")
public class FormateurController {

    public final FormateurService formateurService;

    @Autowired
    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @PostMapping("/create")
    public Formateurs createFormateur(@RequestBody Formateurs formateurs) {
        return formateurService.formateurSave(formateurs);
    }

}
