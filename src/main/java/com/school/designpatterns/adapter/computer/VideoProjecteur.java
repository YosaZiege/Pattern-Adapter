package com.school.designpatterns.adapter.computer;

public class VideoProjecteur implements VGA {
    @Override
    public void print(String message) {
        System.out.println("VidéoProjecteur : " + message);
    }
}
