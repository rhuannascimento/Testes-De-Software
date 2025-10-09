package stringsearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringSearchTest {

    @Test
    void testFindFirstCharFound() {
        assertEquals(1, StringSearch.findFirstChar("abc", 'a'));
        assertEquals(2, StringSearch.findFirstChar("abc", 'b'));
        assertEquals(3, StringSearch.findFirstChar("abc", 'c'));
    }

    @Test
    void testFindFirstCharNotFound() {
        assertEquals(-1, StringSearch.findFirstChar("abc", 'x'));
    }

    @Test
    void testFindFirstCharNull() {
        assertThrows(IllegalArgumentException.class, () -> StringSearch.findFirstChar(null, 'a'));
    }

    @Test
    void testValidateLength() {
        assertDoesNotThrow(() -> StringSearch.validateLength(1));
        assertDoesNotThrow(() -> StringSearch.validateLength(20));
        assertThrows(IllegalArgumentException.class, () -> StringSearch.validateLength(0));
        assertThrows(IllegalArgumentException.class, () -> StringSearch.validateLength(21));
    }

    @Test
    void testMatchesLength() {
        assertTrue(StringSearch.matchesLength("abcd", 4));
        assertFalse(StringSearch.matchesLength("abc", 4));
        assertFalse(StringSearch.matchesLength(null, 0));
    }
}
