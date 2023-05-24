import org.cooperar.domain.entites.Fiscalizacao;
import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Servidor;
import org.cooperar.domain.enums.TipoObra;
import org.cooperar.domain.usecases.interfaces.AdicionarFiscalizacaoUseCase;
import org.cooperar.domain.usecases.services.AdicionarFiscalizacaoUseCaseImpl;
import org.cooperar.infrastructure.persistence.ObraRepositoryImpl;
import org.cooperar.infrastructure.repositories.ObraRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdicionarFiscalizacaoUseCaseTest {
    private ObraRepository obraRepository;
    private AdicionarFiscalizacaoUseCase adicionarFiscalizacaoUseCase;

    @BeforeEach
    public void setUp() {
        obraRepository = new ObraRepositoryImpl();
        adicionarFiscalizacaoUseCase = new AdicionarFiscalizacaoUseCaseImpl(obraRepository);
    }

    @Test
    public void adicionarFiscalizacao_DeveAssociarFiscalizacaoCorretamenteAObra() {
        Obra obra = new Obra("1", TipoObra.PASSAGEM_MOLHADA);
        Servidor servidor_1 = new Servidor("João");
        Servidor servidor_2 = new Servidor("Iury");
        Servidor servidor_3 = new Servidor("Kleber");
        Fiscalizacao fiscalizacao = new Fiscalizacao();
        fiscalizacao.setDataInicio(LocalDate.now());
        fiscalizacao.setDataFim(LocalDate.now().plusDays(7));
        fiscalizacao.setEngenheiroResponsavel(servidor_1);

        // Initialize the equipe list
        List<Servidor> equipe = new ArrayList<>();
        equipe.add(servidor_2);
        equipe.add(servidor_3);
        fiscalizacao.setEquipe(equipe);

        ObraRepository obraRepository = Mockito.mock(ObraRepository.class);
        Mockito.when(obraRepository.findById(obra.getId())).thenReturn(obra);

        AdicionarFiscalizacaoUseCase adicionarFiscalizacaoUseCase = new AdicionarFiscalizacaoUseCaseImpl(obraRepository);
        adicionarFiscalizacaoUseCase.execute(obra.getId(), fiscalizacao);

        Assertions.assertEquals(1, obra.getFiscalizacoes().size());
        Assertions.assertEquals(fiscalizacao, obra.getFiscalizacoes().get(0));
    }

}
