package fr.cotedazur.univ.polytech.startingpoint;

public class ActionPiocher extends Action{
    public Objectif getObjectif() {
        return objectif;
    }

    private final Objectif objectif;
    public ActionPiocher(Objectif objectif) {
        super(Type.TYPE_PIOCHER.getNomType(), "");
        this.objectif=objectif;
    }


    @Override
    public String getDescription() {
        return " a pioché la carte Objectif : "+objectif.getDescription();
    }

    @Override
    public boolean traiter(Joueur j, Jeu jeu) {
        j.getCartesObjectifs().add(this.getObjectif());
        int index;
        if(this.getObjectif().getType().equals(Type.TYPE_PARCELLE.getNomType())){
            index  =  jeu.getObjectifsParcelles().lastIndexOf(this.getObjectif());
            jeu.getObjectifsParcelles().remove(index);
        }
        else if(this.getObjectif().getType().equals(Type.TYPE_JARDINIER.getNomType())){
            index  =  jeu.getObjectifsJardinier().lastIndexOf(this.getObjectif());
            jeu.getObjectifsJardinier().remove(index);
        }
        else if(this.getObjectif().getType().equals(Type.TYPE_PANDA.getNomType())){
            index  =  jeu.getObjectifsPanda().lastIndexOf(this.getObjectif());
            jeu.getObjectifsPanda().remove(index);
        }
        Jeu.logger.info(j.getNom() + this.getDescription());
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ActionPiocher piocher)){
            return false;
        }
        return piocher.objectif.equals(this.objectif);
    }

    @Override
    public int hashCode() {
        return objectif.hashCode();
    }
}
