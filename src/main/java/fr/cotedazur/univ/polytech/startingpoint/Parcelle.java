package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Math.sqrt;

public class Parcelle {
    public Position positionCentre;
    public Optional<Bambou> bambou;
    private boolean irrigue;
    public  final static Parcelle etang=new Parcelle(new Position(0,0));

    public Optional<Bambou> getBambou() {
        return bambou;
    }

    public void setBambou(Bambou bambou) {
        this.bambou = Optional.ofNullable(bambou);
    }

    public boolean estIrrigue() {
        return irrigue;
    }

   public int getTaille(){

        return bambou.orElse(new Bambou(0)).getTaille();
    }
    public void ajouterUneSection(){

        bambou.orElse(new Bambou()).ajouterUneSection();
    }
    public void enleverUneSection(){
        bambou.orElse(new Bambou()).enleverUneSection();
    }




    public Parcelle(Position positionCentre){
        this.positionCentre=positionCentre;
        irrigue=true;
        this.bambou=(irrigue&&!positionCentre.equals(new Position(0,0)))?Optional.ofNullable(new Bambou()):Optional.empty();
    }


    public Position getPosition(){
        return positionCentre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcelle parcelle = (Parcelle) o;
        return positionCentre.equals(parcelle.positionCentre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionCentre);
    }

    public boolean isAdjacent(Parcelle parcelle) {
        Position[] tabPos = parcelle.getPosition().positionsAdjacentes();
        for (int i=0;i<6;i++){
            if (this.getPosition().equals(tabPos[i])){
                return true;
            }
        }return false;


    }

    public Parcelle[] parcelleAdjacentes() {
        Position[] tabPos = this.getPosition().positionsAdjacentes();
        Parcelle tabParcelle[] = new Parcelle[6];
        for (int i = 0; i < 6; i++) {
            tabParcelle[i] = new Parcelle(tabPos[i]);
        }
        return tabParcelle;
    }



    public static List<Position> positionsPossibleEnTenantCompteDeCellesPlacees(List<Parcelle> parcellePlacees,List<Position> positionPossible) {
        Parcelle dernier=parcellePlacees.get(parcellePlacees.size()-1);
        positionPossible.addAll(List.of(dernier.getPosition().positionsAdjacentes()));
        List<Position> res=new ArrayList<>(positionPossible);
        for (int i = 0; i < positionPossible.size(); i++) {
            for (int j =0; j < parcellePlacees.size(); j++) {
                if (parcellePlacees.get(j).getPosition().equals(positionPossible.get(i))){
                    res.remove(positionPossible.get(i));
                }
            }
        }return res;
    }
    public static boolean isValide(Position position, List<Parcelle> parcellesPlacees){
        int count=0;
        Parcelle parcellePosition=new Parcelle(position);
        for (Parcelle parcelle : parcellesPlacees){
            if (parcellePosition.isAdjacent(parcelle)){
                count++;
            }
        }
        if ((count >= 2) || (parcellePosition.isAdjacent(new Parcelle(new Position(0,0))))){
            return true;
        } else{
            return false;
        }
    }

    public static List<Position> positionsPossible(List<Parcelle> parcellesPlacees, List<Position> positionPossible){
        List<Position> listPosition=Parcelle.positionsPossibleEnTenantCompteDeCellesPlacees(parcellesPlacees,positionPossible);
        List<Position> toRemove=new ArrayList<>();
        for (Position position : listPosition){
            if (!isValide(position, parcellesPlacees)){
                toRemove.add(position);
            }
        }
        listPosition.removeAll(toRemove);
        return listPosition;
    }

    public static List<Parcelle> ParcellesTailleN(List<Parcelle> list,int taille){
        List<Parcelle> parcelleList=new ArrayList<>();
        for (Parcelle parcelle : list){
            if (parcelle.getTaille()<=taille){
                parcelleList.add(parcelle);
            }
        }
        return parcelleList;
    }

    public static Parcelle parcelleTailleMax(List<Parcelle> list){
        if (list.isEmpty()){
            return new Parcelle(new Position(0,0));
        }
        Parcelle parcelle0=list.get(0);
        for (Parcelle parcelle:list){
            if (parcelle.getTaille()>=parcelle0.getTaille()){
                parcelle0=parcelle;
            }
        }
        return parcelle0;
    }
    public static Parcelle dernier(List<Parcelle>list){
        for (int i = list.size()-1; i >=0 ; i--) {
            if(!list.get(i).equals(etang)) return list.get(i);

        }
        return etang;

    }






}


