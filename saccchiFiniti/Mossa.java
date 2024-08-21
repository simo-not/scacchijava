public class Mossa {

    private int rigaIniziale;
    private int colonnaIniziale;
    private int nuovaRiga;
    private int nuovaColonna;

    public Mossa(int rigaIniziale, int colonnaIniziale, int nuovaRiga, int nuovaColonna) {
        this.rigaIniziale = rigaIniziale;
        this.colonnaIniziale = colonnaIniziale;
        this.nuovaRiga = nuovaRiga;
        this.nuovaColonna = nuovaColonna;
    }

    public int getRigaIniziale() {
        return rigaIniziale;
    }

    public int getColonnaIniziale() {
        return colonnaIniziale;
    }

    public int getNuovaRiga() {
        return nuovaRiga;
    }

    public int getNuovaColonna() {
        return nuovaColonna;
    }
}
