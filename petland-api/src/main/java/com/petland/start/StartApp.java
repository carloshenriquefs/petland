package com.petland.start;

import com.petland.model.Animal;
import com.petland.model.AnimalEspecie;
import com.petland.model.Cadastro;
import com.petland.model.Endereco;
import com.petland.model.Perfil;
import com.petland.repository.AnimalRepository;
import com.petland.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartApp implements ApplicationRunner {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private AnimalRepository animalRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        Cadastro gleyson = new Cadastro();
        gleyson.setNome("Gleyson Sampaio");

        Perfil perfil = new Perfil();
        perfil.setCliente(true);
        perfil.setFornecedor(false);
        perfil.setPrestador(false);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das Flores");
        endereco.setNumero("123");

        gleyson.setPerfil(perfil);
        gleyson.setEndereco(endereco);

        cadastroRepository.save(gleyson);

        Animal thor = new Animal();
        thor.setNome("Thor");
        thor.setAniversario(LocalDate.of(2023, 12, 20));
        thor.setEspecie(AnimalEspecie.CACHORRO);

        animalRepository.save(thor);
    }
}
