public class Scacchiera {
    private Pezzo[][] scacchiera;

    public Scacchiera() {
        scacchiera = new Pezzo[8][8];
        inizializzaScacchiera();
    }

    public Pezzo getPezzo(int riga, int colonna) {
        return scacchiera[riga][colonna];
    }

    public void posizionaPezzo(Pezzo pezzo, int riga, int colonna) {
        scacchiera[riga][colonna] = pezzo;
    }

    public void muoviPezzo(int rigaIniziale, int colonnaIniziale, int nuovaRiga, int nuovaColonna) {
        Pezzo pezzo = scacchiera[rigaIniziale][colonnaIniziale];
        scacchiera[nuovaRiga][nuovaColonna] = pezzo;
        scacchiera[rigaIniziale][colonnaIniziale] = null;
        pezzo.setPosizione(nuovaRiga, nuovaColonna);
    }

    private void inizializzaScacchiera() {
        // Posizionamento dei pezzi bianchi
        for (int i = 0; i < 8; i++) {
            scacchiera[6][i] = new Pedone("bianco", 6, i);
        }
        scacchiera[7][0] = new Torre("bianco", 7, 0);
        scacchiera[7][7] = new Torre("bianco", 7, 7);
        scacchiera[7][1] = new Cavallo("bianco", 7, 1);
        scacchiera[7][6] = new Cavallo("bianco", 7, 6);
        scacchiera[7][2] = new Alfiere("bianco", 7, 2);
        scacchiera[7][5] = new Alfiere("bianco", 7, 5);
        scacchiera[7][3] = new Regina("bianco", 7, 3);
        scacchiera[7][4] = new Re("bianco", 7, 4);

        // Posizionamento dei pezzi neri
        for (int i = 0; i < 8; i++) {
            scacchiera[1][i] = new Pedone("nero", 1, i);
        }
        scacchiera[0][0] = new Torre("nero", 0, 0);
        scacchiera[0][7] = new Torre("nero", 0, 7);
        scacchiera[0][1] = new Cavallo("nero", 0, 1);
        scacchiera[0][6] = new Cavallo("nero", 0, 6);
        scacchiera[0][2] = new Alfiere("nero", 0, 2);
        scacchiera[0][5] = new Alfiere("nero", 0, 5);
        scacchiera[0][3] = new Regina("nero", 0, 3);
        scacchiera[0][4] = new Re("nero", 0, 4);
    }

    public boolean èScaccoMatto(String colore) {
        for (int riga = 0; riga < 8; riga++) {
            for (int colonna = 0; colonna < 8; colonna++) {
                Pezzo pezzo = scacchiera[riga][colonna];
                if (pezzo != null && pezzo.getColore().equals(colore)) {
                    for (int nuovaRiga = 0; nuovaRiga < 8; nuovaRiga++) {
                        for (int nuovaColonna = 0; nuovaColonna < 8; nuovaColonna++) {
                            if (pezzo.mossaValida(this, nuovaRiga, nuovaColonna)) {
                                Scacchiera scacchieraCopia = copiaScacchiera();
                                scacchieraCopia.muoviPezzo(riga, colonna, nuovaRiga, nuovaColonna);
                                if (!scacchieraCopia.èScacco(colore)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean èScacco(String colore) {
        int rigaRe = -1, colonnaRe = -1;
        for (int riga = 0; riga < 8; riga++) {
            for (int colonna = 0; colonna < 8; colonna++) {
                Pezzo pezzo = scacchiera[riga][colonna];
                if (pezzo != null && pezzo.getColore().equals(colore) && pezzo instanceof Re) {
                    rigaRe = riga;
                    colonnaRe = colonna;
                    break;
                }
            }
        }

        for (int riga = 0; riga < 8; riga++) {
            for (int colonna = 0; colonna < 8; colonna++) {
                Pezzo pezzo = scacchiera[riga][colonna];
                if (pezzo != null && !pezzo.getColore().equals(colore)) {
                    if (pezzo.mossaValida(this, rigaRe, colonnaRe)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private Scacchiera copiaScacchiera() {
        Scacchiera nuovaScacchiera = new Scacchiera();
        for (int riga = 0; riga < 8; riga++) {
            for (int colonna = 0; colonna < 8; colonna++) {
                Pezzo pezzo = scacchiera[riga][colonna];
                if (pezzo != null) {
                    nuovaScacchiera.posizionaPezzo(creaCopiaPezzo(pezzo), riga, colonna);
                }
            }
        }
        return nuovaScacchiera;
    }

    private Pezzo creaCopiaPezzo(Pezzo pezzo) {
        if (pezzo instanceof Pedone) {
            return new Pedone(pezzo.getColore(), pezzo.getRiga(), pezzo.getColonna());
        } else if (pezzo instanceof Torre) {
            return new Torre(pezzo.getColore(), pezzo.getRiga(), pezzo.getColonna());
        } else if (pezzo instanceof Cavallo) {
            return new Cavallo(pezzo.getColore(), pezzo.getRiga(), pezzo.getColonna());
        } else if (pezzo instanceof Alfiere) {
            return new Alfiere(pezzo.getColore(), pezzo.getRiga(), pezzo.getColonna());
        } else if (pezzo instanceof Regina) {
            return new Regina(pezzo.getColore(), pezzo.getRiga(), pezzo.getColonna());
        } else if (pezzo instanceof Re) {
            return new Re(pezzo.getColore(), pezzo.getRiga(), pezzo.getColonna());
        }
        throw new IllegalArgumentException("Tipo di pezzo sconosciuto");
    }
}
