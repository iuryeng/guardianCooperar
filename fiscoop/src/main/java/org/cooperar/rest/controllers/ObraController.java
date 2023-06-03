package org.cooperar.rest.controllers;

import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.services.ObraService;
import org.cooperar.rest.dtos.ObraDTO;
import org.cooperar.rest.mappers.ObraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final ObraService obraService;
    private final ObraMapper obraMapper;

    @Autowired
    public ObraController(ObraService obraService, ObraMapper obraMapper) {
        this.obraService = obraService;
        this.obraMapper = obraMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraDTO> getObraById(@PathVariable String id) {
        Obra obra = obraService.buscarObraPorId(id);
        if (obra != null) {
            ObraDTO dto = obraMapper.toDTO(obra);
            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ObraDTO>> getAllObras() {
        List<Obra> obras = obraService.getAllObras();
        List<ObraDTO> dtos = obras.stream()
                .map(obraMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/")
    public ResponseEntity<Obra> createObra(@RequestBody ObraDTO dto) {
        Obra obra = obraMapper.toEntity(dto);
        obraService.criarObra(obra);
        //ObraDTO responseDto = obraMapper.toDTO(obra);
        return ResponseEntity.status(HttpStatus.CREATED).body(obra);
    }


}
