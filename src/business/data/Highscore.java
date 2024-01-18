package business.data;

public class Highscore implements Comparable<Highscore> {
    private String spielerName;
    private int punkte;

    public Highscore(String spielerName, int punkte) {
        this.setSpielerName(spielerName);
        this.setPunkte(punkte);
    }

    public int getPunkte() {
        return this.punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public String getSpielerName() {
        return this.spielerName;
    }

    public void setSpielerName(String spielerName) {
        this.spielerName = spielerName;
    }

    public int compareTo(Highscore other) {
        return Integer.compare(other.punkte, this.punkte);
    }
}
