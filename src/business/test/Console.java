package business.test;

import business.services.HighscoreVerwalter;
import business.data.Karte;
import business.data.Kartenset;
import business.services.KartenVerwalter;

public class Console {
    public Console() {
    }

    public static void main(String[] args) {
        String name = "NeuMann";
        int score = 1775;
        HighscoreVerwalter htest = new HighscoreVerwalter();

        while(name.length() >= 8 || name.isEmpty() || name.matches(".*\\d.*")) {
            System.out.println("Limit von 8 UND ODER nur Buchstaben setzen");
        }

        htest.highscoreEintrag(name, score, true);
        KartenVerwalter kvtest = new KartenVerwalter();
        int kartenAuswahlNummer = 3;
        Kartenset ksetTest = kvtest.erstelleKartenset(kartenAuswahlNummer);
        ksetTest = kvtest.kartensetAuswaehlen(ksetTest);

        for(int i = 0; ksetTest.getKarte().size() > i; ++i) {
            System.out.println(((Karte)ksetTest.getKarte().get(i)).getSoundName());
        }

    }
}