package fr.cotedazur.univ.polytech.startingpoint;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Main {
    @Parameter(names={"--2thousands"})
    boolean est2000=false;
    @Parameter(names={"--demo"})
    boolean estDemo=true;
    @Parameter(names={"--csv"})
    boolean estCsv=false;
    private static int nbEgalite=0;
    private static double getPourcentage(double nbre){
        return nbre/10;
    }
    public static void main(String ...args){

        Main mainParametre=new Main();
        JCommander.newBuilder().addObject(mainParametre).build().parse(args);
        mainParametre.run();
    }

    public  void main(boolean csv ) {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        joueur1.setCerveau(new CerveauJardinier(joueur1));
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        joueur2.setCerveau(new CerveauParcelle(joueur2));
        Joueur joueur3=new Joueur(1.65,"Emmanuelle");
        joueur3.setCerveau(new CerveauPanda(joueur3));

        Joueur joueur4=new Joueur(1.65,"Joueur Saboteur");
        joueur4.setCerveau(new CerveauLivraison(joueur4));

        List<Joueur>joueurs=Arrays.asList(joueur1, joueur2,joueur3,joueur4);
        Jeu jeu = new Jeu(joueurs);

        jeu.initialisation();
        jeu.jouer();
        if(csv){
            String message="";
            for (Joueur joueur:joueurs
                 ) {
               message+= "Le nombre de parties gagnées par " + joueur.getNom()+" est "+joueur.getPartieGagnees();
                message+="Le nombre de parties perdues par " + joueur.getNom()+" est "+(1-joueur.getPartieGagnees());
                message+="Le nombre de parties nulles pour " + joueur.getNom()+" est "+ joueur.getPartieNulles();
                message+="Le score de " + joueur.getNom()+" est "+joueur.getScoreMoyen();

            }
            try {
                Writing.appendCsv(message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }


    public static void mainMille(Joueur... joueurs) {
        for (int i = 0; i < 1000; i++) {
            for(Joueur joueur:joueurs){
                joueur.setScore(0);
                joueur.setPlateau(new Plateau());
            }
            Jeu jeu = new Jeu(Arrays.asList(joueurs));
            jeu.initialisation();
            jeu.logger.setLevel(Level.OFF);

            jeu.jouer();
            if (jeu.getEgalite()) {
                nbEgalite++;
            }
        }
        for (Joueur joueur:joueurs
             ) {
            System.out.println("Le nombre de parties gagnées par " + joueur.getNom()+" est "+joueur.getPartieGagnees()+" soit "+getPourcentage(joueur.getPartieGagnees())+"% ");
            System.out.println("Le nombre de parties perdues par " + joueur.getNom()+" est "+(1000-joueur.getPartieGagnees()- joueur.getPartieNulles())+" soit "+getPourcentage(1000-joueur.getPartieGagnees()- joueur.getPartieNulles())+"% ");
            System.out.println("Le nombre de parties nulles pour " + joueur.getNom()+" est "+ joueur.getPartieNulles()+" soit "+getPourcentage(joueur.getPartieNulles())+"% ");
            System.out.println("Le score moyen  de " + joueur.getNom()+" est "+joueur.getScoreMoyen()/1000);


            joueur.setPartieGagnees(0);
            joueur.setPartieNulles(0);
            joueur.setScoreMoyen(0);


        }
        //System.out.println("Le nombre  de parties égalité est " +nbEgalite);


    }
    public  void run() {
        if(est2000)
        {
            Joueur joueur1 = new Joueur(1.62, "Wassim");
            joueur1.setCerveau(new CerveauParcelle(joueur1));
            Joueur joueur3 = new Joueur(1.5, "Emmanuelle");
            joueur3.setCerveau(new CerveauParcelle(joueur3));
            mainMille(joueur1,joueur3);
            joueur3.setCerveau(new CerveauPanda(joueur3));
            mainMille(joueur1,joueur3);


        }
        else main(estCsv);
    }

}

