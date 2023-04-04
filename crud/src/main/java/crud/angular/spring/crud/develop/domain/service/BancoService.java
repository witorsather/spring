package crud.angular.spring.crud.develop.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import crud.angular.spring.crud.develop.domain.entity.BancoModel;
import crud.angular.spring.crud.develop.domain.repository.BancoRepository;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public BancoModel salvarBanco(@RequestBody BancoModel banco) {

        Optional<BancoModel> validacao = bancoRepository.findByCodigo(banco.getCodigo());

        if (validacao.isPresent()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Código já existe!");

        } else {

            return bancoRepository.save(banco);

        }

    }

    public List<BancoModel> listarTodas() {

        return bancoRepository.findAll();

    }

    public ResponseEntity<BancoModel> BuscarPorId(@PathVariable Integer id) {

        Optional<BancoModel> optionalBanco = bancoRepository.findById(id);

        if (optionalBanco.isPresent()) {
            return ResponseEntity.ok(optionalBanco.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<BancoModel> deleteBanco(@PathVariable Integer id) {
        Optional<BancoModel> optionalPeca = bancoRepository.findById(id);
        if (optionalPeca.isPresent()) {
            bancoRepository.delete(optionalPeca.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
