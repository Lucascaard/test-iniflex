# Sistema de Gerenciamento de Funcionários

Este projeto implementa um sistema de gerenciamento de funcionários com operações básicas de CRUD e análises adicionais.

## Funcionalidades

- Inserção de funcionários
- Remoção de funcionários específicos
- Impressão de lista de funcionários formatada
- Atualização de salários (aumento de 10%)
- Agrupamento por função
- Análise de aniversariantes
- Cálculo de idade dos funcionários
- Ordenação alfabética
- Cálculo total de salários
- Análise de salários mínimos

## Estrutura do Projeto

```markdown
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   └── iniflex/
│   │   │       ├── model/
│   │   │       │   ├── Funcionario.java
│   │   │       │   └── Pessoa.java
│   │   │       ├── service/
│   │   │       │   └── FuncionarioService.java
│   │   │       └── util/
│   │   │           └── FuncionarioUtil.java
│   │   └── Main.java
│   └── resources/
└── test/
    └── java/
```

## Dependências

- Java 21
- Java Collections Framework
- Java Stream API
- Java Time API

## Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Lucascaard/test-iniflex.git
```

2. Compile e execute:
```bash
cd test-iniflex
javac -d target src/main/java/com/iniflex/Main.java src/main/java/com/iniflex/model/*.java src/main/java/com/iniflex/service/*.java src/main/java/com/iniflex/util/*.java

# Execute o programa
java -cp target com.iniflex.Main
```

## Licença

Este projeto é licenciado sob a licença MIT.
