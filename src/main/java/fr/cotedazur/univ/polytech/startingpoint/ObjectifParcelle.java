package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectifParcelle extends Objectif {

    static List<ObjectifParcelle> objectifParcelles = new ArrayList<>(Arrays.asList(
            new ObjectifParcelle("PARADJ",2,false,"Adjacence parcelle"),
            new ObjectifParcelle("POUSSB",2,false,"Pousse de bambou"),
            new ObjectifParcelle("ALI3",2,false,"3 Parcelles alignées"),
            new ObjectifParcelle("PARC",3,false,"Parcelles en C"),
            new ObjectifParcelle("GRP3",4,false,"3 Parcelles groupées"),
            new ObjectifParcelle("GRP4",4,false,"4 Parcelles groupées")

            ));

    public ObjectifParcelle(String nom, int points, boolean statut, String description) {
        super(nom, points, statut, description);
        this.type="Parcelle";
    }


    @Override
    public boolean estValide(List<Parcelle> parcelles) {
        switch (getNom()) {
            case "PARADJ":
                return verifierValiderPARADJ(parcelles);
            case "POUSSB":
                return verifierValiderPOUSSB(parcelles);
            case "ALI3":
                return verifierValiderAli3(parcelles);
            case "PARC":
                return verifierValiderPARC(parcelles);
            case "GRP3":
                return verifierValiderGRP3(parcelles);
            case "GRP4":
                return verifierValiderGRP4(parcelles);


        }
        return false;
    }

    private boolean verifierValiderGRP4(List<Parcelle> parcelles) {
        List<Position> positions = parcelles.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if ((p.y%2==0)&&(positions.contains(new Position(p.x , p.y + 2))&&positions.contains(new Position(p.x , p.y + 1)))
                    &&  positions.contains(new Position(p.x +1, p.y + 1)))
                return true;
            if ((p.y%2!=0)&&(positions.contains(new Position(p.x , p.y + 2))&&positions.contains(new Position(p.x-1 , p.y + 1)))
                    &&  positions.contains(new Position(p.x , p.y + 1)))
                return true;
        }
        return false;
    }

    private boolean verifierValiderGRP3(List<Parcelle> parcelles) {
        List<Position> positions = parcelles.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if ((p.getY()%2==0)&&positions.contains(new Position(p.x , p.y + 1)) && ( positions.contains(new Position(p.x + 1, p.y + 1))))
                return true;
            if ((p.getY()%2!=0)&&positions.contains(new Position(p.x , p.y + 1)) && (positions.contains(new Position(p.x-1, p.y + 1)) ))
                return true;
        }

        return false;
    }

    private boolean verifierValiderPARC(List<Parcelle> parcelles) {
        List<Position> positions = parcelles.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if ((p.y%2==0)&&positions.contains(new Position(p.x , p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1)) ))
                return true;
            if ((p.y%2!=0)&&positions.contains(new Position(p.x-1 , p.y + 1)) && (positions.contains(new Position(p.x, p.y + 2)) ))
                return true;
        }

        return false;
    }

    private boolean verifierValiderAli3(List<Parcelle> parcelles) {
        List<Position> positions = parcelles.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if ((p.getY()%2==0)){
                if(positions.contains(new Position(p.x + 1, p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1))  ))
                return true;
                else if((positions.contains(new Position(p.x - 1, p.y + 1)) && (positions.contains(new Position(p.x-1, p.y + 2))  ))){
                    return  true;

                }
            }
            if ((p.getY()%2!=0)){if(positions.contains(new Position(p.x + 1, p.y + 2)) && (positions.contains(new Position(p.x+1, p.y + 1))  ))
                return true;
                else if(positions.contains(new Position(p.x - 1, p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1)) )) return true;
            }

        }
        return false;


    }

    private boolean verifierValiderPOUSSB(List<Parcelle> parcelles) {
        if (parcelles.get(parcelles.size()-1).getBambou().isPresent()) return true;
        return false;
    }

    private boolean verifierValiderPARADJ(List<Parcelle> parcelles) {
        for (Parcelle p:parcelles
             ) {
            if(p.isAdjacent(parcelles.get(parcelles.size() - 1)))
                return true;
        }
        return false;
    }


}