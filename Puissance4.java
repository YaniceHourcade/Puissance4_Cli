import java.util.Scanner;

public class Puissance4 {
    private int Lignes;
    private int Colonnes;
    private String[][] Grille;
    private int ValeurUtilisateur;
    public boolean Victoire;

    public Puissance4(int Lignes, int Colonnes) {
        this.Lignes = Lignes;
        this.Colonnes = Colonnes;
        this.Grille = new String[Lignes][Colonnes];
        this.Victoire = false;
    }

    // Afficher les Puissance4
    public void afficherPuissance4() {
        for (int i = 0; i < Lignes; i++) {
            for (int j = 0; j < Colonnes; j++) {
                if (Grille[i][j] == null) {
                    System.out.print("- ");
                }  else {
                System.out.print(Grille[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("1-2-3-4-5-6-7");
    }

    // Savoir ou le joueur veut placer son pion
    public void playerChoice(Player player) {
        Scanner scanner = new Scanner(System.in);   
        do {
            System.out.print(player.getName() + " " + player.getCouleur() + ", choisissez une colonne : ");
            ValeurUtilisateur = scanner.nextInt();
            if (ValeurUtilisateur > 7 || ValeurUtilisateur < 1) {
                System.out.println("Choisissez une valeur entre 1-2-3-4-5-6-7");
            } else if (Grille[0][ValeurUtilisateur - 1] != null) {
                System.out.println("Colonnes deja remplies, choisissez-en une autre");
            }
        } while (ValeurUtilisateur > 7 || ValeurUtilisateur < 1 || Grille[0][ValeurUtilisateur - 1] != null);
    }

    // Placer la couleur du joueur
    public void mettrecouleur(Player player) {
        int ligneVide = -1;

        for (int i = Lignes - 1; i >= 0; i--) {
            if (Grille[i][ValeurUtilisateur - 1] == null) {
                ligneVide = i;
                break;
            }
        }
        if (ligneVide != -1) {
            Grille[ligneVide][ValeurUtilisateur - 1] = player.getCouleur();
        }
    }

    // Vérifie victoire
    public void verifvictoire(Puissance4 tableau, Player player) {
        // Vérifie horizontale
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (Grille[i][j] == player.getCouleur() && Grille[i][j + 1] == player.getCouleur() &&
                    Grille[i][j + 2] == player.getCouleur() && Grille[i][j + 3] == player.getCouleur()) {
                    Victoire = true;
                    System.out.println("Victoire de " + player.getName() + " ,Bravo !!!");
                }
            }
        }
        // Vérifie verticale
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (Grille[i][j] == player.getCouleur() && Grille[i + 1][j] == player.getCouleur() &&
                    Grille[i + 2][j] == player.getCouleur() && Grille[i + 3][j] == player.getCouleur()) {
                    Victoire = true;
                    System.out.println("Victoire de " + player.getName() + " ,Bravo !!!");
                }
            }
        }
        // Vérifie diagonale
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (Grille[i][j] == player.getCouleur() && Grille[i + 1][j + 1] == player.getCouleur() &&
                    Grille[i + 2][j + 2] == player.getCouleur() && Grille[i + 3][j + 3] == player.getCouleur()) {
                    Victoire = true;
                    System.out.println("Victoire de " + player.getName() + " ,Bravo !!!");
                }
                if (Grille[i][j + 3] == player.getCouleur() && Grille[i + 1][j + 2] == player.getCouleur() &&
                    Grille[i + 2][j + 1] == player.getCouleur() && Grille[i + 3][j] == player.getCouleur()) {
                    Victoire = true;
                    System.out.println("Victoire de " + player.getName() + " ,Bravo !!!");
                }
            }
        }
        // Vérifie tableau plein
        boolean isFull = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (Grille[i][j] == null) {
                    isFull = false;
                }
            }
        }
    if (isFull == true) {
        Victoire = true;
        System.out.println("Le puissance4 est remplie, c'est une egalite.");
        }
    }
}
