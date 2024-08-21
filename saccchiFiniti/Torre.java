public class Torre extends Pezzo {

    public Torre(String colore, int riga, int colonna) {
        super(colore, riga, colonna);
    }

    @Override
    public boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna) {
        if (riga != nuovaRiga && colonna != nuovaColonna) {
            return false;
        }

        int rigaMin = Math.min(riga, nuovaRiga);
        int rigaMax = Math.max(riga, nuovaRiga);
        int colonnaMin = Math.min(colonna, nuovaColonna);
        int colonnaMax = Math.max(colonna, nuovaColonna);

        for (int i = rigaMin + 1; i < rigaMax; i++) {
            if (scacchiera.getPezzo(i, colonna) != null) {
                return false;
            }
        }

        for (int j = colonnaMin + 1; j < colonnaMax; j++) {
            if (scacchiera.getPezzo(riga, j) != null) {
                return false;
            }
        }

        Pezzo pezzoDestinazione = scacchiera.getPezzo(nuovaRiga, nuovaColonna);
        return pezzoDestinazione == null || !pezzoDestinazione.getColore().equals(colore);
    }
}
