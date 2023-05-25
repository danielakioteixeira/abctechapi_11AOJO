package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import br.com.fiap.abctechapi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AssistanceServiceTest {

    @MockBean
    private AssistanceRepository assistanceRepository;
    private AssistanceService assistanceService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
        List<Assistance> assistanceList = new ArrayList<>();
        assistanceList.add(new Assistance(1L, "Teste 1", "Teste Description 1"));
        assistanceList.add(new Assistance(2L, "Teste 2", "Teste Description 2"));
        Mockito.when(assistanceRepository.findAll()).thenReturn(assistanceList);
    }

    @Test
    public void validate_findAll_call_count() {
        List<Assistance> assistances = this.assistanceService.getAssists();
        Mockito.verify(assistanceRepository, Mockito.times(1)).findAll();
    }
}
