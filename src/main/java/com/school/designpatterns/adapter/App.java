package com.school.designpatterns.adapter;

import com.school.designpatterns.adapter.adaptateur.HdmiVgaAdapter;
import com.school.designpatterns.adapter.adaptateur.HdmiVgaAdapterHeritage;
import com.school.designpatterns.adapter.computer.Ecran;
import com.school.designpatterns.adapter.computer.SuperVideoProjecteur;
import com.school.designpatterns.adapter.computer.TV;
import com.school.designpatterns.adapter.computer.UniteCentrale;
import com.school.designpatterns.adapter.computer.VideoProjecteur;

public class App {
    public static void main(String[] args) {
        UniteCentrale uc = new UniteCentrale();

        uc.setVga(new Ecran());
        uc.print("Bonjour");

        uc.setVga(new VideoProjecteur());
        uc.print("Bonjour");

        HdmiVgaAdapter adapter = new HdmiVgaAdapter();
        adapter.setHdmi(new TV());
        uc.setVga(adapter);
        uc.print("Bonsoir TV");

        uc.setVga(new SuperVideoProjecteur());
        uc.print("Bonjour");

        HdmiVgaAdapter adapter2 = new HdmiVgaAdapter();
        adapter2.setHdmi(new SuperVideoProjecteur());
        uc.setVga(adapter2);
        uc.print("Bonsoir via HDMI");

        HdmiVgaAdapterHeritage adapterHeritage = new HdmiVgaAdapterHeritage();
        uc.setVga(adapterHeritage);
        uc.print("Test héritage");
    }
}
