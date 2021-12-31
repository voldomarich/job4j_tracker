package ru.job4j.bank;

import java.util.Objects;

public class Account {
    /**
     * Класс Банковский счёт имеет два поля - реквизиты и баланс счёта;
     */
    private String requisite;
    private double balance;

    /**
     * Метод вызывается при создании экземпляра объекта совместно с оператором new;
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределить метод нужно, чтобы сравнивать два значения requisite;
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
