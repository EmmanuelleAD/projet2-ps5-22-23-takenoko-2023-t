package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObjectifPanda extends Objectif{
    static List<ObjectifPanda>objectifPandas=new ArrayList<>(Arrays.asList(
            new ObjectifPanda("MANGB",2,false," une section mangée ",Arrays.asList(new Bambou(1))),
            new ObjectifPanda("P2J",4,false,"2 sections mangées ",Arrays.asList(new Bambou(1),new Bambou(1))),
            new ObjectifPanda("P3V",3,false,"3 sections mangées ",Arrays.asList(new Bambou(1),new Bambou(1),new Bambou(1))),
            new ObjectifPanda("P5J",4,false,"5 sections mangées ",Arrays.asList(new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1))),
            new ObjectifPanda("P8V",3,false,"5 sections mangées ",Arrays.asList(new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1),new Bambou(1)))
    ));



    public List<Bambou> getBambous() {
        return bambous;
    }

    private final List<Bambou>bambous;
    public ObjectifPanda(String nom, int points, boolean statut, String description,List<Bambou>bambous) {
        super(nom, points, statut, description);
        this.bambous=new ArrayList<>(bambous);
    }

    @Override
    public String getType() {
        return Type.TYPE_PANDA.getNomType();
    }

    @Override
    public boolean estValide(List<Parcelle> parcelles,Joueur joueur) {
        List<Bambou>joueurBambous=joueur.getPlateau().getBambous();
        List<Bambou >temp=new ArrayList<>(joueurBambous);
        for (Bambou bambou:this.getBambous()
             ) {
            if(temp.contains(bambou)) temp.remove(bambou);
            else return false;


        }
        return true;
    }

    @Override
    public ObjectifVerifierPanda verifierValider(List<Parcelle> parcelles,Joueur joueur) {
        if(this.estValide(parcelles,joueur)){
            ObjectifVerifierPanda objectifVerifierPanda=new ObjectifVerifierPanda();
            objectifVerifierPanda.setIsManquant(true);
            return objectifVerifierPanda;
        }
        List<Bambou>joueurBambous=joueur.getPlateau().getBambous();
        List <Bambou>temp =new ArrayList<>(joueurBambous);
        List<Bambou>manquants=new ArrayList<>();
        for (Bambou bambou:this.getBambous()
        ) {
            if(!temp.contains(bambou)) manquants.add(bambou);
            else temp.remove(bambou);


        }
        return new ObjectifVerifierPanda(manquants);


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ObjectifPanda that = (ObjectifPanda) o;
        return Objects.equals(bambous, that.bambous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bambous);
    }
}
