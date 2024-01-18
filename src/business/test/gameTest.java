package business.test;

import business.data.Player;
import business.services.SoloGame;

import java.util.Scanner;

public class gameTest {

    public static void main(String[] args){
        Player player = new Player("Tim");
        SoloGame soloGame = new SoloGame(3,player,20);
        Scanner scanner = new Scanner(System.in);

        while(!soloGame.finished()){
            System.out.println(soloGame.playerClick(scanner.nextInt()));

        }
    }
}
