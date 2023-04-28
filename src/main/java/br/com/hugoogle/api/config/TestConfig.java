package br.com.hugoogle.api.config;

import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.repositories.FornecedorRepository;
import br.com.hugoogle.api.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB(){
        this.dbService.instanciaDB();
    }


}
