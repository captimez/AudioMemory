package business.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import business.data.Highscore;

public class HighscoreVerwalter {
    public HighscoreVerwalter() {
    }

    public void highscoreEintrag(String name, int score, boolean singlePlayer) {
        int entryCounter = 0;
        File file;
        if (singlePlayer) {
            file = new File("src/resources/HighscoreListen/1SP/HighscoreTabelle.txt");
        } else {
            file = new File("src/resources/HighscoreListen/2SP/HighscoreTabelle.txt");
        }

        LinkedList<Highscore> liste = new LinkedList();

        try {
            Scanner scan = new Scanner(file);
            String first = scan.nextLine();
            if (Objects.equals(first, "#HighscoreTabelle 1 Spieler") || Objects.equals(first, "#HighscoreTabelle 2 Spieler")) {
                System.out.println("True");

                while(scan.hasNextLine()) {
                    if (scan.nextLine().contains("#ENTRY")) {
                        ++entryCounter;
                        String scoreDaten = scan.nextLine();
                        String[] nameScoreSplit = scoreDaten.split("--");
                        Highscore highscoreEintrag = new Highscore(nameScoreSplit[0], Integer.valueOf(nameScoreSplit[1]));
                        liste.add(highscoreEintrag);
                    } else {
                        System.out.println("True End");
                        System.out.println(scan.nextLine());
                    }
                }

                if (entryCounter >= 10) {
                    liste = this.highscoreTabelleSortieren(liste);
                    if (((Highscore)liste.get(9)).getPunkte() < score) {
                        liste = this.highscoreNeuNameEintrag(liste, name, score);
                        liste = this.highscoreTabelleSortieren(liste);
                        liste.remove(10);
                        this.highscoreNeuListe(liste, entryCounter, singlePlayer);
                    } else {
                        System.out.println("Kein Eintrag Platzt, wegen niedrige Punktzahl");
                    }
                } else {
                    liste = this.highscoreNeuNameEintrag(liste, name, score);
                    liste = this.highscoreTabelleSortieren(liste);
                    this.highscoreNeuListe(liste, entryCounter, singlePlayer);
                }
            }
        } catch (FileNotFoundException var11) {
            System.out.println("Something bad happened");
        }

    }

    public LinkedList<Highscore> highscoreTabelleSortieren(LinkedList<Highscore> list) {
        Collections.sort(list);
        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            Highscore entry = (Highscore)var3.next();
            System.out.println(entry.getSpielerName() + ": " + entry.getPunkte());
        }

        return list;
    }

    public LinkedList<Highscore> highscoreNeuNameEintrag(LinkedList<Highscore> liste, String name, int score) {
        Highscore highscoreEintrag = new Highscore(name, score);
        liste.add(highscoreEintrag);
        return liste;
    }

    public void highscoreNeuListe(LinkedList<Highscore> liste, int entryCounter, boolean singlePlayer) {
        try {
            FileWriter newFileVersion;
            if (singlePlayer) {
                newFileVersion = new FileWriter("src/resources/HighscoreListen/1SP/HighscoreTabelle.txt");
            } else {
                newFileVersion = new FileWriter("src/resources/HighscoreListen/2SP/HighscoreTabelle.txt");
            }

            newFileVersion.write("#HighscoreTabelle 1 Spieler\n");

            for(int i = 0; i < liste.size(); ++i) {
                String part1 = ((Highscore)liste.get(i)).getSpielerName();
                int part2 = ((Highscore)liste.get(i)).getPunkte();
                newFileVersion.write("#ENTRY\n");
                newFileVersion.write(part1 + "--" + part2 + "\n");
            }

            newFileVersion.write("#TOTALENTRYS\n");
            if (entryCounter >= 10) {
                newFileVersion.write(entryCounter + "\n");
            } else {
                ++entryCounter;
                newFileVersion.write(entryCounter + "\n");
            }

            newFileVersion.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    public void resetHighscore(boolean singlePlayer) {
        try {
            FileWriter newFileVersion;
            if (singlePlayer) {
                newFileVersion = new FileWriter("src\\resources\\HighscoreListen\\1SP\\HighscoreTabelle.txt");
                newFileVersion.write("#HighscoreTabelle 1 Spieler\n");
            } else {
                newFileVersion = new FileWriter("src\\resources\\HighscoreListen\\1SP\\HighscoreTabelle.txt");
                newFileVersion.write("#HighscoreTabelle 2 Spieler\n");
            }

            newFileVersion.close();
        } catch (FileNotFoundException var3) {
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public LinkedList<Highscore> showListe(boolean singlePlayer) {
        int entryCounter = 0;
        File file;
        if (singlePlayer) {
            file = new File("src/resources/HighscoreListen/1SP/HighscoreTabelle.txt");
            System.out.println("singelplayer");
        } else {
            file = new File("src/resources/HighscoreListen/2SP/HighscoreTabelle.txt");
            System.out.println("multiplayer");
        }

        LinkedList<Highscore> liste = new LinkedList();


        try {
            Scanner scan = new Scanner(file);
            String first = scan.nextLine();
            if (Objects.equals(first, "#HighscoreTabelle 1 Spieler") || Objects.equals(first, "#HighscoreTabelle 2 Spieler")) {
                System.out.println("True");

                while (scan.hasNextLine()) {
                    if (scan.nextLine().contains("#ENTRY")) {
                        ++entryCounter;
                        String scoreDaten = scan.nextLine();
                        String[] nameScoreSplit = scoreDaten.split("--");
                        Highscore highscoreEintrag = new Highscore(nameScoreSplit[0], Integer.valueOf(nameScoreSplit[1]));
                        liste.add(highscoreEintrag);
                    } else {
                        System.out.println("True End");
                        System.out.println(scan.nextLine());
                    }
                }
                return liste;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something bad happened");
        }
        return liste;
    }
}
