package stringsearch;

public class StringSearch {
    public static int findFirstChar(String s, char c) {
        if (s == null)
            throw new IllegalArgumentException("s não pode ser null");
        int idx = s.indexOf(c);
        return idx == -1 ? -1 : idx + 1;
    }

    public static void validateLength(int len) {
        if (len < 1 || len > 20)
            throw new IllegalArgumentException("length must be between 1 and 20");
    }

    public static boolean matchesLength(String s, int len) {
        return s != null && s.length() == len;
    }
}
