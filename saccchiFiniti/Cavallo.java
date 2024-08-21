public class Cavallo extends Pezzo {

    public Cavallo(String colore, int riga, int colonna) {
        super(colore, riga, colonna);
    }

    @Override
    public boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna) {
        int diffRiga = Math.abs(riga - nuovaRiga);
        int diffColonna = Math.abs(colonna - nuovaColonna);

        if ((diffRiga == 2 && diffColonna == 1) || (diffRiga == 1 && diffColonna == 2)) {
            Pezzo pezzoDestinazione = scacchiera.getPezzo(nuovaRiga, nuovaColonna);
            return pezzoDestinazione == null || !pezzoDestinazione.getColore().equals(colore);
        }

        return false;
    }
}
