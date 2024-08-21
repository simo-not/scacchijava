public class Pedone extends Pezzo {

    public Pedone(String colore, int riga, int colonna) {
        super(colore, riga, colonna);
    }

    @Override
    public boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna) {
        // Implementazione semplice per la mossa del pedone
        int direzione = colore.equals("bianco") ? -1 : 1;
        int rigaDiPartenza = colore.equals("bianco") ? 6 : 1;

        if (colonna == nuovaColonna) {
            if (nuovaRiga == riga + direzione) {
                return scacchiera.getPezzo(nuovaRiga, nuovaColonna) == null;
            } else if (nuovaRiga == riga + 2 * direzione && riga == rigaDiPartenza) {
                return scacchiera.getPezzo(nuovaRiga, nuovaColonna) == null &&
                        scacchiera.getPezzo(riga + direzione, colonna) == null;
            }
        } else if (Math.abs(colonna - nuovaColonna) == 1 && nuovaRiga == riga + direzione) {
            Pezzo pezzoAvversario = scacchiera.getPezzo(nuovaRiga, nuovaColonna);
            return pezzoAvversario != null && !pezzoAvversario.getColore().equals(colore);
        }

        return false;
    }
}
