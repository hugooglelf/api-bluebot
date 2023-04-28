package br.com.hugoogle.api.controller;

import br.com.hugoogle.api.model.HtmlCode;
import br.com.hugoogle.api.repositories.HtmlCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-guild")
public class HtmlCodeController {
    @Autowired
    private HtmlCodeRepository htmlCodeRepository;



    @GetMapping("/html-codes")
    public List<HtmlCode> getAllHtmlCodes() {
        return htmlCodeRepository.findAll();
    }

    @GetMapping("/html-code/elemento/{id}")
    public ResponseEntity<HtmlCode> getHtmlCodeById(@PathVariable(value = "id") Long htmlCodeId) {
        Optional<HtmlCode> htmlCode = htmlCodeRepository.findById(htmlCodeId);
        if (htmlCode.isPresent()) {
            return ResponseEntity.ok().body(htmlCode.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/html-code/elemento-css/elemento/{elemento}/url-page/{urlPage}")
    public ResponseEntity<HtmlCode> getHtmlCodeByElementos(@PathVariable(value = "elemento") String htmlCodeElemento, @PathVariable(value = "urlPage") String urlPage) {
        Optional<HtmlCode> htmlCode = htmlCodeRepository.findByElemento(htmlCodeElemento, urlPage );
        if (htmlCode.isPresent()) {
            return ResponseEntity.ok().body(htmlCode.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/html-code/elemento-css")
    @ResponseBody
    public ResponseEntity<HtmlCode> getHtmlCodeByElemento(@RequestParam("htmlCodeElemento") String htmlCodeElemento, @RequestParam("urlPage") String urlPage) {
        Optional<HtmlCode> htmlCode = htmlCodeRepository.findByElemento(htmlCodeElemento, urlPage);
        if (htmlCode.isPresent()) {
            return ResponseEntity.ok().body(htmlCode.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }


        @PostMapping("/html-code/salvar")
    public ResponseEntity<String> createHtmlCode(@RequestBody HtmlCode htmlCode) {
        try {
            htmlCodeRepository.save(htmlCode);
            return new ResponseEntity<>("Código HTML criado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar código HTML", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HtmlCode> updateHtmlCode(@PathVariable(value = "id") Long htmlCodeId, @RequestBody HtmlCode htmlCodeDetails) {
        Optional<HtmlCode> optionalHtmlCode = htmlCodeRepository.findById(htmlCodeId);
        if (optionalHtmlCode.isPresent()) {
            HtmlCode htmlCode = optionalHtmlCode.get();
            htmlCode.setCode(htmlCodeDetails.getCode());
            HtmlCode updatedHtmlCode = htmlCodeRepository.save(htmlCode);
            return ResponseEntity.ok(updatedHtmlCode);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @PutMapping("/html-code/salvar/elemento")
    public ResponseEntity<?> updateHtmlCodeElemento(@Valid @RequestBody HtmlCode htmlCodeDetails,  BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Optional<HtmlCode> htmlCodeOptional = htmlCodeRepository.findByElemento(htmlCodeDetails.getElemento(), htmlCodeDetails.getUrlPage());
        try {
        if (htmlCodeOptional.isPresent()) {
            htmlCodeOptional.get().setTitulo(htmlCodeDetails.getTitulo());
            htmlCodeOptional.get().setPosicao(htmlCodeDetails.getPosicao());
            htmlCodeOptional.get().setCode(htmlCodeDetails.getCode());
            htmlCodeOptional.get().setLargura(htmlCodeDetails.getLargura());
            htmlCodeRepository.save(htmlCodeOptional.get());
            return new ResponseEntity<>("Código HTML alterado com sucesso", HttpStatus.OK);
        } else {
            htmlCodeRepository.save(htmlCodeDetails);
            return new ResponseEntity<>("Código HTML criado com sucesso", HttpStatus.CREATED);
        }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar código HTML", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/html-codes/{id}")
    public String deleteHtmlCode(@PathVariable Long id) {
        HtmlCode existingHtmlCode = htmlCodeRepository.findById(id).orElse(null);
        if (existingHtmlCode != null) {
            htmlCodeRepository.delete(existingHtmlCode);
            return "Código HTML deletado com sucesso";
        }
        return "Código HTML não encontrado";
    }
}
