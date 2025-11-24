package mcdc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class McdcTest {

    private Mcdc obj;

    @BeforeEach
    public void setup() {
        obj = new Mcdc();
    }

    @Test
    public void T1ATrueCTrue() {
        obj.mcdc(1, 0, 1, 0);
        assertEquals(1, obj.x);
    }

    @Test
    public void T2AFalseCTrue() {
        obj.mcdc(0, 0, 1, 0);
        assertEquals(0, obj.x);
    }

    @Test
    public void T3ATrueCFalse() {
        obj.mcdc(1, 0, 0, 0);
        assertEquals(0, obj.x);
    }

    @Test
    public void T4BTrueDFalse() {
        obj.mcdc(0, 3, 0, 1);
        assertEquals(0, obj.y);
    }

    @Test
    public void T5BFalseDFalse() {
        obj.mcdc(0, 0, 0, 1);
        assertEquals(1, obj.y);
    }

    @Test
    public void T6BFalseDTrue() {
        obj.mcdc(0, 0, 0, -1);
        assertEquals(0, obj.y);
    }

}
