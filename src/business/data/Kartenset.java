package business.data;

import java.util.LinkedList;

public class Kartenset {
    public String name;
    public int serienNummer;
    public LinkedList<Karte> karten;

    public Kartenset(String name, int serienNummer) {
        this.name = name;
        this.serienNummer = serienNummer;
        this.karten = new LinkedList();
    }

    public Kartenset(String name, int serienNummer, LinkedList<Karte> karten) {
        this.name = name;
        this.serienNummer = serienNummer;
        this.karten = karten;
    }

    public LinkedList<Karte> getKarte() {
        return this.karten;
    }

    public void setKarte(LinkedList<Karte> karten) {
        this.karten = karten;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerienNummer() {
        return this.serienNummer;
    }

    public void setSerienNummer(int serienNummer) {
        this.serienNummer = serienNummer;
    }
}
