package br.com.hugoogle.api.controller;

import br.com.hugoogle.api.dtos.FornecedorDto;
import br.com.hugoogle.api.dtos.FornecedorProdutoDto;
import br.com.hugoogle.api.dtos.PrecoDto;
import br.com.hugoogle.api.model.Fornecedor;
import br.com.hugoogle.api.model.FornecedorProduto;
import br.com.hugoogle.api.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController //Controladora que recebe as requisicao http
@RequestMapping(value = "/fornecedores") // end point inicial para acessar o recurso
public class FornecedorController {

    @Autowired
    private FornecedorService service;



    @GetMapping(path = {"/gtin", "/gtin/{gtin}"})
    @ResponseBody
    ResponseEntity<List<FornecedorProdutoDto>> user(@PathVariable(required=false,name="gtin") Long gtin,
                     @RequestParam(required=false, name="gtin") Long qparams) {
        List<FornecedorProdutoDto> byGtin = this.service.findByGtin(gtin);

        byGtin.forEach(fornecedorProdutoDto -> {
            List<PrecoDto> precoDtos = this.service.listaPreco(gtin, fornecedorProdutoDto.getCnpj(), fornecedorProdutoDto.getCpf());
            fornecedorProdutoDto.setPrecos(precoDtos);
        });



        //
//        for(Object[] b: byGtin) {
//            System.out.println(b[0]);
//
//            System.out.println("-----------------------");
//
//
//        }
        return ResponseEntity.ok().body(byGtin);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDto> findById(@PathVariable Integer id) {
        FornecedorDto objDto = new FornecedorDto(this.service.findById(id));
        return ResponseEntity.ok().body(objDto);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDto>> findAll() {

        List<FornecedorDto> listDto = service.findAll().stream().map(obj -> new FornecedorDto(obj)).collect(Collectors.toList());

        //        List<Fornecedor> list = service.findAll();
//
//        List<FornecedorDto> listDto = new ArrayList<>();
//        for (Fornecedor obj : list
//        ) {
//            listDto.add(new FornecedorDto((obj)));
//        }
//
//        list.forEach(obj -> listDto.add(new FornecedorDto(obj)));
//
        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDto> update(@PathVariable Integer id, @Valid @RequestBody FornecedorDto fornecedorDto) {
        FornecedorDto novoFornecedor =  new FornecedorDto(service.update(id, fornecedorDto));
        return ResponseEntity.ok().body(novoFornecedor);
    }

    @PostMapping
    public ResponseEntity<FornecedorDto> create(@RequestBody FornecedorDto fornecedorDto) {
        Fornecedor novoFornecedor = service.create(fornecedorDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoFornecedor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
