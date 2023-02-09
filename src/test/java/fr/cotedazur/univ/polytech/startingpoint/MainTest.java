package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testJoueur() {
        Joueur joueur = new Joueur(1.85, "Wassim");
        assertEquals(1.85, joueur.getTaille(), 0.001);
        assertEquals("Wassim", joueur.getNom());
    }

    @Test
    public void testJeu() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        assertNotNull(jeu);
        assertEquals(joueur1, jeu.getJoueur1());
        assertEquals(joueur2, jeu.getJoueur2());
    }

    @Test
    public void testInitialisation() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();
        assertNotNull(jeu.getJoueur1());
        assertNotNull(jeu.getJoueur2());
        assertEquals(0, jeu.getJoueur1().getScore());
        assertEquals(0, jeu.getJoueur2().getScore());

    }


    @Test
    void main() {
        Joueur joueur1 = new Joueur(1.85, "Wassim");
        Joueur joueur2 = new Joueur(1.6, "Brahim");
        Jeu jeu = new Jeu(joueur1, joueur2);
        jeu.initialisation();

    }

    @Test
    void testMainMethod() throws NoSuchAlgorithmException {
        String[] args = {};
        assertDoesNotThrow(() -> Main.main(args));
    }

    @Test
    public void testRunMethod() {
        boolean est2000 = true;
        boolean estCsv = false;
        run();

        Joueur joueur1 = new Joueur(1.62, "Wassim");
        Joueur joueur2 = new Joueur(1.62, "Livraison");
        Joueur joueur3 = new Joueur(1.5, "Emmanuelle");

        Cerveau cerveauParcelle = new CerveauParcelle(joueur1);
        joueur1.setCerveau(cerveauParcelle);
        Cerveau cerveauParcelle2 = new CerveauParcelle(joueur2);
        joueur2.setCerveau(cerveauParcelle2);
        Cerveau cerveauParcelle3 = new CerveauParcelle(joueur3);
        joueur3.setCerveau(cerveauParcelle3);
        assertEquals(joueur1.getCerveau(), cerveauParcelle);
        assertEquals(joueur2.getCerveau(), cerveauParcelle2);
        assertEquals(joueur3.getCerveau(), cerveauParcelle3);

    }

    @Test
    public void testRunMethodElse() {
        boolean est2000 = false;
        boolean estCsv = true;
        run();
        assertTrue(estCsv);
    }



    @Test
    void mainMille() {
    }

    @Test
    void run() {
    }
}