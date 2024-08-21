public class Re extends Pezzo {

    public Re(String colore, int riga, int colonna) {
        super(colore, riga, colonna);
    }

    @Override
    public boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna) {
        int diffRiga = Math.abs(riga - nuovaRiga);
        int diffColonna = Math.abs(colonna - nuovaColonna);

        if (diffRiga <= 1 && diffColonna <= 1) {
            Pezzo pezzoDestinazione = scacchiera.getPezzo(nuovaRiga, nuovaColonna);
            return pezzoDestinazione == null || !pezzoDestinazione.getColore().equals(colore);
        }

        return false;
    }
}
