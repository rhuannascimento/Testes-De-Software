package leapyear;

import org.junit.jupiter.api.Test;

import leapyear.LeapYear;

import static org.junit.jupiter.api.Assertions.*;

public class IsLeapYearTest {

    @Test
    void testAnoBissextoAntes1752() {
        assertTrue(LeapYear.isLeapYear(1600)); 
        assertFalse(LeapYear.isLeapYear(1701));
    }

    @Test
    void testAnoDivisivelPor400() {
        assertTrue(LeapYear.isLeapYear(2000)); 
    }

    @Test
    void testAnoDivisivelPor100NaoBissexto() {
        assertFalse(LeapYear.isLeapYear(1900)); 
    }

    @Test
    void testAnoDivisivelPor4NaoSeculo() {
        assertTrue(LeapYear.isLeapYear(1996)); 
    }

    @Test
    void testAnoNaoBissexto() {
        assertFalse(LeapYear.isLeapYear(1999)); 
    }

    @Test
    void testLimitesValidos() {
        assertFalse(LeapYear.isLeapYear(1)); 
        assertTrue(LeapYear.isLeapYear(9996));
    }
}
