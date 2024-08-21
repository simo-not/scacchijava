public class Regina extends Pezzo {

    public Regina(String colore, int riga, int colonna) {
        super(colore, riga, colonna);
    }

    @Override
    public boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna) {
        Torre mossaTorre = new Torre(colore, riga, colonna);
        Alfiere mossaAlfiere = new Alfiere(colore, riga, colonna);

        return mossaTorre.mossaValida(scacchiera, nuovaRiga, nuovaColonna) ||
                mossaAlfiere.mossaValida(scacchiera, nuovaRiga, nuovaColonna);
    }
}
