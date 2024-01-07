package com.filrouge.filrouge.service;

import com.filrouge.filrouge.entity.SousThemes;
import com.filrouge.filrouge.repository.SousThemesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SousThemesService {

    public final SousThemesRepository sousThemesRepository;

    @Autowired
    public SousThemesService(SousThemesRepository sousThemesRepository) {
        this.sousThemesRepository = sousThemesRepository;
    }

    @Transactional
    public SousThemes sousThemesSave(SousThemes sousThemes) {
        return sousThemesRepository.save(sousThemes);
    }

    public Optional<SousThemes> findById(Long id) {
        return sousThemesRepository.findById(id);
    }

}
