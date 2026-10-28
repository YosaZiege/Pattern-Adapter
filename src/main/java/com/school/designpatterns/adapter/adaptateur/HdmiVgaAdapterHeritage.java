package com.school.designpatterns.adapter.adaptateur;

import com.school.designpatterns.adapter.computer.TV;
import com.school.designpatterns.adapter.computer.VGA;

import java.nio.charset.StandardCharsets;

public class HdmiVgaAdapterHeritage extends TV implements VGA {
    @Override
    public void print(String message) {
        System.out.println("--- Adaptateur (héritage) VGA -> HDMI ---");
        super.view(message.getBytes(StandardCharsets.UTF_8));
    }
}
