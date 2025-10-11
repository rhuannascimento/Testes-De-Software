package stringsearch;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes avançados para a classe StringSearch demonstrando recursos do JUnit 5:
 * - @BeforeAll, @AfterAll, @BeforeEach, @AfterEach
 * - @ParameterizedTest com CsvSource e MethodSource
 * - Vários tipos de asserts (assertAll, assertThrows, assertDoesNotThrow, assertTimeout)
 */
public class StringSearchAdvancedTest {

    @BeforeAll
    static void globalSetup() {
        System.out.println("[StringSearchAdvancedTest] Iniciando suíte de testes avançados");
    }

    @AfterAll
    static void globalTeardown() {
        System.out.println("[StringSearchAdvancedTest] Finalizando suíte de testes avançados");
    }

    @BeforeEach
    void setupEach() {
    }

    @AfterEach
    void teardownEach() {
    }

    @ParameterizedTest(name = "findFirstChar: input={0} char={1} -> expected={2}")
    @CsvSource({
            "abc, a, 1",
            "abc, b, 2",
            "abc, c, 3",
            "abcd, d, 4"
    })
    void parameterizedFindFirstChar(String input, String ch, int expected) {
        char c = ch.charAt(0);
        assertEquals(expected, StringSearch.findFirstChar(input, c));
    }

    @Test
    void findFirstChar_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> StringSearch.findFirstChar(null, 'x'));
    }

    @ParameterizedTest(name = "validateLength: length={0} -> valid={1}")
    @CsvSource({
            "1, true",
            "20, true",
            "0, false",
            "21, false"
    })
    void parameterizedValidateLength(int length, boolean valid) {
        if (valid) {
            assertDoesNotThrow(() -> StringSearch.validateLength(length));
        } else {
            assertThrows(IllegalArgumentException.class, () -> StringSearch.validateLength(length));
        }
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> matchesLengthProvider() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("abcd", 4, true),
                org.junit.jupiter.params.provider.Arguments.of("abc", 4, false),
                org.junit.jupiter.params.provider.Arguments.of(null, 0, false)
        );
    }

    @ParameterizedTest(name = "matchesLength: input={0} expected={2}")
    @MethodSource("matchesLengthProvider")
    void parameterizedMatchesLength(String input, int length, boolean expected) {
        assertAll("matchesLength cases",
                () -> assertEquals(expected, StringSearch.matchesLength(input, length))
        );
    }

    @Test
    void performance_quicklyFindFirstChar() {
        assertTimeout(Duration.ofMillis(100), (Executable) () -> {
            assertEquals(1, StringSearch.findFirstChar("abc", 'a'));
        });
    }
}
