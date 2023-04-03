package crud.angular.spring.crud.develop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.angular.spring.crud.develop.domain.entity.Pessoa;
import crud.angular.spring.crud.develop.domain.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {

        return pessoaService.salvarPessoa(pessoa);
    }

    @GetMapping("/")
    public List<Pessoa> listaPesssoas() {

        return pessoaService.listarTodas();
    }

}
