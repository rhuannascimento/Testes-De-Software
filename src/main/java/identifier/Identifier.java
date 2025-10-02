package identifier;

public class Identifier {

    public static boolean isValidIdentifier(String id) {
        if (id == null || id.length() < 1 || id.length() > 6) {
            return false;
        }

        if (!Character.isLetter(id.charAt(0))) {
            return false;
        }

        for (char c : id.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
