package com.fr.cch.filrouge.services.impl;

import com.fr.cch.filrouge.entity.Formateur;
import com.fr.cch.filrouge.exceptions.CustomException;
import com.fr.cch.filrouge.repository.FormateurRepository;
import com.fr.cch.filrouge.services.AllServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FormateurServiceImpl implements AllServices<Formateur, Long> {

    private final FormateurRepository formateurRepository;

    @Autowired
    public FormateurServiceImpl(FormateurRepository formateurRepository) {
        this.formateurRepository = formateurRepository;
    }

    /**
     * @return tous les formateurs
     */
    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    /**
     * @param id l'identifiant recherché
     * @return le formateur correspondant
     */
    @Override
    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    /**
     * @param newObj le nouvel objet formateur
     * @return le formateur nouvellement créé
     */
    @Override
    public Formateur create(Formateur newObj) {
        return formateurRepository.save(newObj);
    }

    /**
     * @param formateur l'objet formateur à mettre à jour
     */
    @Override
    public Formateur update(Formateur formateur) {
        if (!formateurRepository.existsById(formateur.getId())) {
            throw new CustomException("Formateur", "id", formateur.getId());
        }
        formateurRepository.save(formateur);
        return formateur;
    }

    /**
     * @param id l'identifiant recherché
     * @return le formateur à supprimer
     */
    @Override
    public Formateur delete(Long id) {
        Formateur formateur = findById(id);
        if (formateur == null) {
            throw new CustomException("Formateur", "id", id);
        }
        formateurRepository.deleteById(id);
        return formateur;
    }

}
