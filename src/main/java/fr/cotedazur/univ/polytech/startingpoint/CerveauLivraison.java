package fr.cotedazur.univ.polytech.startingpoint;

import java.util.*;


public class CerveauLivraison extends Cerveau {
    int i = 0;

    public int getI() {
        return i % 2;

    }

    public CerveauLivraison(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Action decider(Jeu jeu, Action derniere) {
        Action newAction1 = getActionPiocher(jeu, derniere);
        if (newAction1 != null) return newAction1;
        ActionPanda sabotage = detecterActionPanda(jeu, derniere);
        ActionPanda sabotage2 = (ActionPanda) detecterActionJardinier(jeu,derniere);
        Action parcellesAvec = seFocaliser(jeu, derniere);
        if (parcellesAvec != null) return parcellesAvec;
        if (sabotage != null) {
            sabotage.setSabotage(true);
            return sabotage;
        }
        if (sabotage2 != null){
            sabotage2.setSabotage(true);
            return sabotage2;
        }

        Action newAction = getMaxBambous(jeu, derniere);
        if (newAction != null) return newAction;
        return placerUneParcelle(jeu, derniere);


    }


    private Action getMaxBambous(Jeu jeu, Action derniere) {
        List<Parcelle> parcellesAvecUneSection = jeu.getParcellesPlacees().stream().filter(p -> p.getTaille() >= 1).toList();
        parcellesAvecUneSection = jeu.getPanda().deplacementsPossibles(parcellesAvecUneSection);
        if (!parcellesAvecUneSection.isEmpty()) {
            Action newAction = new ActionPanda(parcellesAvecUneSection.get(0));
            if (this.retournerAction(newAction, derniere) != null) return newAction;
        }
        return null;
    }

    private Action seFocaliser(Jeu jeu, Action derniere) {
        List<Objectif> objectifBambou = joueur.getCartesObjectifs();
        objectifBambou = objectifBambou.stream().filter(o -> o.getType().equals(Type.TYPE_PANDA.getNomType())).toList();
        List<Bambou> bambousJoueur = new ArrayList<>(joueur.getPlateau().getBambous());
        if (!objectifBambou.isEmpty() && (objectifBambou.size() >= 2)) {
            objectifBambou = objectifBambou.subList(0, 2);
            ObjectifPanda obj = (ObjectifPanda) objectifBambou.get(i % 2);
            i++;
            if (!obj.estValide(jeu.getParcellesPlacees(), joueur)) {
                Action parcellesAvec = CerveauPanda.getActionObjectif(jeu, bambousJoueur, obj);

                if (parcellesAvec != null && this.retournerAction(parcellesAvec, derniere) != null) {

                    return parcellesAvec;
                }

            }

        } else if (objectifBambou.size() == 1) {
            Action parcellesAvec = CerveauPanda.getActionObjectif(jeu, bambousJoueur, (ObjectifPanda) objectifBambou.get(0));
            if (parcellesAvec != null && this.retournerAction(parcellesAvec, derniere) != null) return parcellesAvec;

        }
        return null;
    }

    private Action getActionPiocher(Jeu jeu, Action derniere) {
        if (joueur.getCartesObjectifs().isEmpty() || joueur.getCartesObjectifs().size() < 5) {
            List<ObjectifPanda> op = jeu.getObjectifsPanda();
            Objectif newObjectif = op.get(op.size() - 1);
            ActionPiocher newAction = new ActionPiocher(newObjectif);
            return this.retournerAction(newAction, derniere);

        }
        return null;
    }

    private ActionPanda detecterActionPanda(Jeu jeu, Action derniere) {
        List<Joueur> joueursSansLivraison = new ArrayList<>(jeu.getJoueurs());
        joueursSansLivraison.remove(joueur);
        for (Joueur joueur : joueursSansLivraison
        ) {
            for (ObjectifPanda o : ObjectifPanda.objectifPandas
            ) {
                if (!o.estValide(jeu.getParcellesPlacees(), joueur)) {
                    ObjectifVerifierPanda objectifVerifierPanda = o.verifierValider(jeu.getParcellesPlacees(), joueur);
                    if (objectifVerifierPanda.getBambouList().size() == 1) {
                        List<Parcelle> parcellesPotentiels = Parcelle.getParcellesAvec(jeu.getParcellesPlacees(), objectifVerifierPanda.getBambouList().get(0));
                        parcellesPotentiels = jeu.getPanda().deplacementsPossibles(parcellesPotentiels);
                        if (!parcellesPotentiels.isEmpty()) {
                            Parcelle parcelle = parcellesPotentiels.get(0);
                            ActionPanda potentiel = new ActionPanda(parcelle);
                            if (this.retournerAction(potentiel, derniere) != null) {
                                return potentiel;
                            }
                        }
                    }
                }

            }

        }
        return null;
    }

    public Action detecterActionJardinier(Jeu jeu, Action derniere) {
        List<Joueur> joueursSansLivraison = new ArrayList<>(jeu.getJoueurs());
        Collections.sort(joueursSansLivraison, Joueur.scoreComparator.reversed());
        int maxscore = joueursSansLivraison.get(0).getScore();
        joueursSansLivraison.remove(joueur);
        for (Joueur joueur0 : joueursSansLivraison) {
            List<Objectif> listObjectif = joueur0.getCartesObjectifs();
            listObjectif = listObjectif.stream().filter(o -> o.getType().equals(Type.TYPE_JARDINIER.getNomType())).toList();
            if (joueur0.getScore() == maxscore && !listObjectif.isEmpty()) {
                Parcelle parcelleMaxPossible = Parcelle.parcelleTailleMax(Parcelle.ParcellesTailleN(jeu.getPanda().deplacementsPossibles(jeu.getParcellesPlacees()), 3));
                Parcelle parcelleMax = Parcelle.parcelleTailleMax(Parcelle.ParcellesTailleN(jeu.getParcellesPlacees(), 3));
                if (parcelleMaxPossible.getTaille() <= 1) {
                    for (Parcelle parcelle : jeu.getParcellesPlacees()) {
                        if (Position.isStraightMovement(parcelleMax.getPosition(), parcelle.getPosition())) {
                            ActionPanda newAction = new ActionPanda(parcelle);
                            if (this.retournerAction(newAction, derniere) != null){
                                return newAction;
                            }
                        }
                    }
                }
                ActionPanda newAction = new ActionPanda(parcelleMaxPossible);
                if (this.retournerAction(newAction, derniere) != null){
                    return newAction;
                }
            }
        }
        return null;
    }
}
