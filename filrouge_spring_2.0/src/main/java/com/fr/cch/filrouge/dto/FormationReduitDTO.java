package com.fr.cch.filrouge.dto;

import lombok.Data;

import java.util.List;

@Data
public class FormationReduitDTO {
    private Long id;
    private String nom;
    private List<SessionReduitDTO> sessions;
}
