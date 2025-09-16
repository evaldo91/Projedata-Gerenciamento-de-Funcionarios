# Gerenciamento de Funcionários - Spring Boot

Este projeto é uma aplicação Spring Boot desenvolvida para atender ao teste prático de programação, que envolve manipulação de funcionários de uma indústria. A aplicação executa todas as operações solicitadas e imprime os resultados no console.


## Funcionalidades
O projeto realiza os seguintes passos automaticamente ao iniciar:

1. Inserção de todos os funcionários, com informações de nome, data de nascimento, salário e função.
2. Remoção do funcionário "João".
3. Impressão de todos os funcionários com informações formatadas:
   - Data de nascimento: `dd/MM/yyyy`
   - Salário: formato brasileiro com ponto como milhar e vírgula como decimal
4. Aplicação de aumento de 10% no salário de todos os funcionários.
5. Agrupamento dos funcionários por função utilizando um `Map`.
6. Impressão dos funcionários agrupados por função.
7. Impressão dos funcionários que fazem aniversário nos meses 10 (Outubro) e 12 (Dezembro).
8. Impressão do funcionário com maior idade, mostrando nome e idade.
9. Impressão da lista de funcionários em ordem alfabética.
10. Cálculo e impressão do total de salários.
11. Cálculo de quantos salários mínimos (R$1212,00) cada funcionário recebe.

## Tecnologias
- Java 17
- Spring Boot 3.2
- Maven
- Lombok (opcional, para getters/setters simplificados)

## Como Executar
### Pré-requisitos
- Java 17 ou superior
- Maven

### Executar via Maven
```bash
mvn spring-boot:run
```

### Gerar JAR e executar
```bash
mvn clean package
java -jar target/funcionarios-springboot-1.0.0.jar
```

## Observações
- Todos os resultados são impressos no console.
- Aplicação pronta para ser extendida para REST API ou persistência em banco de dados.

---
Projeto criado para demonstração de habilidades em Java, manipulação de listas, Mapas, formatação de dados e uso de Spring Boot.
