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
        String[] string = {"qwerty", "12345", "password", "admin", "user"};
        for (String s : string) {
            if (password.contains(s.toLowerCase())
                    || password.contains(s.toUpperCase())) {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s не должен содержать данное слово "
                                + "в любом регистре: %s", password, s));
            }
        }
        for (int i = 0; i < password.length(); i++) {
            boolean statusWhiteSpace = false;
            boolean statusLowerCase = false;
            boolean statusUpperCase = false;
            boolean statusDigit = false;
            boolean statusSpecialSymbol = false;

            if (!isWhiteSpace(password.charAt(i))) {
                statusWhiteSpace = true;
            } else {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s не должен содержать пробел", password));
            }
            if (Character.isLowerCase(password.charAt(i))) {
                statusLowerCase = true;
            } else {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы один символ "
                                + "в нижнем регистре", password));
            }
            if (Character.isUpperCase(password.charAt(i))) {
                statusUpperCase = true;
            } else {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы один символ "
                                + "в верхнем регистре", password));
            }
            if (Character.isDigit(password.charAt(i))) {
                statusDigit = true;
            } else {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы одну цифру", password));
            }
            if (!isSpecialSymbol(password.charAt(i))) {
                statusSpecialSymbol = true;
            } else {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы один специальный символ",
                                password));
            }
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
