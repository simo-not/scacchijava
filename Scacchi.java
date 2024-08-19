public class Scacchi {
    public static void main(String[] args) {
        Pezzi pezziBianchi[][] = new Pezzi[8][8];// posizione iniziale dei pezzi disposti in 2 8
        Pezzi pezziNeri[][] = new Pezzi[8][8];
        int matrice[][] = new int[9][9];
        matrice[2][0] = 1;
        for (int x = 0; x < 9; x++) {
            System.out.printf("| %d | %d | %d | %d | %d | %d | %d | %d | %d |\n", matrice[2][0], matrice[0][1],
                    matrice[0][2], matrice[0][3], matrice[0][4], matrice[0][5], matrice[0][6], matrice[0][7],
                    matrice[0][8]);
            System.out.println("|---|---|---|---|---|---|---|---|---|");
        }
    }
}
