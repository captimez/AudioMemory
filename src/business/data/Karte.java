package business.data;

public class Karte {
    private String soundName;
    private boolean istVerwendet;
    private boolean istAusgewaelt;
    private boolean istEntfehrnt;

    private int setIndex;

    public Karte(String soundName,int setIndex, boolean istVerwendet, boolean istAusgewaelt, boolean istEntfehrnt) {
        this.setIndex = setIndex;
        this.setSoundName(soundName);
        this.setIstVerwendet(istVerwendet);
        this.setIstAusgewaelt(istAusgewaelt);
        this.setIstEntfehrnt(istEntfehrnt);
    }


    public String getSoundName() {
        return this.soundName;
    }

    public int getSetIndex(){ return this.setIndex;}

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public boolean isIstVerwendet() {
        return this.istVerwendet;
    }

    public void setIstVerwendet(boolean istVerwendet) {
        this.istVerwendet = istVerwendet;
    }

    public boolean isIstAusgewaelt() {
        return this.istAusgewaelt;
    }

    public void setIstAusgewaelt(boolean istAusgewaelt) {
        this.istAusgewaelt = istAusgewaelt;
    }

    public boolean isIstEntfehrnt() {
        return this.istEntfehrnt;
    }

    public void setIstEntfehrnt(boolean istEntfehrnt) {
        this.istEntfehrnt = istEntfehrnt;
    }
}
