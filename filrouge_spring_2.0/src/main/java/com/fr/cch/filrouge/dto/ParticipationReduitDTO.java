package com.fr.cch.filrouge.dto;

import com.fr.cch.filrouge.entity.SessionFormation;
import lombok.Data;

@Data
public class ParticipationReduitDTO {
    private Long id;
    private SessionFormation session;
}
