package ru.job4j.additional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOrElse {

    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException {
    }

    public static User orElseThrow(List<User> list, String login) {
        if (search(list, login).isEmpty()) {
            throw new UserNotFoundException();
        }
        return search(list, login).get();
    }

        private static Optional<User> search(List<User> list, String login) {
            Optional<User> user = Optional.empty();
            for (User u : list) {
                if (Objects.equals(u.getLogin(), login)) {
                    user = Optional.of(u);
                }
            }
            return user;
        }
    }
