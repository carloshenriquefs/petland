package com.petland.cadastro.service;

import com.petland.cadastro.model.dto.CadastroResponse;
import com.petland.cadastro.model.entity.CadastroEntity;
import com.petland.cadastro.repository.CadastroRepository;
import com.petland.cadastro.model.dto.CadastroRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    public Integer gravar(CadastroRequest requisicao) {
        CadastroEntity entidade = new CadastroEntity();
        BeanUtils.copyProperties(requisicao, entidade);
        return repository.save(entidade).getId();
    }

    public Integer alterar(Integer id, CadastroRequest requisicao) {
        CadastroEntity entidade = repository.findById(id).orElse(null);
        if (entidade != null) {
            BeanUtils.copyProperties(requisicao, entidade);
            return repository.save(entidade).getId();
        }
        return null;
    }

    public List<CadastroResponse> listar() {
        List<CadastroEntity> entities = repository.findAll();
        List<CadastroResponse> response = new ArrayList<>();
        for (CadastroEntity e : entities) {
            CadastroResponse res = new CadastroResponse();
            BeanUtils.copyProperties(e, res);
            response.add(res);
        }

        return response;
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
