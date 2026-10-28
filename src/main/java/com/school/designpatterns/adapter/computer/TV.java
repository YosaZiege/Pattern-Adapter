package com.school.designpatterns.adapter.computer;

import java.nio.charset.StandardCharsets;

public class TV implements HDMI {
    @Override
    public void view(byte[] data) {
        String message = new String(data, StandardCharsets.UTF_8);
        System.out.println("TV : " + message);
    }
}
