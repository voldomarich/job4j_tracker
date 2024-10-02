package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    @Setter
    private String name;
    @Singular("rule")
    private List<String> rules;
}
