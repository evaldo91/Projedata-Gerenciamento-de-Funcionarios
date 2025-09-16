package com.evaldo91.Gerenciamento.de.Funcionarios;

import com.evaldo91.Gerenciamento.de.Funcionarios.model.Funcionario;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@SpringBootApplication
public class Principal {

	public static void main(String[] args) {

        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFmt = NumberFormat.getCurrencyInstance(new Locale("pt", "BR" ));
        BigDecimal salarioMin = new BigDecimal("1212.00");

      // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));


       // 3.2 – Remover o funcionário “João” da lista.

       funcionarios.removeIf(funcionario -> "João".equals(funcionario.getNome()));

        //3.3 – Imprimir todos os funcionários com todas suas informações
        System.out.println("=== Lista de Funcionários ===");
        funcionarios.forEach(f ->{
            String dataNascimentoFormatada = f.getDataNasicmento().format(dateFmt);
            String salarioFormatado = numberFmt.format(f.getSalario());
            System.out.println(String.format("%s | %s | %s | %s",f.getNome(), dataNascimentoFormatada, salarioFormatado, f.getFuncao()));
        });

        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.1"))));

        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> porFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        //3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println("\n=== Funcionários agrupados por função ===");
        porFuncao.forEach((funcao, lista) -> {System.out.println(funcao + ":");
            lista.forEach(f -> System.out.println(" - " + f.getNome() ));});

       //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\n=== Aniversariantes (mês 10 e 12) ===");
        funcionarios.stream()
                .filter(f -> f.getDataNasicmento().getMonthValue() == 10 || f.getDataNasicmento().getMonthValue() == 12)
                .forEach(f -> System.out.println(String.format(f.getNome() + " | " + f.getDataNasicmento().format(dateFmt))));


        //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.

        Funcionario maisVelho = funcionarios.stream().min(Comparator.comparing(Funcionario::getDataNasicmento)).orElse(null);
        if (maisVelho !=null){
            int idade = Period.between(maisVelho.getDataNasicmento(), LocalDate.now()).getYears();
            System.out.println("\nO mais velho é: " + maisVelho.getNome() + " com a idade de " + idade);


        }

        //3.10 – Imprimir a lista de funcionários por ordem alfabética.

        System.out.println("\n=== Funcionários por ordem alfabética ===");
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(f-> System.out.println(f.getNome()));


        //3.11 – Imprimir o total dos salários dos funcionários.
        BigDecimal total = funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal de salários: " +numberFmt.format(total));


        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário

        System.out.println("\n=== Quantos salários mínimos ganha cada funcionário ===");
        funcionarios.forEach(f ->{
            BigDecimal quantidade = f.getSalario().divide(salarioMin, 2);
            System.out.println(f.getNome() + " - " + quantidade);
        });





    };






        }







