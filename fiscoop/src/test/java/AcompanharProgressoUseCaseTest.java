import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Progresso;
import org.cooperar.domain.enums.StatusProgresso;
import org.cooperar.domain.usecases.interfaces.AcompanharProgressoUseCase;
import org.cooperar.domain.usecases.services.AcompanharProgressoUseCaseImpl;
import org.cooperar.infrastructure.repositories.ObraRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Date;

import static org.mockito.Mockito.when;

public class AcompanharProgressoUseCaseTest {
    private AcompanharProgressoUseCase acompanharProgressoUseCase;
    private ObraRepository obraRepository;
    private Obra obra;
    private Progresso progressoEsperado;

    @BeforeEach
    public void setUp() {
        obraRepository = Mockito.mock(ObraRepository.class);
        acompanharProgressoUseCase = new AcompanharProgressoUseCaseImpl(obraRepository);

        obra = new Obra("123");
        progressoEsperado = new Progresso(50, LocalDate.now(), LocalDate.now().plusDays(5), StatusProgresso.EM_EXECUCAO);
        obra.setProgresso(progressoEsperado);
    }

    @Test
    @DisplayName("Deve trazer o percentual concluído da obra")
    public void acompanharProgressoObra_DeveTrazerPercentualConcluidoDaObra() {
        // Arrange
        obra.getProgresso().setPercentualConcluido(progressoEsperado.getPercentualConcluido());

        when(obraRepository.findById("123")).thenReturn(obra);

        // Act
        Progresso progressoObtido = acompanharProgressoUseCase.execute(obra.getId());

        // Assert
        Assertions.assertEquals(progressoEsperado.getPercentualConcluido(), progressoObtido.getPercentualConcluido());
    }

    @Test
    @DisplayName("Deve trazer as datas de início e fim planejadas da obra")
    public void acompanharProgressoObra_DeveTrazerDatasInicioFimPlanejadasDaObra() {
        // Arrange
        LocalDate dataInicioEsperada = LocalDate.now(); // Data de início planejada
        LocalDate dataFimEsperada = LocalDate.now(); // Data de fim planejada


        progressoEsperado.setDataInicio(dataInicioEsperada);
        progressoEsperado.setDataFim(dataFimEsperada);

        when(obraRepository.findById("123")).thenReturn(obra);

        // Act
        Progresso progressoObtido = acompanharProgressoUseCase.execute(obra.getId());

        // Assert
        Assertions.assertEquals(dataInicioEsperada, progressoObtido.getDataInicio());
        Assertions.assertEquals(dataFimEsperada, progressoObtido.getDataFim());
    }

    @Test
    @DisplayName("Deve atualizar o progresso conforme as atividades são concluídas")
    public void acompanharProgressoObra_DeveAtualizarProgressoConformeAtividadesConcluidas() {
        // Arrange

        when(obraRepository.findById("123")).thenReturn(obra);
        obra.getProgresso().setPercentualConcluido(25); // Progresso inicial de 25%

        // Simula conclusão de atividades
        obra.getProgresso().setPercentualConcluido(50); // Progresso atualizado para 50%

        // Act
        Progresso progressoObtido = acompanharProgressoUseCase.execute(obra.getId());

        // Assert
        Assertions.assertEquals(progressoEsperado.getPercentualConcluido(), progressoObtido.getPercentualConcluido());
    }
}
