package crud.angular.spring.crud.develop.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import crud.angular.spring.crud.develop.domain.entity.Pessoa;
import crud.angular.spring.crud.develop.domain.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {

        Optional<Pessoa> validacao = pessoaRepository.findByCpf(pessoa.getCpf());

        if (validacao.isPresent()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já existe!");

        } else {

            return pessoaRepository.save(pessoa);

        }

    }

    public List<Pessoa> listarTodas() {

        return pessoaRepository.findAll();

    }

}
