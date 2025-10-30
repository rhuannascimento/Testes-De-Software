package triangle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void testEquilateral() {
        assertEquals("Equilateral", Triangle.classifyTriangle(3, 3, 3));
    }

    @Test
    public void testIsosceles() {
        assertEquals("Isosceles", Triangle.classifyTriangle(4, 4, 2));
    }

    @Test
    public void testScalene() {
        assertEquals("Scalene", Triangle.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testInvalidEqualSum() {
        assertEquals("Invalid", Triangle.classifyTriangle(2, 3, 5));
    }

    @Test
    public void testInvalidSmallerSum() {
        assertEquals("Invalid", Triangle.classifyTriangle(2, 3, 6));
    }

    @Test
    public void testInvalidZeroSide() {
        assertEquals("Invalid", Triangle.classifyTriangle(0, 2, 2));
    }

    @Test
    public void testBoundaryValidTriangle() {
        assertEquals("Scalene", Triangle.classifyTriangle(2, 3, 4));
    }

    @Test
    public void testBoundaryEqualSides() {
        assertEquals("Invalid", Triangle.classifyTriangle(1, 1, 2));
    }

    @Test
    public void testMinimumValidTriangle() {
        assertEquals("Equilateral", Triangle.classifyTriangle(1, 1, 1));
    }

    @Test
    public void testBelowBoundary() {
        assertEquals("Invalid", Triangle.classifyTriangle(0, 1, 1));
    }
}
