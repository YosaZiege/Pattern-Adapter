package com.school.designpatterns.adapter;

import com.school.designpatterns.adapter.adaptateur.HdmiVgaAdapter;
import com.school.designpatterns.adapter.adaptateur.HdmiVgaAdapterHeritage;
import com.school.designpatterns.adapter.computer.Ecran;
import com.school.designpatterns.adapter.computer.HDMI;
import com.school.designpatterns.adapter.computer.SuperVideoProjecteur;
import com.school.designpatterns.adapter.computer.UniteCentrale;
import com.school.designpatterns.adapter.computer.VGA;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdapterTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void uniteCentraleDelegueAEcran() {
        UniteCentrale uc = new UniteCentrale();
        uc.setVga(new Ecran());
        uc.print("Bonjour");
        assertTrue(out.toString().contains("Écran : Bonjour"));
    }

    @Test
    void adaptateurCompositionConvertitEtDelegue() {
        HdmiVgaAdapter adapter = new HdmiVgaAdapter();
        final byte[][] received = new byte[1][];
        adapter.setHdmi(data -> received[0] = data);

        adapter.print("Bonjour");

        assertArrayEquals("Bonjour".getBytes(StandardCharsets.UTF_8), received[0]);
        assertTrue(out.toString().contains("Adaptateur VGA -> HDMI"));
    }

    @Test
    void adaptateurHeritageDelegueATv() {
        HdmiVgaAdapterHeritage adapter = new HdmiVgaAdapterHeritage();
        adapter.print("Test");
        assertTrue(out.toString().contains("TV : Test"));
        assertTrue(out.toString().contains("héritage"));
    }

    @Test
    void superVideoProjecteurImplementeLesDeuxInterfaces() {
        SuperVideoProjecteur svp = new SuperVideoProjecteur();
        assertTrue(svp instanceof VGA);
        assertTrue(svp instanceof HDMI);
    }
}
