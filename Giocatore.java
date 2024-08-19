public class Giocatore {
    private String nome;
    private int colore;
    private Pezzi pezzi[] = new Pezzi[16];

    public Giocatore(String nome, int colore) {
        this.nome = nome;
        this.colore = colore;
        int i = 0;
        for (i = 0; i < 8; i++) {
            pezzi[i] = new Pedone();
        }
        pezzi[8] = new Torre();
        pezzi[15] = new Torre();
        pezzi[10] = new Alfiere();
        pezzi[13] = new Alfiere();
        pezzi[9] = new Cavallo();
        pezzi[14] = new Cavallo();
        pezzi[12] = new Re();
        pezzi[11] = new Donna();

    }
}
