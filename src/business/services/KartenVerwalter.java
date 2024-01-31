package business.services;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import business.data.Karte;
import business.data.Kartenset;

public class KartenVerwalter {
    private final int kartenlimit = 10;

    public KartenVerwalter() {
    }

    public Kartenset erstelleKartenset(int kartenPackNummer) {
        System.out.println("kartenpack nummer "+ kartenPackNummer);
        File kartenSammler = new File("src/resources/Audio/Sounds/Kartenpaket/" + kartenPackNummer + "/");
        String name = "unbekannt";
        LinkedList<Karte> karten = new LinkedList();
        switch (kartenPackNummer) {
            case 1:
                name = "Tiere";
                break;
            case 2:
                name = "Midi";
                break;
            case 3:
                name = "Pico 8";
        }

        File[] var8;
        int var7 = (var8 = kartenSammler.listFiles()).length;

        for(int var6 = 0; var6 < var7; ++var6) {
            File fileEntry = var8[var6];
            System.out.println(fileEntry.getName());
            karten.add(new Karte(fileEntry.getName(), kartenPackNummer,false, false, false));
        }

        Kartenset kartenpset = new Kartenset(name, kartenPackNummer, karten);
        return kartenpset;
    }

    public Kartenset kartensetAuswaehlen(Kartenset kartenset) {
        while(kartenset.getKarte().size() > 10) {
            System.out.println(kartenset.getKarte().size());
            int index = (new Random()).nextInt(kartenset.getKarte().size());
            System.out.println(index);
            kartenset.getKarte().remove(index);
            Collections.shuffle(kartenset.getKarte());
        }

        return kartenset;
    }
}
