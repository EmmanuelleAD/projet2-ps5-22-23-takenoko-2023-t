package fr.cotedazur.univ.polytech.startingpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectifParcelle extends Objectif {
    static List<ObjectifParcelle> objectifParcelles = new ArrayList<>(Arrays.asList(
            new ObjectifParcelle("ALI3", 2, false, "3 Parcelles alignées"),
            new ObjectifParcelle("PARC", 3, false, "Parcelles en C"),
            new ObjectifParcelle("GRP3", 4, false, "3 Parcelles groupées"),
            new ObjectifParcelle("GRP4", 4, false, "4 Parcelles groupées"),
            new ObjectifParcelle("PARADJ", 2, false, "Adjacence parcelle"),
            new ObjectifParcelle("POUSSB", 2, false, "Pousse de bambou")
    ));

    public ObjectifParcelle(String nom, int points, boolean statut, String description) {
        super(nom, points, statut, description);
        this.type = "Parcelle";
    }

    private static List<Parcelle>retirerEtang(List<Parcelle>parcelles){
        List<Parcelle> parcellesSansEtang = new ArrayList<>(parcelles);
        parcellesSansEtang.remove(Parcelle.etang);
        return parcellesSansEtang;
    }


    @Override
    public boolean estValide(List<Parcelle> parcelles) {
        List<Parcelle> parcellesSansEtang = new ArrayList<>(parcelles);
        parcellesSansEtang.remove(Parcelle.etang);

        return switch (getNom()) {
            case "PARADJ" -> verifierValiderPARADJ(parcellesSansEtang);
            case "POUSSB" -> verifierValiderPOUSSB(parcellesSansEtang);
            case "ALI3" -> verifierValiderAli3(parcellesSansEtang).isManquant;
            case "PARC" -> verifierValiderPARC(parcellesSansEtang).isManquant;
            case "GRP3" -> verifierValiderGRP3(parcellesSansEtang).isManquant;
            case "GRP4" -> verifierValiderGRP4(parcellesSansEtang).isManquant;
            default -> false;
        };
    }

    static ObjectifVerifier verifierValiderGRP4(List<Parcelle> parcelles) {
        List<Parcelle>parcellesSansEtang= retirerEtang(parcelles);
        ObjectifVerifier objectif = new ObjectifVerifier();
        List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if (p.y % 2 == 0) {
                if ((positions.contains(new Position(p.x, p.y + 2)) && positions.contains(new Position(p.x, p.y + 1))) && positions.contains(new Position(p.x + 1, p.y + 1))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }
               else verifierGRP4Pair(objectif, positions, p);
            }
            if (p.y % 2 != 0) {
                if ((positions.contains(new Position(p.x, p.y + 2)) && positions.contains(new Position(p.x - 1, p.y + 1))) && positions.contains(new Position(p.x, p.y + 1))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }
            }
           else verifierGRP4impair(objectif, positions, p);
        }
        return objectif;
    }


    static ObjectifVerifier verifierValiderGRP3(List<Parcelle> parcelles) {
        List<Parcelle>parcellesSansEtang= retirerEtang(parcelles);
        ObjectifVerifier ov = new ObjectifVerifier();
        List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if ((p.getY() % 2 == 0)) {
                if (positions.contains(new Position(p.x, p.y + 1)) && (positions.contains(new Position(p.x + 1, p.y + 1)))) {
                    ov.setIsManquant(true);
                    return ov;
                } else verifierGRP3Pair1(ov, positions, p);
                if (positions.contains(new Position(p.x, p.y - 1)) && (positions.contains(new Position(p.x + 1, p.y - 1)))) {
                    ov.setIsManquant(true);
                    return ov;
                } else verifierGRP3Pair2(ov, positions, p);
            }
            if ((p.getY() % 2 != 0)) {
                if (positions.contains(new Position(p.x, p.y + 1)) && (positions.contains(new Position(p.x - 1, p.y + 1)))) {
                    ov.setIsManquant(true);
                    return ov;
                } else verifierGRP3Impair1(ov, positions, p);

                if (positions.contains(new Position(p.x - 1, p.y - 1)) && (positions.contains(new Position(p.x, p.y - 1)))) {
                    ov.setIsManquant(true);
                    return ov;
                } else verifierGRP3Impair2(ov, positions, p);
            }
        }
        return ov;
    }

    static ObjectifVerifier verifierValiderPARC(List<Parcelle> parcelles) {
        List<Parcelle>parcellesSansEtang= retirerEtang(parcelles);
        List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        ObjectifVerifier objectif = new ObjectifVerifier();
        for (Position p : positions
        ) {
            if (p.y % 2 == 0) {
                if (positions.contains(new Position(p.x, p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1)) || positions.contains(new Position(p.x + 1, p.y + 1)))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }else verifierParCPair(positions, objectif, p);
            }
            if ((p.y % 2 != 0) && (positions.contains(new Position(p.x - 1, p.y + 1)) || positions.contains(new Position(p.x, p.y + 1))) && (positions.contains(new Position(p.x, p.y + 2)))) {
                objectif.setIsManquant(true);
                return objectif;
            }else verifierParCImpair(positions, objectif, p);
        }
        return objectif;
    }


    static ObjectifVerifier verifierValiderAli3(List<Parcelle> parcelles) {
        List<Parcelle>parcellesSansEtang= retirerEtang(parcelles);
        ObjectifVerifier objectif = new ObjectifVerifier();
        List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
        for (Position p : positions
        ) {
            if ((p.getY() % 2 == 0)) {
                if (positions.contains(new Position(p.x + 1, p.y + 2)) && (positions.contains(new Position(p.x + 1, p.y + 1)))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }else verifierAli3Pair1(objectif, positions, p);
                if ((positions.contains(new Position(p.x, p.y + 1)) && (positions.contains(new Position(p.x - 1, p.y + 2))))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }
               else  verifierAli3Pair2(objectif, positions, p);
            }
            if ((p.getY() % 2 != 0)) {
                if (positions.contains(new Position(p.x + 1, p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1)))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }
               else verifierAli3Impair1(objectif, positions, p);
                if (positions.contains(new Position(p.x - 1, p.y + 1)) && (positions.contains(new Position(p.x - 1, p.y + 2)))) {
                    objectif.setIsManquant(true);
                    return objectif;
                }
                else verifierAli3Impair2(objectif, positions, p);
            }
        }
        return objectif;
    }

    private boolean verifierValiderPOUSSB(List<Parcelle> parcelles) {
        List<Parcelle>parcellesSansEtang= retirerEtang(parcelles);
        if (parcellesSansEtang.isEmpty())return  false;
        return parcellesSansEtang.get(parcelles.size() - 1).getBambou().isPresent();
    }


    private boolean verifierValiderPARADJ(List<Parcelle> parcelles) {
        List<Parcelle>parcellesSansEtang= retirerEtang(parcelles);
        for (Parcelle p : parcellesSansEtang
        ) {
            if (p.isAdjacent(parcelles.get(parcelles.size() - 1)))
                return true;
        }
        return false;
    }
    private static void verifierGRP4impair(ObjectifVerifier objectif, List<Position> positions, Position p) {
        verifierParCImpair(positions,objectif,p);

    }

    private static void verifierGRP4Pair(ObjectifVerifier objectif, List<Position> positions, Position p) {
      verifierParCPair(positions,objectif,p);

    }

    private static void verifierGRP3Impair2(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x-1, p.y - 1));
        aVerifier.add(new Position(p.x , p.y - 1));
        traitementsManquants(objectif,positions,aVerifier);
    }

    private static void verifierGRP3Impair1(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x, p.y + 1));
        aVerifier.add(new Position(p.x - 1, p.y + 1));
        traitementsManquants(objectif,positions,aVerifier);

    }

    private static void verifierGRP3Pair2(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x, p.y - 1));
        aVerifier.add(new Position(p.x + 1, p.y - 1));
        traitementsManquants(objectif,positions,aVerifier);

    }

    private static void verifierGRP3Pair1(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x, p.y + 1));
        aVerifier.add(new Position(p.x + 1, p.y + 1));
        traitementsManquants(objectif,positions,aVerifier);

    }

    private static void verifierParCImpair(List<Position> positions, ObjectifVerifier objectif, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x, p.y + 2));
        aVerifier.add(new Position(p.x-1 , p.y + 1));
        aVerifier.add(new Position(p.x , p.y + 1));
        traitementsManquants(objectif,positions,aVerifier);

    }

    private static void verifierParCPair(List<Position> positions, ObjectifVerifier objectif, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x, p.y + 2));
        aVerifier.add(new Position(p.x , p.y + 1));
        aVerifier.add(new Position(p.x+1 , p.y + 1));
        traitementsManquants(objectif,positions,aVerifier);

    }
    private static void verifierAli3Impair2(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x-1, p.y + 1));
        aVerifier.add(new Position(p.x - 1, p.y + 2));
        traitementsManquants(objectif,positions,aVerifier);

    }

    private static void verifierAli3Pair2(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x, p.y + 1));
        aVerifier.add(new Position(p.x - 1, p.y + 2));
     traitementsManquants(objectif,positions,aVerifier);
    }
    private static void traitementsManquants(ObjectifVerifier objectif, List<Position> positions,List<Position> positionsAVerifier){
        List<Position> manquants = new ArrayList<>();
        for (Position position:positionsAVerifier
        ) {
            if(!positions.contains(position)) manquants.add(position);
        }
        objectif.ajoutManquants(manquants);

    }
    private static void verifierAli3Impair1(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>aVerifier=new ArrayList<>();
        aVerifier.add(new Position(p.x + 1, p.y + 2));
        aVerifier.add(new Position(p.x, p.y + 1));
      traitementsManquants(objectif,positions,aVerifier);
    }

    private static void verifierAli3Pair1(ObjectifVerifier objectif, List<Position> positions, Position p) {
        List<Position>positionList=new ArrayList<>();
        positionList.add(new Position(p.x + 1, p.y + 2));
        positionList.add(new Position(p.x + 1, p.y + 1));
        traitementsManquants(objectif,positions,positionList);

    }


}