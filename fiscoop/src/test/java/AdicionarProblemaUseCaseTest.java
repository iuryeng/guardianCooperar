import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Problema;
import org.cooperar.domain.enums.TipoObra;
import org.cooperar.domain.usecases.interfaces.AdicionarProblemaUseCase;
import org.cooperar.domain.usecases.services.AdicionarProblemaUseCaseImpl;
import org.cooperar.infrastructure.repositories.ObraRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

public class AdicionarProblemaUseCaseTest {
    private AdicionarProblemaUseCase adicionarProblemaUseCase;
    private Obra obra;
    private ObraRepository obraRepository;

    @BeforeEach
    public void setUp() {
        obra = new Obra("1", TipoObra.PASSAGEM_MOLHADA);
        obraRepository = Mockito.mock(ObraRepository.class);
        Mockito.when(obraRepository.findById("1")).thenReturn(obra);
        adicionarProblemaUseCase = new AdicionarProblemaUseCaseImpl(obraRepository);
    }

    @Test
    @DisplayName("Deve adicionar problema na obra")
    public void adicionarProblema_DeveAdicionarProblemaNaObra() {
        Problema problema = new Problema("Descrição do problema", new Date(), "Alta", "Ação corretiva");

        adicionarProblemaUseCase.execute("1", problema);

        Assertions.assertEquals(1, obra.getProblemas().size());
        Assertions.assertEquals(problema, obra.getProblemas().get(0));
    }

    @Test
    @DisplayName("Não deve adicionar problema quando o problema for nulo")
    public void adicionarProblema_ComProblemaNulo_NaoDeveAdicionarProblema() {
        adicionarProblemaUseCase.execute("1", null);

        Assertions.assertTrue(obra.getProblemas().isEmpty());
    }
}
