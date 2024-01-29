package business.services;


import business.data.Player;
import business.data.Kartenset;
import business.data.Karte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
    KartenVerwalter kv = new KartenVerwalter();

    public SimpleStringProperty highscoreProperty = new SimpleStringProperty("0");
    public void setHighscoreProperty(String highscore){
        this.highscoreProperty.set(highscore);
    }
    public SimpleIntegerProperty cardFinished = new SimpleIntegerProperty(21);
    public void setCardFinished(int cardFinishedIndex){
        this.cardFinished.set(cardFinishedIndex);
    }

    public SimpleIntegerProperty cardReset = new SimpleIntegerProperty(21);
    public void setCardReset(int cardResetIndex){
        this.cardReset.set(cardResetIndex);
    }

    public SimpleIntegerProperty cardSelected = new SimpleIntegerProperty(21);

    public void setCardSelected(int firstCardIndex) {
        this.cardSelected.set(firstCardIndex);
    }

    public SoloGame(int kartenSetIndex, Player player, int spielfeldGroesse){
        this.ersteKarte = null;
        this.zweiteKarte = null;
        this.finished = false;
        points = new PunkteSystem(0,0,0);
        this.kartenset = kv.erstelleKartenset(kartenSetIndex);
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
    int firstCardIndex;
    int secondCardIndex;
    public String playerClick(int x){

        int i = 0;
        for(Karte k: spielfeld){
            System.out.println(i+ ": "+ k.getSoundName()+ " " + k.isIstEntfehrnt());
            i++;
        }

        if(ersteKarte == null) {
            System.out.println(spielfeld);
            this.ersteKarte = spielfeld.get(x);
            this.audioPlayer.playKartenSound(ersteKarte);
            this.lastCardIndex = x;
            setCardSelected(x);
            firstCardIndex =x ;
            return "clicked card1";
        }
        else{
            if(x == lastCardIndex){
                return "already selected";
            }
            setCardSelected(x);
            secondCardIndex = x;
            this.zweiteKarte =spielfeld.get(x);
            this.audioPlayer.playKartenSound(zweiteKarte);
            if(this.zweiteKarte.getSoundName().equals(this.ersteKarte.getSoundName())){
                this.ersteKarte.setIstEntfehrnt(true);  setCardFinished(firstCardIndex);
                this.zweiteKarte.setIstEntfehrnt(true); setCardFinished(secondCardIndex);


                if(getSpielfeldCardCount() == 0){
                    this.finished = true;
                    return "finished";
                }
                this.ersteKarte = null;
                this.zweiteKarte = null;
                setHighscoreProperty(Integer.toString(score.comboRechner(true)));
                return "Score: ";
            }else{
                this.ersteKarte = null;
                this.zweiteKarte = null;
                setCardReset(secondCardIndex);
                setHighscoreProperty(Integer.toString(score.comboRechner(false)));
                return "Score: ";
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

