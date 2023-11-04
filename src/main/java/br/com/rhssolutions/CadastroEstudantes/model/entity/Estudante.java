package br.com.rhssolutions.CadastroEstudantes.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_estudantes")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String email;

    private Integer idade;

    @CreationTimestamp
    private Date dataCadastro;

}
