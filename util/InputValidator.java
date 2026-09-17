package util;

public class InputValidator {

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}