package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final AssistanceRepository assistanceRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(
        AssistanceRepository assistanceRepository,
        OrderRepository orderRepository
    ){
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }
    public void saveOrder(Order order, List<Long> assistsId) throws Exception {
        ArrayList<Assistance> list = new ArrayList<>();
        assistsId.forEach(id -> {
            Optional<Assistance> assistance = assistanceRepository.findById(id);
            assistance.ifPresent(list::add);
        });

        if (list.isEmpty()){
            throw new MinimumAssistRequiredException("Erro nas assistencias", "Nao encontramos nenhuma assistencia valida");
        } else if (list.size() > 15) {
            throw new MaximumAssistException("Erro nas assistencias", "Nao devemos enviar mais de 15 assistancias");
        }

        order.setAssists(list);
        orderRepository.save(order);
    }
}
