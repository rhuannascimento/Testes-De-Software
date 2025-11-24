package mcdc;

public class Mcdc {
    public int x = 0;
    public int y = 1;

    public void mcdc(int a, int b, int c, int d) {
        if (a > 0 && c == 1) {
            x = x + 1;
        }
        if (b == 3 || d < 0) {
            y = 0;
        }
    }
}
