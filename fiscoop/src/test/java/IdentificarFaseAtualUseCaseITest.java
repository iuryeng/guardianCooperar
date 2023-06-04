import org.cooperar.domain.entites.Atividade;
import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.enums.StatusAtividade;
import org.cooperar.domain.usecases.interfaces.IdentificarFaseAtualUseCase;
import org.cooperar.domain.usecases.services.IdentificarFaseAtualUseCaseImpl;
import org.cooperar.infrastructure.repositories.ObraRepository;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringJUnitConfig
class IdentificarFaseAtualUseCaseITest {

    private IdentificarFaseAtualUseCase useCase;
    private ObraRepository obraRepository;

    @BeforeEach
    void setUp() {
        obraRepository = Mockito.mock(ObraRepository.class);
        useCase = new IdentificarFaseAtualUseCaseImpl(obraRepository);
    }

    @Test
    @DisplayName("Deve identificar a fase atual corretamente com base nas atividades concluídas")
    void testIdentificarFaseAtual() {
        // Criação das fases da obra
        Fase fase1 = new Fase("1", "Fase 1", null, null);
        Fase fase2 = new Fase("2", "Fase 2", null, null);
        Fase fase3 = new Fase("3", "Fase 3", null, null);

        // Criação das atividades
        Atividade atividade1 = new Atividade("1", "Atividade 1");
        Atividade atividade2 = new Atividade("2", "Atividade 2");
        Atividade atividade3 = new Atividade("3", "Atividade 3");

        atividade1.setStatus(StatusAtividade.CONCLUIDA);
        atividade2.setStatus(StatusAtividade.CONCLUIDA);
        atividade3.setStatus(StatusAtividade.EM_PROGRESSO);

        // Associação das atividades às fases
        fase1.adicionarAtividade(atividade1);
        fase1.adicionarAtividade(atividade2);
        fase2.adicionarAtividade(atividade3);

        // Criação da obra
        Obra obra = new Obra("1", null);
        obra.adicionarFase(fase1);
        obra.adicionarFase(fase2);
        obra.adicionarFase(fase3);

        // Configuração do comportamento do mock
        Mockito.when(obraRepository.findById("1")).thenReturn(obra);

        // Testando identificação da fase atual
        Fase faseAtual = useCase.identificarFaseAtual("1");
        Assertions.assertEquals(fase2, faseAtual);
    }

    @Test
    @DisplayName("Deve identificar a fase atual corretamente quando a obra não é encontrada")
    void testIdentificarFaseAtual_ObraNaoEncontrada() {
        Fase faseAtual = useCase.identificarFaseAtual("2"); // ID da obra inexistente
        Assertions.assertNull(faseAtual);
    }

    @Test
    @DisplayName("Deve identificar a fase atual corretamente quando todas as atividades estão concluídas")
    void testIdentificarFaseAtual_TodasAtividadesConcluidas() {
        // Criação da fase com atividades concluídas
        Fase fase = new Fase("1", "Fase 1", null, null);
        Atividade atividade1 = new Atividade("1", "Atividade 1");
        Atividade atividade2 = new Atividade("2", "Atividade 2");

        atividade1.setStatus(StatusAtividade.CONCLUIDA);
        atividade2.setStatus(StatusAtividade.CONCLUIDA);

        fase.adicionarAtividade(atividade1);
        fase.adicionarAtividade(atividade2);

        // Criação da obra
        Obra obra = new Obra("1", null);
        obra.adicionarFase(fase);
        obraRepository.save(obra);

        // Testando identificação da fase atual (todas atividades concluídas)
        Fase faseAtual = useCase.identificarFaseAtual("1");
        Assertions.assertNull(faseAtual); // Nenhuma fase encontrada (todas atividades concluídas)
    }

    @Test
    @DisplayName("Deve atualizar a fase atual corretamente")
    void testAtualizarFaseAtual() {

        // Criação das fases da obra
        Fase fase1 = new Fase("1", "Fase 1", null, null);
        Fase fase2 = new Fase("2", "Fase 2", null, null);

        // Criação da obra
        Obra obra = new Obra("1", null);
        obra.adicionarFase(fase1);
        obra.adicionarFase(fase2);

        Mockito.when(obraRepository.findById("1")).thenReturn(obra);

        // Atualizando fase atual
        useCase.atualizarFaseAtual("1", fase2);

        // Recuperando a obra atualizada
        Obra obraAtualizada = obraRepository.findById("1");
        Fase faseAtual = obraAtualizada.getFaseAtual();

        Assertions.assertEquals(fase2, faseAtual);
    }

    @Test
    @DisplayName("Deve tratar corretamente a atualização da fase atual quando a obra não é encontrada")
    void testAtualizarFaseAtual_ObraNaoEncontrada() {
        // Atualizando fase atual de uma obra inexistente
        Fase fase = new Fase("1", "Fase 1", null, null);
        useCase.atualizarFaseAtual("2", fase); // ID da obra inexistente

        // Recuperando a obra inexistente (não deve lançar exceção)
        Obra obra = obraRepository.findById("2");
        Assertions.assertNull(obra);
    }


}



