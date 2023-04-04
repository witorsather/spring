package crud.angular.spring.crud.develop.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.angular.spring.crud.develop.domain.entity.BancoModel;

@Repository
public interface BancoRepository extends JpaRepository<BancoModel, Integer> {

   

    Optional<BancoModel> findById(Integer id);

    Optional<BancoModel> findByCodigo(String codigo);

}
