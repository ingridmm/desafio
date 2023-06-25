# Cad Company
Projeto de um sistema de cadastro de empresa utilizando Java/SpringBoot.

Com funções Cadastrar Fornecedores e Empresas, além de Listar, Alterar e Excluir ou Inativar um usuário.

## Tecnologias Utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- MySQL
- Lombok
- Flyway DB

# Instalação
O projeto é gerenciado pelo Maven, bastando utilizá-lo em uma IDE;

# Configurações do banco de dados - MySQL
O Banco de Dados utilizado foi o MySQL. 
Passos para configurar no projeto: 
1. Abra o arquivo application.properties, localizado em src/main/resources/application.properties;
2. Altere os seguintes comandos ao arquivo, como exemplificado na figura abaixo:
```
spring.datasource.url
spring.datasource.username
spring.datasource.password
```
![Configurações DataBase](https://github.com/ingridmm/desafio/blob/master/datasource_configs.png)

# Execução
Execute o projeto através do IDE, exemplo IntelliJ, abra um navegador e digite: http://localhost:8080

Obs: Caso ocorra algum erro de dependências ou configurações do projeto, basta acessá-las ou visualizá-las em [Configurações Nativas do Projeto no Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.8&packaging=jar&jvmVersion=17&groupId=com.cadCompany&artifactId=desafio&name=desafio&description=Demo%20project%20for%20Spring%20Boot&packageName=com.cadCompany.desafio&dependencies=web,devtools,lombok,data-jpa,validation)
