package com.petland.controller;

import com.petland.model.dto.CadastroRequest;
import com.petland.model.dto.CadastroResponse;
import com.petland.service.CadastroService;
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
@RequestMapping("/cadastros")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping()
    public List<CadastroResponse> get() {
        return cadastroService.listar();
    }

    @PostMapping()
    public Integer gravar(@RequestBody CadastroRequest requisicao) {
        return cadastroService.gravar(requisicao);
    }

    @PutMapping("/{id}")
    public Integer alterar(@PathVariable("id") Integer id,
                           @RequestBody CadastroRequest requisicao) {
        return cadastroService.alterar(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        cadastroService.excluir(id);
    }
}
