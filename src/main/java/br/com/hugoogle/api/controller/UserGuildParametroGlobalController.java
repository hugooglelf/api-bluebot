package br.com.hugoogle.api.controller;


import br.com.hugoogle.api.dtos.ParametroGlobalDto;
import br.com.hugoogle.api.dtos.ParametroPorUsuarioDto;
import br.com.hugoogle.api.services.parametro.UserGuildParametroGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user-guild/parametros-global")
public class UserGuildParametroGlobalController {

    @Autowired
    private final UserGuildParametroGlobalService service;

    public UserGuildParametroGlobalController(UserGuildParametroGlobalService service) {
        this.service = service;
    }

    @GetMapping(value = "/obter")
    public ResponseEntity<ParametroGlobalDto> obterParametroGlobal() {
        ParametroGlobalDto objDto = this.service.obterParametroGlobal();
        return ResponseEntity.ok().body(objDto);
    }

//    @ResponseBody
//    @PostMapping("/salvar")
//    public ResponseEntity salvar(@PathVariable String usuario, @Valid @RequestBody ParametroPorUsuarioDto parametroPorUsuarioDto) {
//        service.salvarParametroPorUsuario(usuario, parametroPorUsuarioDto);
//        return ResponseEntity.ok().build();
//    }

}
