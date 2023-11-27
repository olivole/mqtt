package modele;

import java.util.HashSet;
import java.util.Set;

public class AppareilImpl implements Appareil {
    private final String nom;
    private final Set<Capteur> capteurs = new HashSet<Capteur>();

    public AppareilImpl(String nom) {
        this.nom=nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public boolean ajouterCapteur(Capteur capteur) {
        return this.capteurs.add(capteur);
    }

    @Override
    public boolean estEquipeDuCapteur(Capteur capteur) {
        return capteurs.contains(capteur);
    }

    @Override
    public int getNombreDeCapteurs() {
        return capteurs.size();
    }

    @Override
    public boolean supprimerCapteur(Capteur capteur) {
        return this.capteurs.remove(capteur);
    }

    @Override
    public int compareTo(Appareil app) {
        return this.nom.compareTo(app.getNom());
    }

}
