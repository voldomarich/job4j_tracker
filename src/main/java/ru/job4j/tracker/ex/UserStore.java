package ru.job4j.tracker.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User item = new User();
        for (User user : users) {
            if (user.equals(login)) {
                item = user;
                break;
            }
            return item;
        }


        public static boolean validate (User user) throws UserInvalidException {
            for (User user : users) {
                if (user.length < 3) {
                    throw UserInvalidException;
                }
            }
        }

        public static void main (String[]args){
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
            try {
                if (findUser(users, login) != -1) {
                    validate(user, users);
                }
            } catch (UserInvalidException ea) {
                ea.printStackTrace();
            } catch (UserNotFoundException en) {
                en.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
