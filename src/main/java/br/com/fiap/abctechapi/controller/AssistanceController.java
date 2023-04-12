package br.com.fiap.abctechapi.controller;

import br.com.fiap.abctechapi.application.dto.AssistDto;
import br.com.fiap.abctechapi.application.impl.AssistanceApplicationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/assists")
@RestController
public class AssistanceController {
    private final AssistanceApplicationImpl assistanceApplicationImpl;

    public AssistanceController(AssistanceApplicationImpl assistanceApplicationImpl){
        this.assistanceApplicationImpl = assistanceApplicationImpl;
    }

    @GetMapping
    public ResponseEntity<List<AssistDto>> getAssists(){
        return ResponseEntity.ok(assistanceApplicationImpl.getAssists());
    }
}
