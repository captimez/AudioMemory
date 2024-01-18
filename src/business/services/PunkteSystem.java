

package business.services;

public class PunkteSystem {
    public int multiplicator;
    public int negativMultiplikator;
    public int gesammtPunkte = 0;
    public int aktuellpunkte;
    public final int basispunkte = 5;
    public int comboPointer = 0;
    public final int negative3minus = 1;
    public final int negative2 = 2;
    public final int negative1 = 4;
    public final int normal = 4;
    public final int combo2 = 8;
    public final int combo3 = 16;
    public final int combo4 = 32;
    public final int combo5 = 64;
    public final int combo6 = 128;
    public final int combo7plus = 256;

    public PunkteSystem(int multiplicator, int negativMultiplikator, int gesammtPunkte) {
        this.multiplicator = multiplicator;
        this.negativMultiplikator = negativMultiplikator;
        this.gesammtPunkte = gesammtPunkte;
    }

    public void comboSetzer(boolean zweiPaareErfolg) {
        if (zweiPaareErfolg) {
            if (this.comboPointer <= 0) {
                this.comboPointer = 1;
            } else {
                ++this.comboPointer;
            }
        } else if (this.comboPointer > 1) {
            this.comboPointer = 0;
        } else {
            --this.comboPointer;
        }

        System.out.println("Jetzt ist die Combo auf: " + this.comboPointer);
    }

    public int comboRechner(boolean zweiPaareErfolg) {
        if (!zweiPaareErfolg) {
            this.comboSetzer(zweiPaareErfolg);
            System.out.println("Neue Punktzahl: " + this.gesammtPunkte);
            return this.gesammtPunkte;
        } else if (this.comboPointer <= -3) {
            this.aktuellpunkte = 5;
            System.out.println("Neue Punktzahl: " + (this.gesammtPunkte + this.aktuellpunkte));
            this.comboSetzer(zweiPaareErfolg);
            return this.gesammtPunkte += this.aktuellpunkte;
        } else if (this.comboPointer >= 7) {
            this.aktuellpunkte = 1280;
            System.out.println("Neue Punktzahl: " + (this.gesammtPunkte + this.aktuellpunkte));
            this.comboSetzer(zweiPaareErfolg);
            return this.gesammtPunkte += this.aktuellpunkte;
        } else {
            switch (this.comboPointer) {
                case -2:
                    this.aktuellpunkte = 10;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case -1:
                    this.aktuellpunkte = 20;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 0:
                    this.aktuellpunkte = 20;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 1:
                    this.aktuellpunkte = 20;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 2:
                    this.aktuellpunkte = 40;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 3:
                    this.aktuellpunkte = 80;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 4:
                    this.aktuellpunkte = 160;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 5:
                    this.aktuellpunkte = 320;
                    this.comboSetzer(zweiPaareErfolg);
                    break;
                case 6:
                    this.aktuellpunkte = 640;
                    this.comboSetzer(zweiPaareErfolg);
            }

            System.out.println("Neue Punktzahl: " + (this.gesammtPunkte + this.aktuellpunkte));
            return this.gesammtPunkte += this.aktuellpunkte;
        }
    }
}

