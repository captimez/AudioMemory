package business.data;

import business.services.PunkteSystem;

public class Player {
    String name;
    String punkte;
    public PunkteSystem score;

    public Player(String name){
        this.name = name;
        this.score = new PunkteSystem(0,0,0);
    }
    public void setName(String name ){ this.name = name; }
    public String getName(){ return this.name;}
}
