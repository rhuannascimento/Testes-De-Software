# Identifier Project

Este repositório contém atividades realizadas em sala de aula na disciplina Teste de Software.

O primeiro módulo, `Identifier`, verifica se uma cadeia de caracteres pode ser considerada um identificador válido. Regras básicas:

- Ter de 1 a 6 caracteres.
- Iniciar com uma letra.
- Conter apenas letras ou dígitos.

O projeto usa **Java** e **JUnit 5** para testes unitários.

## Estrutura do Projeto (resumo)

src/
├─ main/java/identifier/Identifier.java
├─ test/java/identifier/IdentifierTest.java
├─ main/java/leapYear/LeapYear.java
└─ test/java/leapYear/IsLeapYearTest.java
pom.xml
target/

## Novo módulo: isLeapYear (atividade em sala de aula)

Adicionei um módulo extra chamado `leapYear` como mais uma atividade implementada durante as aulas. O módulo contém:

- `LeapYear.java`: classe com o método público e estático `LeapYear.isLeapYear(int ano)` que retorna `true` se o ano for bissexto e `false` caso contrário. Há uma asserção interna que valida o intervalo do ano (1 a 9999).
- `IsLeapYearTest.java`: testes unitários que verificam casos de fronteira, anos divisíveis por 4, 100 e 400, e comportamento antes de 1752 (regra histórica usada no exercício).


## Novo módulo: stringsearch (atividade em sala de aula)

Adicionei o módulo `stringsearch`, que implementa uma pequena função e um programa interativo para procurar a primeira ocorrência de um caractere em uma cadeia de comprimento conhecido.

- `StringSearch.java`: implementa:
	- `findFirstChar(String s, char c)`: retorna a posição 1-based da primeira ocorrência de `c` em `s` ou `-1` se não encontrado. Lança `IllegalArgumentException` se `s` for `null`.
	- `validateLength(int len)`: valida se `len` está no intervalo [1,20].
	- `matchesLength(String s, int len)`: verifica se a string tem exatamente o comprimento esperado.
- `MainSearch.java`: programa CLI que solicita ao usuário:
	1. Um inteiro positivo entre 1 e 20 (comprimento desejado).
	2. Uma cadeia de caracteres desse comprimento (repete a leitura se o comprimento estiver errado).
	3. Um caractere para procurar na cadeia; retorna a posição 1-based ou mensagem de não encontrado.
	4. Pergunta se o usuário deseja procurar outro caractere (opção repetida).
- `StringSearchTest.java`: testes unitários cobrindo casos encontrados, não encontrados, validação de comprimento e comportamento com entrada nula.


## Como Executar

1. No diretório do projeto, compile e execute os testes com Maven:

```bash
cd /caminho/para/o/projeto
mvn compile
mvn test
```


