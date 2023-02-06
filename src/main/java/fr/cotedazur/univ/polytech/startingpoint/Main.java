package fr.cotedazur.univ.polytech.startingpoint;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.util.Arrays;

public class Main {
    @Parameter(names={"--2thousands"})
    boolean typeExec=false;

    static int nbEgalite=0;
    public static void main(String ...args){

        Main mainParametre=new Main();
        JCommander.newBuilder().addObject(mainParametre).build().parse(args);
        mainParametre.run();
    }

    public  void main() {
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
        for (Joueur joueur:joueurs
             ) {
            System.out.println("nb de partie gagnées par " + joueur.getNom()+" est "+joueur.partieGagnees);
            joueur.partieGagnees=0;


        }
        System.out.println("nb de partie égalité est " +nbEgalite);


    }
    public  void run() {
        if(typeExec)
        {
            Joueur joueur1 = new Joueur(1.62, "Wassim");
            joueur1.setCerveau(new CerveauParcelle(joueur1));
            Joueur joueur3 = new Joueur(1.5, "Emmanuelle");
            joueur3.setCerveau(new CerveauParcelle(joueur3));
            mainMille(joueur1,joueur3);
            joueur3.setCerveau(new CerveauPanda(joueur3));
            mainMille(joueur1,joueur3);


        }
        else main();



    }


}

