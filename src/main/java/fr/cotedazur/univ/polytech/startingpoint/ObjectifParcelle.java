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
            new ObjectifParcelle("GRP4", 4, false, "4 Parcelles groupées")
            //   new ObjectifParcelle("POUSSB", 2, false, "Pousse de bambou")
    ));

    @Override
    public String getType() {
        return Type.TYPE_PARCELLE.getNomType();
    }

    public ObjectifParcelle(String nom, int points, boolean statut, String description) {
        super(nom, points, statut, description);
        this.type = "Parcelle";
    }

    private static List<Parcelle> retirerEtang(List<Parcelle> parcelles) {
        List<Parcelle> parcellesSansEtang = new ArrayList<>(parcelles);
        parcellesSansEtang.remove(Parcelle.etang);
        return parcellesSansEtang;
    }

    public ObjectifVerifier verifierValider(List<Parcelle> parcelles) {
        return switch (getNom()) {
            case "ALI3" -> verifierValiderAli3(parcelles);
            case "PARC" -> verifierValiderPARC(parcelles);
            case "GRP3" -> verifierValiderGRP3(parcelles);
            case "GRP4" -> verifierValiderGRP4(parcelles);
            default -> null;
        };
    }

    @Override
    public boolean estValide(List<Parcelle> parcelles, Joueur joueur) {
        if(!joueur.getCartesObjectifs().contains(this))return false;
        else return estValide(parcelles);
    }

    @Override
    public ObjectifVerifier verifierValider(List<Parcelle> parcelles, Joueur joueur) {
        return null;
    }

    public boolean estValide (List < Parcelle > parcelles) {
            List<Parcelle> parcellesSansEtang = new ArrayList<>(parcelles);
            parcellesSansEtang.remove(Parcelle.etang);
            return switch (getNom()) {
                case "POUSSB" -> verifierValiderPOUSSB(parcellesSansEtang);
                case "ALI3" -> verifierValiderAli3(parcellesSansEtang).isManquant;
                case "PARC" -> verifierValiderPARC(parcellesSansEtang).isManquant;
                case "GRP3" -> verifierValiderGRP3(parcellesSansEtang).isManquant;
                case "GRP4" -> verifierValiderGRP4(parcellesSansEtang).isManquant;
                default -> false;
            };
        }

        static ObjectifVerifier verifierValiderGRP4 (List < Parcelle > parcelles) {
            List<Parcelle> parcellesSansEtang = retirerEtang(parcelles);
            ObjectifVerifierParcelle objectif = new ObjectifVerifierParcelle();
            List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
            for (Position p : positions
            ) {
                if (p.y % 2 == 0) {
                    if ((positions.contains(new Position(p.x, p.y + 2)) && positions.contains(new Position(p.x, p.y + 1))) && positions.contains(new Position(p.x + 1, p.y + 1))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    } else verifierGRP4Pair(objectif, positions, p);
                }
                if (p.y % 2 != 0) {
                    if ((positions.contains(new Position(p.x, p.y + 2)) && positions.contains(new Position(p.x - 1, p.y + 1))) && positions.contains(new Position(p.x, p.y + 1))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    }
                } else verifierGRP4impair(objectif, positions, p);
            }
            return objectif;
        }


        static ObjectifVerifier verifierValiderGRP3 (List < Parcelle > parcelles) {
            List<Parcelle> parcellesSansEtang = retirerEtang(parcelles);
            ObjectifVerifierParcelle ov = new ObjectifVerifierParcelle();
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

        static ObjectifVerifier verifierValiderPARC (List < Parcelle > parcelles) {
            List<Parcelle> parcellesSansEtang = retirerEtang(parcelles);
            List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
            ObjectifVerifierParcelle objectif = new ObjectifVerifierParcelle();
            for (Position p : positions
            ) {
                if (p.y % 2 == 0) {
                    if (positions.contains(new Position(p.x, p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1)) || positions.contains(new Position(p.x + 1, p.y + 1)))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    } else verifierParCPair(positions, objectif, p);
                }
                if ((p.y % 2 != 0) && (positions.contains(new Position(p.x - 1, p.y + 1)) || positions.contains(new Position(p.x, p.y + 1))) && (positions.contains(new Position(p.x, p.y + 2)))) {
                    objectif.setIsManquant(true);
                    return objectif;
                } else verifierParCImpair(positions, objectif, p);
            }
            return objectif;
        }


        static ObjectifVerifierParcelle verifierValiderAli3 (List < Parcelle > parcelles) {
            List<Parcelle> parcellesSansEtang = retirerEtang(parcelles);
            ObjectifVerifierParcelle objectif = new ObjectifVerifierParcelle();
            List<Position> positions = parcellesSansEtang.stream().map(Parcelle::getPosition).collect(Collectors.toList());
            for (Position p : positions
            ) {
                if ((p.getY() % 2 == 0)) {
                    if (positions.contains(new Position(p.x + 1, p.y + 2)) && (positions.contains(new Position(p.x + 1, p.y + 1)))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    } else verifierAli3Pair1(objectif, positions, p);
                    if ((positions.contains(new Position(p.x, p.y + 1)) && (positions.contains(new Position(p.x - 1, p.y + 2))))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    } else verifierAli3Pair2(objectif, positions, p);
                }
                if ((p.getY() % 2 != 0)) {
                    if (positions.contains(new Position(p.x + 1, p.y + 2)) && (positions.contains(new Position(p.x, p.y + 1)))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    } else verifierAli3Impair1(objectif, positions, p);
                    if (positions.contains(new Position(p.x - 1, p.y + 1)) && (positions.contains(new Position(p.x - 1, p.y + 2)))) {
                        objectif.setIsManquant(true);
                        return objectif;
                    } else verifierAli3Impair2(objectif, positions, p);
                }
            }
            return objectif;
        }

        private boolean verifierValiderPOUSSB (List < Parcelle > parcelles) {
            List<Parcelle> parcellesSansEtang = retirerEtang(parcelles);
            if (parcellesSansEtang.isEmpty()) return false;
            return parcellesSansEtang.get(parcelles.size() - 1).getBambou().isPresent();
        }


        private static void verifierGRP4impair (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            verifierParCImpair(positions, objectif, p);

        }

        private static void verifierGRP4Pair (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            verifierParCPair(positions, objectif, p);

        }

        private static void verifierGRP3Impair2 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x - 1, p.y - 1));
            aVerifier.add(new Position(p.x, p.y - 1));
            traitementsManquants(objectif, positions, aVerifier);
        }

        private static void verifierGRP3Impair1 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x, p.y + 1));
            aVerifier.add(new Position(p.x - 1, p.y + 1));
            traitementsManquants(objectif, positions, aVerifier);

        }

        private static void verifierGRP3Pair2 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x, p.y - 1));
            aVerifier.add(new Position(p.x + 1, p.y - 1));
            traitementsManquants(objectif, positions, aVerifier);

        }

        private static void verifierGRP3Pair1 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x, p.y + 1));
            aVerifier.add(new Position(p.x + 1, p.y + 1));
            traitementsManquants(objectif, positions, aVerifier);

        }

        private static void verifierParCImpair (List < Position > positions, ObjectifVerifierParcelle objectif, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x, p.y + 2));
            aVerifier.add(new Position(p.x - 1, p.y + 1));
            aVerifier.add(new Position(p.x, p.y + 1));
            traitementsManquants(objectif, positions, aVerifier);

        }

        private static void verifierParCPair (List < Position > positions, ObjectifVerifierParcelle objectif, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x, p.y + 2));
            aVerifier.add(new Position(p.x, p.y + 1));
            aVerifier.add(new Position(p.x + 1, p.y + 1));
            traitementsManquants(objectif, positions, aVerifier);

        }
        private static void verifierAli3Impair2 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x - 1, p.y + 1));
            aVerifier.add(new Position(p.x - 1, p.y + 2));
            traitementsManquants(objectif, positions, aVerifier);

        }

        private static void verifierAli3Pair2 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x, p.y + 1));
            aVerifier.add(new Position(p.x - 1, p.y + 2));
            traitementsManquants(objectif, positions, aVerifier);
        }
        private static void traitementsManquants (ObjectifVerifierParcelle
        objectif, List < Position > positions, List < Position > positionsAVerifier){
            List<Position> manquants = new ArrayList<>();
            for (Position position : positionsAVerifier
            ) {
                if (!positions.contains(position)) manquants.add(position);
            }
            objectif.ajoutManquants(manquants);

        }
        private static void verifierAli3Impair1 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> aVerifier = new ArrayList<>();
            aVerifier.add(new Position(p.x + 1, p.y + 2));
            aVerifier.add(new Position(p.x, p.y + 1));
            traitementsManquants(objectif, positions, aVerifier);
        }

        private static void verifierAli3Pair1 (ObjectifVerifierParcelle objectif, List < Position > positions, Position p){
            List<Position> positionList = new ArrayList<>();
            positionList.add(new Position(p.x + 1, p.y + 2));
            positionList.add(new Position(p.x + 1, p.y + 1));
            traitementsManquants(objectif, positions, positionList);

        }
    }
