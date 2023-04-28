package br.com.hugoogle.api.controller;


import br.com.hugoogle.api.dtos.FornecedorDto;
import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.services.parametro.ParametroPorUsuarioService;
import br.com.hugoogle.api.dtos.ParametroPorUsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user-guild/parametros")
public class UserGuildParametroUsuarioController {

    @Autowired
    private final ParametroPorUsuarioService service;

    public UserGuildParametroUsuarioController(ParametroPorUsuarioService service) {
        this.service = service;
    }

    @GetMapping(value = "/{usuario}")
    public ResponseEntity<ParametroPorUsuarioDto> obterParametroDoUsuario(@PathVariable String usuario) {
        ParametroPorUsuarioDto objDto = this.service.obterParametroDoUsuario(usuario);
        return ResponseEntity.ok().body(objDto);
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParametroPorUsuarioDto> salvar(@RequestBody ParametroPorUsuarioDto parametroPorUsuarioDto) {
        ParametroPorUsuarioDto objDto = this.service.salvarParametroPorUsuario(parametroPorUsuarioDto);
        return ResponseEntity.ok().body(objDto);
    }



}
