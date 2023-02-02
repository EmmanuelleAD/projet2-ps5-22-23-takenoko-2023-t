package fr.cotedazur.univ.polytech.startingpoint;



public class Main {
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        jeu.jouer();


    }

}

