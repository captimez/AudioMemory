package business.services;

import business.data.Karte;
import business.data.Kartenset;
import business.data.Player;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MultiplayerGame {
    public HighscoreVerwalter highscoreVerwalter;
    public Player player1;
    public Player player2;
    Player currentPlayer;

    AudioPlayer audioPlayer;
    Kartenset kartenset;

    int lastCardIndex;
    Karte ersteKarte;
    Karte zweiteKarte;
    ArrayList<Karte> spielfeld = new ArrayList<>();
    boolean finished;
    KartenVerwalter kv = new KartenVerwalter();
    Player winningPlayer;

    public SimpleStringProperty highscoreProperty1 = new SimpleStringProperty("0");
    public void setHighscoreProperty1(String highscore){
        this.highscoreProperty1.set(highscore);
    }
    public SimpleStringProperty highscoreProperty2 = new SimpleStringProperty("0");
    public void setHighscoreProperty2(String highscore){
        this.highscoreProperty2.set(highscore);
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

    public SimpleStringProperty currentPlayerProperty = new SimpleStringProperty("player");
    public void setCurrentPlayerProperty(String playerName) { this.currentPlayerProperty.set(playerName);}

    public SimpleStringProperty winningPlayerProperty = new SimpleStringProperty();
    public void setWinningPlayerProperty (String winnerString){ this.winningPlayerProperty.set(winnerString);}

    public MultiplayerGame(int kartenSetIndex, Player player1,Player player2, int spielfeldGroesse){
        this.ersteKarte = null;
        this.zweiteKarte = null;
        this.finished = false;
        this.kartenset = kv.erstelleKartenset(kartenSetIndex);


        initSpielfeld(20,kv.kartensetAuswaehlen(this.kartenset).getKarte());
        this.audioPlayer = new AudioPlayer();
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        setCurrentPlayerProperty(currentPlayer.getName());
        highscoreVerwalter = new HighscoreVerwalter();
    }

    private void initSpielfeld(int groesse, LinkedList<Karte> cards) {
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
                    if(currentPlayer == player1){setHighscoreProperty1(Integer.toString(currentPlayer.score.comboRechner(true)));}
                    else{ setHighscoreProperty2(Integer.toString(currentPlayer.score.comboRechner(true))); }
                    this.finished = true;
                    winningPlayer = calculateWinningPlayer();
                    highscoreVerwalter.highscoreEintrag(winningPlayer.getName(),winningPlayer.score.gesammtPunkte,false);
                    setWinningPlayerProperty(winningPlayer.getName()+ ": "+ winningPlayer.score.gesammtPunkte);
                    return "finished";
                }
                this.ersteKarte = null;
                this.zweiteKarte = null;


                if(currentPlayer == player1){setHighscoreProperty1(Integer.toString(currentPlayer.score.comboRechner(true)));}
                else{ setHighscoreProperty2(Integer.toString(currentPlayer.score.comboRechner(true))); }


                return "Score: ";
            }else{
                this.ersteKarte = null;
                this.zweiteKarte = null;
                setCardReset(secondCardIndex);
                setCardReset(firstCardIndex);

                if(currentPlayer == player1){
                    setHighscoreProperty1(Integer.toString(currentPlayer.score.comboRechner(false)));
                    currentPlayer = player2;
                }
                else{
                    setHighscoreProperty2(Integer.toString(currentPlayer.score.comboRechner(false)));
                    currentPlayer = player1;
                }

                setCardReset(21);

                setCurrentPlayerProperty(currentPlayer.getName());

                return "Score: ";
            }

        }
    }

    Player calculateWinningPlayer(){
        if(player1.score.gesammtPunkte > player2.score.gesammtPunkte){

            return player1;
        }else{
            return player2;
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
