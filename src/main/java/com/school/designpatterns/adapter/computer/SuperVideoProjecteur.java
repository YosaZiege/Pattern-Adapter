package com.school.designpatterns.adapter.computer;

import java.nio.charset.StandardCharsets;

public class SuperVideoProjecteur implements VGA, HDMI {
    @Override
    public void print(String message) {
        System.out.println("SuperVidéoProjecteur (VGA) : " + message);
    }

    @Override
    public void view(byte[] data) {
        System.out.println("SuperVidéoProjecteur (HDMI) : " + new String(data, StandardCharsets.UTF_8));
    }
}
