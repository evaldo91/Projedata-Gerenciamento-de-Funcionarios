package com.evaldo91.Gerenciamento.de.Funcionarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario (String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao= funcao;
    }


}
