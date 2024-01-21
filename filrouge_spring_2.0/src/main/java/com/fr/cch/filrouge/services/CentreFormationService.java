package com.fr.cch.filrouge.services;

import com.fr.cch.filrouge.entity.CentreFormation;
import com.fr.cch.filrouge.repository.CentreFormationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class CentreFormationService {

    private final CentreFormationRepository centreFormationRepository;

    @Autowired
    public CentreFormationService(CentreFormationRepository centreFormationRepository) {
        this.centreFormationRepository = centreFormationRepository;
    }

    public CentreFormation createCentre(@RequestBody CentreFormation centreFormation) {
        return centreFormationRepository.save(centreFormation);
    }

}
