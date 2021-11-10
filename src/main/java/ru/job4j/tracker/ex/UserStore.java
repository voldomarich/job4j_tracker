package ru.job4j.tracker.ex;

public class UserStore {

    public static User[] findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
            throw new UserNotFoundException("User is not found");
    }


        public static boolean validate(User user) throws UserInvalidException {
            if (!user.isValid() || user.length < 3) {
                throw new UserInvalidException("User is not validated");
            }
            return true;
        }

        public static void main (String[] args){
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            try {
                User user = findUser(users, "Petr Arsentev");
                validate(user);
            } catch (UserNotFoundException ea) {
                ea.printStackTrace();
            }
        }
    }
