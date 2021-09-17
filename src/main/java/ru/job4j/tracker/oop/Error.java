package ru.job4j.tracker.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public void printInfo() {
        System.out.println("Наличие ошибки: " + active);
        System.out.println("Ошибка №" + status);
        System.out.println("Наименование: " + message);
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error e = new Error();
        e.printInfo();
        Error error = new Error(true, 404, "Not found");
        error.printInfo();
        Error er = new Error(true, 408, "Request TimeOut");
        er.printInfo();
        Error err = new Error(true, 510, "Not Extended ");
        err.printInfo();
    }
    }
