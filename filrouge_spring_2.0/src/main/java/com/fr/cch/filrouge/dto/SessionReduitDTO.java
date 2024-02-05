package com.fr.cch.filrouge.dto;

import com.fr.cch.filrouge.entity.CentreFormation;
import lombok.Data;

import java.util.Date;

@Data
public class SessionReduitDTO {
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private CentreFormation centreFormation;
}
