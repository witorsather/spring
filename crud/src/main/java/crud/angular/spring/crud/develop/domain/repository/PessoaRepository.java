package crud.angular.spring.crud.develop.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.angular.spring.crud.develop.domain.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
    Optional<Pessoa> findByCpf (String cpf);


}
