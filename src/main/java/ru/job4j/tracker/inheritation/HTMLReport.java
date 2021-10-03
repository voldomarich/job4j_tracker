package ru.job4j.tracker.inheritation;

public class HTMLReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>" +
                "<br/>" +
                "<span>" + body + "</span>";
   }
}
