package fr.cotedazur.univ.polytech.startingpoint;public class Score {
    private String joueur;
    private int jeuGagne = 0;
    private int jeuperdu = 0;
    private int nul = 0;
    private int totalScore = 0;
    private int nbjeu = 0;



    public Score(String joueur) {
        this.joueur = joueur;
    }
    public void Scorelive(boolean joueurgagne, boolean egalite, int score) {
        jeuGagne += !egalite && joueurgagne ? 1 : 0;
        jeuperdu += !egalite && !joueurgagne ? 1 : 0;
        nul += egalite ? 1 : 0;
        totalScore += score;
        nbjeu++;
}
}
