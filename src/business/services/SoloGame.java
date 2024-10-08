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
    HighscoreVerwalter highscoreVerwalter = new HighscoreVerwalter();

    public SimpleStringProperty highscoreProperty = new SimpleStringProperty("0");
    public void setHighscoreProperty(String highscore){
        this.highscoreProperty.set(highscore);
    }
    public SimpleIntegerProperty cardFinished = new SimpleIntegerProperty(21);
    public void setCardFinished(int cardFinishedIndex){
        this.cardFinished.set(cardFinishedIndex);
    }
    public SimpleStringProperty comboProperty = new SimpleStringProperty("1x");
    public void setComboProperty(String newValue){ this.comboProperty.set(newValue);}
    public SimpleIntegerProperty cardReset = new SimpleIntegerProperty(21);
    public void setCardReset(int cardResetIndex){
        this.cardReset.set(cardResetIndex);
    }

    public SimpleIntegerProperty cardSelected = new SimpleIntegerProperty(21);

    public void setCardSelected(int firstCardIndex) {
        this.cardSelected.set(firstCardIndex);

    }
    public SimpleIntegerProperty finalScoreProperty = new SimpleIntegerProperty(0);
    public void setFinalScoreProperty(int score){ this.finalScoreProperty.set(score); }

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
            this.ersteKarte = spielfeld.get(x);
            this.audioPlayer.playKartenSound(ersteKarte);
            this.lastCardIndex = x;
            setCardSelected(x);
            System.out.println("cardselected: "+cardSelected.get());
            firstCardIndex =x ;
            return "clicked card1";
        }
        else{
            if(x == lastCardIndex){
                this.audioPlayer.playKartenSound(ersteKarte);
                return "already selected";
            }
            secondCardIndex = x;
            this.zweiteKarte =spielfeld.get(x);
            this.audioPlayer.playKartenSound(zweiteKarte);
            if(this.zweiteKarte.getSoundName().equals(this.ersteKarte.getSoundName())){
                this.ersteKarte.setIstEntfehrnt(true);  setCardFinished(firstCardIndex);
                this.zweiteKarte.setIstEntfehrnt(true); setCardFinished(secondCardIndex);


                if(getSpielfeldCardCount() == 0){
                    this.finished = true;
                    System.out.print("player final score: "+ this.score.gesammtPunkte);
                    setHighscoreProperty(Integer.toString(score.comboRechner(true)));
                    highscoreVerwalter.highscoreEintrag(this.player.getName(),this.score.gesammtPunkte,true);
                    return "finished";
                }
                this.ersteKarte = null;
                this.zweiteKarte = null;
                this.firstCardIndex = 0;
                this.secondCardIndex = 0;
                this.lastCardIndex = 0;
                setHighscoreProperty(Integer.toString(score.comboRechner(true)));
                setComboProperty(score.comboPointer+"x");
                return "Score: ";
            }else{
                this.ersteKarte = null;
                this.zweiteKarte = null;
                setCardReset(firstCardIndex);
                setCardReset(secondCardIndex);
                System.out.println("cardreset : "+firstCardIndex);
                System.out.println("cardreset : "+secondCardIndex);
                this.firstCardIndex = 0;
                this.secondCardIndex = 0;
                this.lastCardIndex = 0;
                setCardReset(21);
                setHighscoreProperty(Integer.toString(score.comboRechner(false)));
                setComboProperty(score.comboPointer+"x");
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

