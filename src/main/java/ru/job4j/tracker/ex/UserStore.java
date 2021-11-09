package ru.job4j.tracker.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.toString())) {
                return user;
            } else {
                throw new UserNotFoundException("User is not found");
            }
        }
        return user;
    }


        public static boolean validate(User user) throws UserInvalidException {
            if (!user.isValid() && user.length < 3) {
                throw new UserInvalidException("User is not valideted");
            } else {
                return true;
            }
        }

        public static void main (String[] args){
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate("Petr Arsentev")) {
                System.out.println("Petr Arsentev has an access");
            }
            try {
                if (findUser(users, "Petr Arsentev" ) != -1) {
                    validate("Petr Arsentev") ;
                }
            } catch (UserInvalidException ea) {
                ea.printStackTrace();
            } catch (UserNotFoundException en) {
                en.printStackTrace();
            }
        }
    }

