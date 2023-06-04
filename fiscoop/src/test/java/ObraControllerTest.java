import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.services.FaseService;
import org.cooperar.domain.services.ObraService;
import org.cooperar.domain.usecases.interfaces.AdicionarProblemaUseCase;
import org.cooperar.domain.usecases.services.AdicionarProblemaUseCaseImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ObraControllerTest {
    private ObraController obraController;

    @Mock
    private ObraService obraService;
    @Mock
    private ObraMapper obraMapper;

    @Mock
    private FaseService faseService;

    @Mock
    private  AdicionarProblemaUseCaseImpl adicionarProblemaUseCaseImpl;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        obraController = new ObraController(obraService, obraMapper, faseService);
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

}


