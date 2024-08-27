package com.petland.atendimento.controller;

import com.petland.atendimento.model.dto.AtendimentoRequest;
import com.petland.atendimento.model.dto.AtendimentoResponse;
import com.petland.atendimento.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping()
    public List<AtendimentoResponse> get() {
        return atendimentoService.listar();
    }

    @PostMapping()
    public Integer gravar(@RequestBody AtendimentoRequest requisicao) {
        return atendimentoService.gravar(requisicao);
    }

    @PutMapping("/{id}")
    public Integer alterar(@PathVariable("id") Integer id,
                           @RequestBody AtendimentoRequest requisicao) {
        return atendimentoService.alterar(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        atendimentoService.excluir(id);
    }
}
