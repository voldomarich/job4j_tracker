package ru.job4j.bank;

import java.util.*;
/**
 * Класс систематизирует перечень клиентов(пользователей) банка, их счетов и паспортных данных
 * и позволяет быстро находить необходимую информацию,
 * в т.ч. о передвижении денежных средств между счетами клиентов
 *
 * @author Vladimir Bekasov
 * @version 1.0
 */

public class BankService {

    /**
     * создаём коллекцию под названием users типа HashMap,
     * где будут храниться данные двух типов: User и List<Account>
     * (т.е. пользователь и список его банковских счетов);
     * делаем её final, чтобы нельзя было унаследовать её значение;
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию users(список пользователей),
     * предварительно проверяя, нет ли его уже в исходной коллекциии users;
     *
     * в качестве списка его банковских счетов создаёт новый, пока пустой список(new ArrayList<>());
     *
     * @param user - пользователь, который добавляется в коллекцию;
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет к списку банковских счетов пользователя (list) новый счёт (account);
     *
     * Метод принимает на вход значение типа String - паспортные данные пользователя
     * (чтобы по ним найти пользователя, которому принадлежат эти паспортные данные),
     * а также значение типа Account - банковский счёт,
     * который необходимо добавить конкретному пользователю
     * (у одного пользователя может быть несколько счетов);
     *
     * Найдя пользователя, с помощью if задаём условие,
     * что пользователь имеет полные данные (не равен null);
     *
     * Далее достаём пользователя из коллекции users,
     * на выходе получаем список счетов пользователя list типа List<Account>
     * (реквизиты счёта + баланс счёта);
     * Проверяем, что список с данными пользователя не содержит уже тот банковский счёт,
     * который мы собрались ему добавить;
     *
     * Далее добавляем новый банковский счёт в list - список уже имеющихся счетов пользователя;
     *
     * @param passport паспортные данные, значение типа String;
     * @param account банковский счёт, который необходимо добавить к списку счетов пользователя;
     */
    public void addAccount(String passport, Account account) {
        Optional<User> opt = findByPassport(passport);
        if (opt.isPresent()) {
            List<Account> list = users.get(opt.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод должен найти аккаунт пользователя (паспортные данные и ФИО пользователя);
     * Для этого мы перебираем коллекцию users циклом foreach,
     * и проверяем на соответствие входящее значение passport каждому элементу коллекции
     * (нас интересует только одно поле пользователя - паспорт);
     *
     * если соответствует - возвращаем пользователя, пасспорт которого совпал с входящим значением;
     * @param passport паспортные данные, значение типа String, по которым нужно найти аккаунт;
     * @return user аккаунт искомого пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals((passport)))
                .findFirst();
    }

    /**
     * Метод ищет банковский счёт пользователя (account) по паспорту пользователя
     * и по реквизиту банковского счёта
     * @param passport паспорт пользователя User
     * @param requisite реквизит банковского счёта Account
     * @return account банковский счёт пользователя (у него их может быть несколько,
     * нам нужен конкретный по реквизиту)
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> account = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return account;
    }

    /**
     * Метод отображает процесс перевода денежных средств со счёта на счёт
     * @param srcPassport паспорт пользователя, со счёта которого переводим средства;
     * @param srcRequisite реквизиты банковского счёта, с которого переводим средства;
     * @param destPassport паспорт пользователя, на счёт которого переводим средства;
     * @param destRequisite реквизиты банковского счёта, на который переводим средства;
     * @param amount сумма перевода
     * @return true, если баланс первого счёта снизился на amount,
     * а второго увеличился на amount или false, если этого не произошло
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
