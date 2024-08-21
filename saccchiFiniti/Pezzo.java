public abstract class Pezzo {
    protected String colore;
    protected int riga;
    protected int colonna;

    public Pezzo(String colore, int riga, int colonna) {
        this.colore = colore;
        this.riga = riga;
        this.colonna = colonna;
    }

    public String getColore() {
        return colore;
    }

    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setPosizione(int riga, int colonna) {
        this.riga = riga;
        this.colonna = colonna;
    }

    public abstract boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna);
}
