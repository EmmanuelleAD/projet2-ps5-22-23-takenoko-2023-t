package fr.cotedazur.univ.polytech.startingpoint;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        joueur1.setCerveau(new CerveauJardinier(joueur1));
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        joueur2.setCerveau(new CerveauParcelle(joueur2));
        Joueur joueur3=new Joueur(1.65,"Emmanuelle");
        joueur3.setCerveau(new CerveauPanda(joueur3));
        Jeu jeu = new Jeu(Arrays.asList(joueur1, joueur2,joueur3));
        jeu.initialisation();
        jeu.jouer();


    }

}

