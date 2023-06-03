import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.services.ObraService;
import org.cooperar.rest.controllers.ObraController;
import org.cooperar.rest.dtos.ObraDTO;
import org.cooperar.rest.mappers.ObraMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ObraControllerTest {
    private ObraController obraController;

    @Mock
    private ObraService obraService;
    @Mock
    private ObraMapper obraMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        obraController = new ObraController(obraService, obraMapper);
    }

    @Test
    @DisplayName("Deve retornar uma obra existente com o ID informado")
    void testGetObraById_ExistingObra() {
        String obraId = "1";
        Obra obra = new Obra();
        obra.setId(obraId);

        ObraDTO obraDTO = new ObraDTO();
        obraDTO.setId(obraId);

        when(obraService.buscarObraPorId(obraId)).thenReturn(obra);
        when(obraMapper.toDTO(obra)).thenReturn(obraDTO);

        ResponseEntity<ObraDTO> response = obraController.getObraById(obraId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(obraDTO, response.getBody());

        verify(obraService, times(1)).buscarObraPorId(obraId);
        verify(obraMapper, times(1)).toDTO(obra);
    }

    @Test
    @DisplayName("Deve retornar NOT FOUND quando a obra com o ID informado não existe")
    void testGetObraById_NonExistingObra() {
        String obraId = "1";

        when(obraService.buscarObraPorId(obraId)).thenReturn(null);

        ResponseEntity<ObraDTO> response = obraController.getObraById(obraId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(obraService, times(1)).buscarObraPorId(obraId);
        verify(obraMapper, never()).toDTO(any(Obra.class));
    }

    @Test
    @DisplayName("Deve retornar uma lista de todas as obras")
    void testGetAllObras() {
        Obra obra1 = new Obra();
        obra1.setId("1");

        Obra obra2 = new Obra();
        obra2.setId("2");

        List<Obra> obras = new ArrayList<>();
        obras.add(obra1);
        obras.add(obra2);

        ObraDTO obraDTO1 = new ObraDTO();
        obraDTO1.setId("1");

        ObraDTO obraDTO2 = new ObraDTO();
        obraDTO2.setId("2");

        List<ObraDTO> obraDTOs = new ArrayList<>();
        obraDTOs.add(obraDTO1);
        obraDTOs.add(obraDTO2);

        when(obraService.getAllObras()).thenReturn(obras);
        when(obraMapper.toDTO(obra1)).thenReturn(obraDTO1);
        when(obraMapper.toDTO(obra2)).thenReturn(obraDTO2);

        ResponseEntity<List<ObraDTO>> response = obraController.getAllObras();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(obraDTOs, response.getBody());

        verify(obraService, times(1)).getAllObras();
        verify(obraMapper, times(1)).toDTO(obra2);
        verify(obraService, times(1)).getAllObras();
        verify(obraMapper, times(1)).toDTO(obra1);
        verify(obraMapper, times(1)).toDTO(obra2);
    }
}


