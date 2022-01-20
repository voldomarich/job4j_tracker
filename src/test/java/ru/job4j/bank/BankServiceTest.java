package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void anotherTransferMoney() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("1187", "Miron Ivanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount(user1.getPassport(), new Account("5546", 2500D));
        bank.addAccount(user2.getPassport(), new Account("1000", 4300D));
        bank.transferMoney(user2.getPassport(), "1000", user1.getPassport(), "5546", 1500D);
        assertThat(bank.findByRequisite(user2.getPassport(), "1000").get().getBalance(), is(2800D));
        assertThat(bank.findByRequisite(user1.getPassport(), "5546").get().getBalance(), is(4000D));
    }
}
