package br.com.rhssolutions.CadastroEstudantes.model.repository;

import br.com.rhssolutions.CadastroEstudantes.model.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, UUID> {

}
