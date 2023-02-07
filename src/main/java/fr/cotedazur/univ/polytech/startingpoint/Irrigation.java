package fr.cotedazur.univ.polytech.startingpoint;

public class Irrigation {
    private Parcelle parcelleagauche, parcelleadroite;

    public Irrigation(Parcelle parcelleagauche, Parcelle parcelleadroite) {
        this.parcelleagauche = parcelleagauche;
        this.parcelleadroite = parcelleadroite;
    }


    public Parcelle getparcelleagauche() {
        return parcelleagauche;
    }


    public Parcelle getparcelleadroite() {
        return parcelleadroite;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Irrigation i = (Irrigation) o;

        return i.parcelleagauche.equals(this.parcelleagauche) && i.parcelleadroite.equals(this.parcelleadroite)
                || i.parcelleagauche.equals(this.parcelleadroite) && i.parcelleadroite.equals(this.parcelleagauche);
    }


    @Override
    public String toString() {
        return this.parcelleagauche.getPosition() + " | " + this.parcelleadroite.getPosition();
    }
}
