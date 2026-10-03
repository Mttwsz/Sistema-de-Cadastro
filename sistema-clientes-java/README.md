# Sistema de Clientes em Java

Projeto de estudo desenvolvido em Java para praticar fundamentos de programação orientada a objetos, coleções, validação de entrada e organização de código.

## Sobre o projeto

O Sistema de Clientes permite cadastrar, listar, buscar, atualizar e remover clientes por meio de um menu no terminal.

Os dados são mantidos em memória durante a execução da aplicação. O projeto foi estruturado de forma que uma futura evolução para persistência com banco de dados possa ser feita sem alterar a camada de interação do usuário.

## Funcionalidades

- Cadastro de clientes
- Listagem de clientes
- Busca por ID
- Atualização de dados
- Remoção de clientes
- Validação de campos obrigatórios
- Tratamento de entradas numéricas inválidas

## Tecnologias

- Java 21
- Maven
- JUnit 5
- Programação Orientada a Objetos

## Estrutura

```text
src/
├── main/
│   └── java/
│       └── br/com/mateus/sistemaclientes/
│           ├── Cliente.java
│           ├── ClienteService.java
│           └── SistemaClientes.java
└── test/
    └── java/
        └── br/com/mateus/sistemaclientes/
            └── ClienteServiceTest.java
```

## Como executar no NetBeans

1. Abra o NetBeans.
2. Selecione **File → Open Project** e escolha a pasta do projeto.
3. Confirme que o projeto usa o JDK 21.
4. Execute a classe `SistemaClientes.java`.

## Como executar pelo Maven

No terminal, dentro da pasta do projeto:

```bash
mvn clean test
mvn exec:java -Dexec.mainClass="br.com.mateus.sistemaclientes.SistemaClientes"
```

## Próximas evoluções

- Persistência em MySQL/PostgreSQL
- Separação em camadas (controller/repository/service)
- API REST
- Interface web
- Autenticação e autorização

## Autor

**Mateus Soares**  
Estudante de Sistemas de Informação — Unileste
