package identifier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IdentifierTest {

    @Test
    public void testValidIdentifiers() {
        assertTrue(Identifier.isValidIdentifier("a1"));
        assertTrue(Identifier.isValidIdentifier("abc"));
        assertTrue(Identifier.isValidIdentifier("x123"));
        assertTrue(Identifier.isValidIdentifier("z9z9z9"));
    }

    @Test
    public void testInvalidLength() {
        assertFalse(Identifier.isValidIdentifier(""));
        assertFalse(Identifier.isValidIdentifier("abcdefg"));
    }

    @Test
    public void testInvalidFirstCharacter() {
        assertFalse(Identifier.isValidIdentifier("1abc"));
        assertFalse(Identifier.isValidIdentifier("_abc"));
        assertFalse(Identifier.isValidIdentifier("9"));
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(Identifier.isValidIdentifier("abc!"));
        assertFalse(Identifier.isValidIdentifier("a b"));
        assertFalse(Identifier.isValidIdentifier("a-b"));
    }
}
