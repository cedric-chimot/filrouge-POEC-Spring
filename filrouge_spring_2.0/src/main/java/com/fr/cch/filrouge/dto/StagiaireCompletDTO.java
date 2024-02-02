package com.fr.cch.filrouge.dto;

import lombok.Data;

import java.util.List;

@Data
public class StagiaireCompletDTO {
    private Long id;
    private String nom;
    private String prenom;
    private List<ParticipationReduitDTO> participations;
}
