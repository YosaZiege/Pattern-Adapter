package com.school.designpatterns.adapter.computer;

public class UniteCentrale {
    private VGA vga;

    public void setVga(VGA vga) {
        this.vga = vga;
    }

    public void print(String message) {
        System.out.println("======= Unité centrale =======");
        vga.print(message);
        System.out.println("==============================");
    }
}
