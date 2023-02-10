package fr.cotedazur.univ.polytech.startingpoint;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Main {
    @Parameter(names={"--2thousands"})
    boolean est2000=false;
    @Parameter(names={"--demo"})
    boolean estDemo=false;
    @Parameter(names={"--csv"})
    boolean estCsv=false;
    private static int nbEgalite=0;
    private static double getPourcentage(double total,double nombre){
        return (nombre/total)*100;
    }
    public static void main(String ...args) throws NoSuchAlgorithmException {

        Main mainParametre=new Main();
        JCommander.newBuilder().addObject(mainParametre).build().parse(args);
        mainParametre.run();
    }

    public  void main(boolean csv ) throws NoSuchAlgorithmException {
        Joueur joueur1 = new Joueur(1.85, "JoueurPanda");
        joueur1.setCerveau(new CerveauPanda(joueur1));
        Joueur joueur2 = new Joueur(1.6, "JoueurSaboteur");
        joueur2.setCerveau(new CerveauLivraison(joueur2));
        Joueur joueur3=new Joueur(1.65,"JoueurParcelle");
        joueur3.setCerveau(new CerveauJardinier(joueur3));

        List<Joueur>joueurs=Arrays.asList(joueur1, joueur2,joueur3);
        if(csv) {
            List<String> listMsg=new ArrayList<>();
            mainN(2000,joueur1,joueur2,joueur3);
            listMsg.add("Player Wins Losses Draws Win(%) Loss(%) Draw(%)");
            for (Joueur joueur : joueurs) {
                listMsg.add( joueur.getNom() +' '+joueur.getPartieGagnees()+' '
                        +(2000 - (joueur.getPartieGagnees()+joueur.getPartieNulles()))+' '+ joueur.getPartieNulles()+' '+
                        +getPourcentage(2000,joueur.getPartieGagnees()) +' '
                        +getPourcentage(2000,2000 - (joueur.getPartieGagnees()+joueur.getPartieNulles()))+' '
                        +getPourcentage(2000,joueur.getPartieNulles()));

            }
            try {
                for (String message:listMsg
                ) {
                    Writing.appendCsv(message);

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        else mainN(1, joueur1,joueur2,joueur3);
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
            System.out.println("Le nombre de parties gagnées par " + joueur.getNom()+" est "+joueur.getPartieGagnees()+" soit "+getPourcentage(1000,joueur.getPartieGagnees())+"% ");
            System.out.println("Le nombre de parties perdues par " + joueur.getNom()+" est "+(1000-joueur.getPartieGagnees()- joueur.getPartieNulles())+" soit "+getPourcentage(1000,1000- (double) joueur.getPartieGagnees()- (double) joueur.getPartieNulles())+"% ");
            System.out.println("Le nombre de parties nulles pour " + joueur.getNom()+" est "+ joueur.getPartieNulles()+" soit "+getPourcentage(1000,joueur.getPartieNulles())+"% ");
            System.out.println("Le score moyen  de " + joueur.getNom()+" est "+joueur.getScoreMoyen()/1000);


            joueur.setPartieGagnees(0);
            joueur.setPartieNulles(0);
            joueur.setScoreMoyen(0);


        }

    }
    public static void mainN(int n, Joueur... joueurs){
        for (int i = 0; i < n; i++) {

            for (Joueur joueur : joueurs) {
                joueur.setScore(0);
                joueur.setPlateau(new Plateau());
            }
            Jeu jeu = new Jeu(Arrays.asList(joueurs));
            if (n>1){
                jeu.logger.setLevel(Level.OFF);
            }
            jeu.initialisation();
            jeu.jouer();
            if (jeu.getEgalite()) {
                nbEgalite++;
            }
            if (n>1){
                jeu.logger.setLevel(Level.OFF);
            }
        }
        if(n>1){
            for (Joueur joueur : joueurs) {
                System.out.println("Le nombre de parties gagnées par " + joueur.getNom() + " est " + joueur.getPartieGagnees() + " soit " + getPourcentage(n, joueur.getPartieGagnees()) + "% ");
                System.out.println("Le nombre de parties perdues par " + joueur.getNom() + " est " + (n - joueur.getPartieGagnees() - joueur.getPartieNulles()) + " soit " + getPourcentage(n, n - (double) joueur.getPartieGagnees() - (double) joueur.getPartieNulles()) + "% ");
                System.out.println("Le nombre de parties nulles pour " + joueur.getNom() + " est " + joueur.getPartieNulles() + " soit " + getPourcentage(n, joueur.getPartieNulles()) + "% ");
                System.out.println("Le score moyen  de " + joueur.getNom() + " est " + joueur.getScoreMoyen() / n);
            }
        }
    }



    public  void run() throws NoSuchAlgorithmException {
        if(est2000)
        {
            Joueur joueur1 = new Joueur(1.62, "Wassim");
            joueur1.setCerveau(new CerveauParcelle(joueur1));
            Joueur joueur2 = new Joueur(1.62, "Livraison");
            joueur2.setCerveau(new CerveauParcelle(joueur2));
            Joueur joueur3 = new Joueur(1.5, "Emmanuelle");
            joueur3.setCerveau(new CerveauParcelle(joueur3));
            mainMille(joueur1,joueur2,joueur3);
            joueur3.setCerveau(new CerveauPanda(joueur3));
            mainMille(joueur1,joueur2,joueur3);


        }
        else main(estCsv);
    }

}
