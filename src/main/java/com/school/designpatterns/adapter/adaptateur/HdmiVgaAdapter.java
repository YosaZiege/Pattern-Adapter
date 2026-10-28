package com.school.designpatterns.adapter.adaptateur;

import com.school.designpatterns.adapter.computer.HDMI;
import com.school.designpatterns.adapter.computer.VGA;

import java.nio.charset.StandardCharsets;

public class HdmiVgaAdapter implements VGA {
    private HDMI hdmi;

    public void setHdmi(HDMI hdmi) {
        this.hdmi = hdmi;
    }

    @Override
    public void print(String message) {
        System.out.println("--- Adaptateur VGA -> HDMI ---");
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        hdmi.view(data);
    }
}
