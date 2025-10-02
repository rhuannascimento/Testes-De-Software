# Identifier Project

Este projeto é uma atividade implementada dento de sala de aula da disciplina Teste de Software. Oprograma **Identifier**, que verifica se uma cadeia de caracteres pode ser considerada um identificador válido. Um identificador válido deve:

- Ter de 1 a 6 caracteres.
- Iniciar com uma letra.
- Conter apenas letras ou dígitos.

O projeto utiliza **Java** e **JUnit 5** para testes unitários.

## Estrutura do Projeto

```

src/
├─ main/java/identifier/Identifier.java
└─ test/java/identifier/IdentifierTest.java
pom.xml
target/

````

- `Identifier.java`: Classe principal com a lógica de validação do identificador.
- `IdentifierTest.java`: Testes unitários para validar diferentes casos de uso.
- `pom.xml`: Configuração do Maven e dependências do projeto.

## Como Executar

1. Certifique-se de ter **Java 17+** e **Maven** instalados.
2. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/identifier.git
cd identifier
````

3. Compilar o projeto:

```bash
mvn compile
```

4. Executar os testes:

```bash
mvn test
```

## Casos de Teste

Os testes estão implementados em `IdentifierTest.java` e cobrem cenários válidos, inválidos e de fronteira para garantir o correto funcionamento do programa.
