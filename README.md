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

### 3) mcdc

Implementa um exercício de cobertura MC/DC (Modified Condition/Decision Coverage) com condições compostas. A classe possui dois atributos de estado (`x` e `y`) que são modificados conforme condições lógicas.

Principais características em `Mcdc.java`:

- `mcdc(int a, int b, int c, int d)`: avalia duas condições independentes:
  - Se `a > 0` **E** `c == 1`, incrementa `x` em 1.
  - Se `b == 3` **OU** `d < 0`, zera `y`.
- Atributos: `x` (inicia em 0) e `y` (inicia em 1).

Estratégia de teste (MC/DC):

Os testes garantem que cada condição (`a > 0`, `c == 1`, `b == 3`, `d < 0`) influencie independentemente o resultado da decisão, exercitando:

- **T1**: `a=true, c=true` → `x` incrementado
- **T2**: `a=false, c=true` → `x` não muda (mostra efeito de `a`)
- **T3**: `a=true, c=false` → `x` não muda (mostra efeito de `c`)
- **T4**: `b=true, d=false` → `y` zerado (mostra efeito de `b`)
- **T5**: `b=false, d=false` → `y` não muda
- **T6**: `b=false, d=true` → `y` zerado (mostra efeito de `d`)

Arquivos relevantes:

- `src/main/java/mcdc/Mcdc.java`
- `src/test/java/mcdc/McdcTest.java`

### 4) stringsearch

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

### 5) triangle

Classifica triângulos a partir dos comprimentos dos lados e valida se a entrada forma um triângulo. O método principal retorna uma das strings: `Equilateral`, `Isosceles`, `Scalene` ou `Invalid` (para entradas inválidas).

- `Triangle.classifyTriangle(int a, int b, int c)`: valida lados positivos, verifica a desigualdade triangular (a + b > c, a + c > b, b + c > a) e classifica:
	- `Equilateral` quando a = b = c
	- `Isosceles` quando dois lados são iguais
	- `Scalene` quando todos os lados são diferentes
	- `Invalid` se algum lado for não positivo ou violar a desigualdade triangular

Abordagem de testes: uso de Classes de Equivalência e Análise de Valor Limite, cobrindo, por exemplo:

- Mínimo válido: (1, 1, 1) → `Equilateral`
- Abaixo do limite: (0, 1, 1) → `Invalid`
- Fronteira da desigualdade: (1, 1, 2) → `Invalid`
- Soma igual e menor que o terceiro lado: (2, 3, 5) e (2, 3, 6) → `Invalid`
- Casos típicos válidos: (3, 4, 5) → `Scalene`, (4, 4, 2) → `Isosceles`, (2, 3, 4) → `Scalene`

Arquivos relevantes:

- `src/main/java/triangle/Triangle.java`
- `src/test/java/triangle/TriangleTest.java`

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
