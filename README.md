# Projeto Identifier — Atividades de Teste de Software

Este repositório reúne atividades práticas da disciplina de Teste de Software, implementadas em Java com testes unitários usando JUnit. O código está organizado em módulos independentes que exercitam regras de negócio simples e a escrita de testes.

## Módulos do Sistema

### 1) identifier

Valida se uma cadeia de caracteres pode ser considerada um identificador válido. Regras básicas:

- Ter de 1 a 6 caracteres.
- Iniciar com uma letra.
- Conter apenas letras ou dígitos.

Arquivos relevantes:

- `src/main/java/identifier/Identifier.java`
- `src/test/java/identifier/IdentifierTest.java`

### 2) leapyear (isLeapYear)

Implementa a verificação de ano bissexto segundo as regras tradicionais e uma regra histórica usada no exercício.

- `LeapYear.isLeapYear(int ano)`: retorna `true` se o ano for bissexto e `false` caso contrário.
- Há uma asserção interna que valida o intervalo do ano (1 a 9999).
- Os testes cobrem casos de fronteira, divisibilidade por 4, 100 e 400, além do comportamento antes de 1752.

Arquivos relevantes:

- `src/main/java/leapyear/LeapYear.java`
- `src/test/java/leapyear/IsLeapYearTest.java`

### 3) stringsearch

Fornece utilitários para procurar a primeira ocorrência de um caractere em uma cadeia, além de um pequeno programa interativo de linha de comando.

Principais métodos em `StringSearch.java`:

- `findFirstChar(String s, char c)`: retorna a posição 1-based da primeira ocorrência de `c` em `s`, ou `-1` se não encontrado. Lança `IllegalArgumentException` se `s` for `null`.
- `validateLength(int len)`: valida se `len` está no intervalo [1, 20].
- `matchesLength(String s, int len)`: verifica se a string tem exatamente o comprimento esperado.

Programa CLI em `MainSearch.java` (fluxo):

1. Lê um inteiro entre 1 e 20 (comprimento desejado).
2. Lê uma cadeia de caracteres com exatamente esse comprimento (repete até ficar correto).
3. Lê um caractere a ser buscado e imprime a posição 1-based da primeira ocorrência, ou uma mensagem de não encontrado.
4. Oferece repetir a busca com outro caractere.

Testes:

- `src/test/java/stringsearch/StringSearchTest.java`
- `src/test/java/stringsearch/StringSearchAdvancedTest.java`

## Como executar e testar (Maven)

No diretório do projeto:

```bash
mvn compile
mvn test
```

## Uso dos scripts

Além do Maven, há scripts no diretório raiz para agilizar tarefas comuns.

- `run.sh`: executa uma classe `main` via Maven Exec. Por padrão roda `stringsearch.MainSearch`.
	- Uso básico:
		```bash
		./run.sh               # roda stringsearch.MainSearch (padrão)
		./run.sh stringsearch.MainSearch  # executa a Main do módulo stringsearch
		```

- `test.sh`: compila o projeto e executa os testes unitários.
	- Uso:
		```bash
		./test.sh
		```
		(equivalente a `mvn compile && mvn test`)


Observação: se necessário, conceda permissão de execução aos scripts uma única vez:

```bash
chmod +x run.sh test.sh zip.sh
```
