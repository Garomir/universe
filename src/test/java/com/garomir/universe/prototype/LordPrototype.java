package com.garomir.universe.prototype;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;

import java.util.ArrayList;
import java.util.List;

public class LordPrototype {

    public static Lord takeLord(){
        Lord l = new Lord();
        l.setId(1);
        l.setName("testName");
        l.setAge(100);
        return l;
    }

    public static List<Lord> takeLords() {
        List<Lord> lords = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Lord l = new Lord();
            l.setId(i);
            l.setName("name" + i);
            l.setAge(i);
            lords.add(l);
        }
        return lords;
    }
}
