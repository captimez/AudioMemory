package business.services;


import java.util.LinkedList;

import business.data.Karte;
import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

public class AudioPlayer {


    private SimpleMinim minim = new SimpleMinim();
    private SimpleAudioPlayer audioPlayer;

    public void playKartenSound(Karte karte) {
        //	audioPlayer.play();
        audioPlayer = minim.loadMP3File("Eibo test/Audio/Sounds/Kartenpaket/3/"+karte.getSoundName());
        audioPlayer.play();

    }


    public void playKartenSelect() {
        audioPlayer = minim.loadMP3File("Audio\\Sounds\\Interactions\\KartenSelectTest.mp3");
        audioPlayer.play();
    }

    public void playKartenEvent() {

    }

    public void playKartenCombo(int comboNummer) {

    }

}

