package leapyear;

public class LeapYear {
    public static boolean isLeapYear(int a) {
    assert(a >= 1 && a <= 9999);
    if (a <= 1752)
        return a % 4 == 0;
    if (a % 400 == 0)
        return true;
    if (a % 100 == 0)
        return false;
    return a % 4 == 0;
}
}
