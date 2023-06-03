package org.cooperar.rest.mappers;

import org.cooperar.domain.entites.Obra;
import org.cooperar.rest.dtos.ObraDTO;
import org.springframework.stereotype.Component;

@Component
public class ObraMapper {
    public ObraDTO toDTO(Obra obra) {
        ObraDTO dto = new ObraDTO();
        dto.setId(obra.getId());
        dto.setTipo(obra.getTipo());
        dto.setProgresso(obra.getProgresso());
        return dto;
    }

    public Obra toEntity(ObraDTO dto) {
        Obra obra = new Obra();
        obra.setId(dto.getId());
        obra.setTipo(dto.getTipo());
        // Defina outras propriedades da entidade Obra conforme necessário
        return obra;
    }
}
