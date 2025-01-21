public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu Puissance 4 !");
        Player player1 = new Player("Player1", "R");
        Player player2 = new Player("Player2", "J");
        Puissance4 tableau = new Puissance4(6, 7);
        while (tableau.Victoire == false) {
            tableau.afficherPuissance4();
            tableau.verifvictoire(tableau, player2);
            if (tableau.Victoire == true) {
                break;
            }

            tableau.playerChoice(player1);
            tableau.mettrecouleur(player1);

            tableau.afficherPuissance4();
            tableau.verifvictoire(tableau, player1);
            if (tableau.Victoire == true) {
                break;
            }

            tableau.playerChoice(player2);
            tableau.mettrecouleur(player2);
        }
    }
}




