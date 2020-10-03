Projeto utilizado para realizar um CRUD de cadastro de pessoa

# Visão geral

O projeto é uma aplicação back-end utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Data](http://projects.spring.io/spring-data).

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) 
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)

- [Spring Data](http://projects.spring.io/spring-data/) 

 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
Maven 3.6.3 
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/eduardogewehr/userCRUD.git
```
Feito isso, acesse o projeto:
```
cd userCRUD
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```

# APIs

O projeto disponibiliza as APIs em 1 contexto: User, onde utiliza o padrão Rest de comunicação, produzindo e consumindo arquivos no formato JSON.

Segue abaixo as APIs disponíveis no projeto:

#### User

 - /user (GET)
 - /user/{document} (GET)
 - /user/delete/{document} (DELETE)
 - /user/create (PUT)
     - Espera atributos do usuário no body da requisição, exemplo:
    ```
   {
      "name": "José da Silva",
      "nickname": "Zé",
      "document": "08240145027",
      "profession": "Engenheiro",
      "salary": 5555,
      "dateOfBirth" : "1996-08-16",
      "adresses": [
          {
              "typeAddress": "Residencial",
              "type": "Rua",
              "name": "Minha Casa",
              "number": "1173",
              "complement": "Apartamento 804",
              "cep": "99010101",
              "neighborhood": "Centro",
              "city": "Passo Fundo",
              "state": "RS",
              "country": "BR"
          },
           {
              "typeAddress": "Residencial",
              "type": "Rua",
              "name": "Casa dos meus pais",
              "number": "890",
              "cep": "98200000",
              "neighborhood": "Centro",
              "city": "Ibirubá",
              "state": "RS",
              "country": "BR"
          }
      ],
      "phones": [
          {
              "countryCode": "55",
              "ddd": "54",
              "number": "991169413",
              "type": "Pessoal"
          },
           {
              "countryCode": "55",
              "ddd": "54",
              "number": "991169321",
              "type": "Pessoal"
          }
      ],
      "dependents": [
          {
              "name": "João da Silva",
              "type": "Filho"
          } 
      ]
   } 
    ```
- /user/update (POST)
     - Espera atributos do usuário no body da requisição, exemplo:
    ```
   {
      "name": "José da Silva",
      "nickname": "Zé",
      "document": "08240145027",
      "profession": "Engenheiro",
      "salary": 5555,
      "dateOfBirth" : "1996-08-16",
      "adresses": [
          {
              "typeAddress": "Residencial",
              "type": "Rua",
              "name": "Minha Casa",
              "number": "1173",
              "complement": "Apartamento 804",
              "cep": "99010101",
              "neighborhood": "Centro",
              "city": "Passo Fundo",
              "state": "RS",
              "country": "BR"
          },
           {
              "typeAddress": "Residencial",
              "type": "Rua",
              "name": "Casa dos meus pais",
              "number": "890",
              "cep": "98200000",
              "neighborhood": "Centro",
              "city": "Ibirubá",
              "state": "RS",
              "country": "BR"
          }
      ],
      "phones": [
          {
              "countryCode": "55",
              "ddd": "54",
              "number": "991169413",
              "type": "Pessoal"
          },
           {
              "countryCode": "55",
              "ddd": "54",
              "number": "991169321",
              "type": "Pessoal"
          }
      ],
      "dependents": [
          {
              "name": "João da Silva",
              "type": "Filho"
          } 
      ]
  }
    ```
