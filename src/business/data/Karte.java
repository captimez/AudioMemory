package business.data;

public class Karte {
    private String soundName;
    private boolean istVerwendet;
    private boolean istAusgewaelt;
    private boolean istEntfehrnt;

    public Karte(String soundName, boolean istVerwendet, boolean istAusgewaelt, boolean istEntfehrnt) {
        this.setSoundName(soundName);
        this.setIstVerwendet(istVerwendet);
        this.setIstAusgewaelt(istAusgewaelt);
        this.setIstEntfehrnt(istEntfehrnt);
    }

    public String getSoundName() {
        return this.soundName;
    }

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
