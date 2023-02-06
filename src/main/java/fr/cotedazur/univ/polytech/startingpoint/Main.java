package fr.cotedazur.univ.polytech.startingpoint;


import java.util.Arrays;

public class Main {
    static int nbEgalite=0;

    public static void main(String[] args) {
        Joueur joueur1 = new Joueur(1.62, "Wassim");
        joueur1.setCerveau(new CerveauParcelle(joueur1));
        Joueur joueur3 = new Joueur(1.5, "Emmanuelle");
        joueur3.setCerveau(new CerveauParcelle(joueur3));
        mainMille(joueur1,joueur3);
        System.out.println("nb de partie gagnees par " + joueur1.getNom()+" est "+joueur1.partieGagnees);
        System.out.println("nb de partie gagnees par " + joueur3.getNom()+" est "+joueur3.partieGagnees);
        System.out.println("nb de partie egalite est " +nbEgalite);
    }


    public static void mainMille(Joueur... joueurs) {
        for (int i = 0; i < 1000; i++) {
            for(Joueur joueur:joueurs){
                joueur.setScore(0);
                joueur.setPlateau(new Plateau());
            }
            Jeu jeu = new Jeu(Arrays.asList(joueurs));
            jeu.initialisation();
            jeu.jouer();
            if (jeu.Egalite) {
                nbEgalite++;
            }
        }
    }
}

