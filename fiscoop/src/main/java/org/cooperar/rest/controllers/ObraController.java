package org.cooperar.rest.controllers;

import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.services.FaseService;
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
public class ObraController{

    private final ObraService obraService;
    private final ObraMapper obraMapper;

    private final FaseService faseService;


    @Autowired
    public ObraController(ObraService obraService, ObraMapper obraMapper, FaseService faseService) {
        this.obraService = obraService;
        this.obraMapper = obraMapper;

        this.faseService = faseService;
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
    public ResponseEntity<List<Obra>> getAllObras() {
        List<Obra> obras = obraService.getAllObras();
        return ResponseEntity.ok(obras);
    }

    @PostMapping("/")
    public ResponseEntity<Obra> createObra(@RequestBody ObraDTO dto) {
        Obra obra = obraMapper.toEntity(dto);
        obraService.criarObra(obra);
        //ObraDTO responseDto = obraMapper.toDTO(obra);
        return ResponseEntity.status(HttpStatus.CREATED).body(obra);
    }

    @PostMapping("/{idObra}/fases/{idFase}")
    public ResponseEntity<Obra> addFaseToObra(@PathVariable String idObra, @PathVariable String idFase) {
        Fase fase = faseService.buscarFasePorId(idFase); // Você precisará implementar esse método no FaseService.
        if (fase != null) {
            obraService.adicionarFase(idObra, fase);
            Obra obra = obraService.buscarObraPorId(idObra);
            if (obra != null) {
                return ResponseEntity.ok(obra);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{obraId}/fase-atual")
    public ResponseEntity<Fase> getFaseAtual(@PathVariable String obraId) {
        Fase faseAtual = obraService.identificarFaseAtual(obraId);
        if (faseAtual == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faseAtual);
    }


}
