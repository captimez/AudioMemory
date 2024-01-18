package business.services;


import business.data.Player;
import business.services.KartenVerwalter;
import business.data.Kartenset;
import business.data.Karte;
import business.services.AudioPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import business.services.PunkteSystem;

public class SoloGame {
    Player player;
    PunkteSystem score = new PunkteSystem(0,0,0);
    AudioPlayer audioPlayer;

    int comboCounter = 0;
    Kartenset kartenset;
    PunkteSystem points;

    int lastCardIndex;
    Karte ersteKarte;
    Karte zweiteKarte;
    ArrayList<Karte> spielfeld = new ArrayList<>();
    boolean finished;

    private final  int punkte = 100;

    KartenVerwalter kv = new KartenVerwalter();

    public SoloGame(int kartenSetIndex, Player player, int spielfeldGroesse){
        this.ersteKarte = null;
        this.zweiteKarte = null;
        this.finished = false;
        points = new PunkteSystem(0,0,0);
        this.kartenset = kv.erstelleKartenset(1);
        initSpielfeld(20,kv.kartensetAuswaehlen(this.kartenset).getKarte());
        this.audioPlayer = new AudioPlayer();
        this.player = player;
    }

    private void initSpielfeld(int groesse,LinkedList<Karte> cards) {
        LinkedList<Karte> doppelteKarten = new LinkedList<>();
        for (Karte karte : cards) {
            doppelteKarten.add(karte);
            doppelteKarten.add(karte);
        }

        // Mische die Liste
        Collections.shuffle(doppelteKarten);

        // Fülle das Spielfeld mit den gemischten Karten
        int i = 0;
        for (Karte x: doppelteKarten) {
            spielfeld.add(doppelteKarten.get(i));
            i++;
        }
    }

    public String playerClick(int x){

        int i = 0;
        for(Karte k: spielfeld){
            System.out.println(i+ ": "+ k.getSoundName()+ " " + k.isIstEntfehrnt());
            i++;
        }

        if(ersteKarte == null) {
            this.ersteKarte = spielfeld.get(x);
            this.audioPlayer.playKartenSound(ersteKarte);
            this.lastCardIndex = x;
            return "clicked card1";
        }
        else{
            if(x == lastCardIndex){
                return "already selected";
            }
            this.zweiteKarte =spielfeld.get(x);
            this.audioPlayer.playKartenSound(zweiteKarte);
            if(this.zweiteKarte.getSoundName().equals(this.ersteKarte.getSoundName())){
                this.ersteKarte.setIstEntfehrnt(true);
                this.zweiteKarte.setIstEntfehrnt(true);
                if(getSpielfeldCardCount() == 0){
                    this.finished = true;
                    return "finished";
                }
                this.ersteKarte = null;
                this.zweiteKarte = null;

                return "Score: "+ score.comboRechner(true);
            }else{
                this.ersteKarte = null;
                this.zweiteKarte = null;
                return "Score: "+ score.comboRechner(false);
            }

        }
    }

    int getSpielfeldCardCount(){
        int cardCount = 0;
        for( Karte x: spielfeld){
            if(!x.isIstEntfehrnt())
                cardCount+=1;
        }
        return cardCount;
    }

    public Boolean finished(){
        return this.finished;
    }



}

