package com.petland.atendimento.service;

import com.petland.atendimento.model.dto.AtendimentoRequest;
import com.petland.atendimento.model.dto.AtendimentoResponse;
import com.petland.atendimento.model.entity.AtendimentoEntity;
import com.petland.atendimento.repository.AtendimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    public Integer gravar(AtendimentoRequest requisicao) {
        AtendimentoEntity entidade = new AtendimentoEntity();
        BeanUtils.copyProperties(requisicao, entidade);
        return repository.save(entidade).getId();
    }

    public Integer alterar(Integer id, AtendimentoRequest requisicao) {
        AtendimentoEntity entidade = repository.findById(id).orElse(null);
        if (entidade != null) {
            BeanUtils.copyProperties(requisicao, entidade);
            return repository.save(entidade).getId();
        }
        return null;
    }

    public List<AtendimentoResponse> listar() {
        List<AtendimentoEntity> entities = repository.findAll();
        List<AtendimentoResponse> response = new ArrayList<>();
        for (AtendimentoEntity e : entities) {
            AtendimentoResponse res = new AtendimentoResponse();
            BeanUtils.copyProperties(e, res);
            response.add(res);
        }

        return response;
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
