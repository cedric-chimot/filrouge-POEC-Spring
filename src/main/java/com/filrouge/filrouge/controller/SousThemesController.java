package com.filrouge.filrouge.controller;

import com.filrouge.filrouge.entity.SousThemes;
import com.filrouge.filrouge.service.SousThemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sousThemes")
public class SousThemesController {

    private final SousThemesService sousThemesService;

    @Autowired
    public SousThemesController(SousThemesService sousThemesService) {
        this.sousThemesService = sousThemesService;
    }

    @RequestMapping("/create")
    public SousThemes createSousThemes(@RequestBody SousThemes sousThemes) {
        return sousThemesService.sousThemesSave(sousThemes);
    }

}
