package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Строка пуста");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    String.format("Длина пароля: %s должна быть от 8 до 32 символов включительно",
                            password));
        }
        for (int i = 0; i < password.length(); i++) {
            if (isWhiteSpace(password.charAt(i))) {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s не должен содержать пробел", password));
            }
            if (!Character.isLowerCase(password.charAt(i))) {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы один символ "
                                + "в нижнем регистре", password));
            }
            if (!Character.isUpperCase(password.charAt(i))) {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы один символ "
                                + "в верхнем регистре", password));
            }
            if (!Character.isDigit(password.charAt(i))) {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы одну цифру", password));
            }
            if (!isSpecialSymbol(password.charAt(i))) {
                throw new IllegalArgumentException(
                        String.format("Пароль: %s должен содержать хотя бы один специальный символ",
                                password));
            }
        }
            String[] string = {"qwerty", "12345", "password", "admin", "user"};
            for (String s : string) {
                for (int a = 0; a < s.length(); a++) {
                    if (password.contains(s)
                            && (Character.isUpperCase(s.charAt(a))
                            || Character.isLowerCase(s.charAt(a)))) {
                        throw new IllegalArgumentException(
                                String.format("Пароль: %s не должен содержать данное слово "
                                        + "в любом регистре: %s", password, s));
                    }
                }
            }
        return password;
    }

    private static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 37 || code == 95 || code == 41 || code == 43;
    }

    private static boolean isWhiteSpace(int code) {
        return code == 32;
    }
}
