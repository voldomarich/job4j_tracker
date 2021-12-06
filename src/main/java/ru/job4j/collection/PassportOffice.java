package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private final Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (citizen != null && !citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen citizen = null;
        for (String key : citizens.keySet()) {
            if (key.equals(passport)) {
                citizen = citizens.get(passport);
                System.out.println(passport + " - " + citizen.getUsername());
            }
        }
        return citizen;
    }
}
