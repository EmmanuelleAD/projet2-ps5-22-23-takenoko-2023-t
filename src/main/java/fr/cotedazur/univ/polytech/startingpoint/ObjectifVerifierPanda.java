package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;

public class ObjectifVerifierPanda extends ObjectifVerifier{
    public List<Bambou> getBambouList() {
        return bambouList;
    }

    public void setBambouList(List<Bambou> bambouList) {
        this.bambouList = bambouList;
    }

    private List<Bambou> bambouList;

    public ObjectifVerifierPanda() {
        this.bambouList = new ArrayList<>();
    }

    public ObjectifVerifierPanda(List<Bambou> bambouList) {
        this.bambouList = bambouList;
    }

    public ObjectifPanda verifierValider(ObjectifPanda objectifPanda){
        return null;

    }
}
