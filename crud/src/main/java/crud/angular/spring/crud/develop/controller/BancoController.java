package crud.angular.spring.crud.develop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import crud.angular.spring.crud.develop.domain.entity.BancoModel;
import crud.angular.spring.crud.develop.domain.service.BancoService;

@RestController
@RequestMapping("/banco")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @PostMapping("/")
    public BancoModel salvarBanco(@RequestBody BancoModel banco) {

        return bancoService.salvarBanco(banco);
    }

    @GetMapping("/")
    public List<BancoModel> listaPesssoas() {

        return bancoService.listarTodas();
    }

    
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<BancoModel> BuscarPorId(@PathVariable Integer id) {

        return bancoService.BuscarPorId(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BancoModel> deletePeca(@PathVariable Integer id) {
      return bancoService.deleteBanco(id);
    }




}
