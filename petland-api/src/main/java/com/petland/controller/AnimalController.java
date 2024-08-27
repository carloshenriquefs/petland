package com.petland.controller;

import com.petland.model.dto.AnimalRequest;
import com.petland.model.dto.AnimalResponse;
import com.petland.service.AnimalService;
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
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping()
    public List<AnimalResponse> get() {
        return animalService.listar();
    }

    @PostMapping()
    public Integer gravar(@RequestBody AnimalRequest requisicao) {
        return animalService.gravar(requisicao);
    }

    @PutMapping("/{id}")
    public Integer alterar(@PathVariable("id") Integer id,
                           @RequestBody AnimalRequest requisicao) {
        return animalService.alterar(id, requisicao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        animalService.excluir(id);
    }
}
