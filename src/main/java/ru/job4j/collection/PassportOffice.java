package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private final Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        for (String key : citizens.keySet()) {
            if (key.equals(passport)) {
                citizens.get(passport);
                System.out.println(passport + " - " + (citizens.get(passport)).getUsername());
            }
        }
        return citizens.get(passport);
    }
}
