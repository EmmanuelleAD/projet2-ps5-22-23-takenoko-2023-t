package fr.cotedazur.univ.polytech.startingpoint;

public class ActionPiocher extends Action{
    public Objectif getObjectif() {
        return objectif;
    }

    private Objectif objectif;
    public ActionPiocher(Objectif objectif) {
        super(Type.TypePiocher.getNomType(), "");
        this.objectif=objectif;
    }


    @Override
    public String getDescription() {
        return " a pioché la carte Objectif : "+objectif.getDescription();
    }

    @Override
    public void traiter(Joueur j, Jeu jeu) {
        j.getCartesObjectifs().add(this.getObjectif());
        int index;
        if(this.getObjectif().getType().equals(Type.TypeParcelle.getNomType())){
            index  =  jeu.getObjectifsParcelles().lastIndexOf(this.getObjectif());
            jeu.getObjectifsParcelles().remove(index);
        }
        else if(this.getObjectif().getType().equals(Type.TypeJardinier.getNomType())){
            index  =  jeu.getObjectifsJardinier().lastIndexOf(this.getObjectif());
            jeu.getObjectifsJardinier().remove(index);
        }
        System.out.println(j.getNom() + this.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ActionPiocher)){
            return false;
        }
        ActionPiocher piocher=(ActionPiocher) o;
        return piocher.objectif.equals(this.objectif);
    }

    @Override
    public int hashCode() {
        return objectif.hashCode();
    }
}
