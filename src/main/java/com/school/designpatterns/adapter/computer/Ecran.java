package com.school.designpatterns.adapter.computer;

public class Ecran implements VGA {
    @Override
    public void print(String message) {
        System.out.println("Écran : " + message);
    }
}
