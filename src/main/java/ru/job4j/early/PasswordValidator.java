package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {

        if (password.length() == 0) {
            throw new IllegalArgumentException("Строка пуста");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    String.format("Длина пароля: %s должна быть от 8 до 32 символов включительно",
                            password));
        }
        String[] string = {"qwerty", "12345", "password", "admin", "user", "parol"};
        for (String s : string) {
            if (password.toLowerCase().contains(s.toLowerCase())
                    || password.toUpperCase().contains(s.toUpperCase())) {
                    throw new IllegalArgumentException(
                            String.format("Пароль: %s не должен содержать данное слово "
                                    + "в любом регистре: %s", password, s));
                }
            }
        boolean statusWhiteSpace = true;
        boolean statusLowerCase = false;
        boolean statusUpperCase = false;
        boolean statusDigit = false;
        boolean statusSpecialSymbol = false;

        for (int i = 0; i < password.length(); i++) {

            if (isWhiteSpace(password.charAt(i))) {
                statusWhiteSpace = false;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                statusLowerCase = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                statusUpperCase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                statusDigit = true;
            }
            if (isSpecialSymbol(password.charAt(i))) {
                statusSpecialSymbol = true;
            }
        }

        if (!statusWhiteSpace) {
            throw new IllegalArgumentException(
                    String.format("Пароль: %s не должен содержать пробел", password));
        }
        if (!statusLowerCase) {
            throw new IllegalArgumentException(
                    String.format("Пароль: %s должен содержать хотя бы один символ "
                            + "в нижнем регистре", password));
        }
        if (!statusUpperCase) {
            throw new IllegalArgumentException(
                    String.format("Пароль: %s должен содержать хотя бы один символ "
                            + "в верхнем регистре", password));
        }
        if (!statusDigit) {
            throw new IllegalArgumentException(
                    String.format("Пароль: %s должен содержать хотя бы одну цифру", password));

        }
        if (!statusSpecialSymbol) {
            throw new IllegalArgumentException(
                    String.format("Пароль: %s должен содержать хотя бы один специальный символ",
                            password));
        }
        return password;
    }

    private static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 37 || code == 91 || code == 93 || code == 95;
    }

    private static boolean isWhiteSpace(int code) {
        return code == 32;
    }
}
