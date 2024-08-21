public class Alfiere extends Pezzo {

    public Alfiere(String colore, int riga, int colonna) {
        super(colore, riga, colonna);
    }

    @Override
    public boolean mossaValida(Scacchiera scacchiera, int nuovaRiga, int nuovaColonna) {
        if (Math.abs(riga - nuovaRiga) != Math.abs(colonna - nuovaColonna)) {
            return false;
        }

        int passoRiga = (nuovaRiga > riga) ? 1 : -1;
        int passoColonna = (nuovaColonna > colonna) ? 1 : -1;

        int rigaCorrente = riga + passoRiga;
        int colonnaCorrente = colonna + passoColonna;

        while (rigaCorrente != nuovaRiga && colonnaCorrente != nuovaColonna) {
            if (scacchiera.getPezzo(rigaCorrente, colonnaCorrente) != null) {
                return false;
            }
            rigaCorrente += passoRiga;
            colonnaCorrente += passoColonna;
        }

        Pezzo pezzoDestinazione = scacchiera.getPezzo(nuovaRiga, nuovaColonna);
        return pezzoDestinazione == null || !pezzoDestinazione.getColore().equals(colore);
    }
}
