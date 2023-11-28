package modele;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AppareilImpl implements Appareil {
    private final String nom;
    private final Set<Capteur> capteurs = new HashSet<Capteur>();

    public AppareilImpl(String nom) {
        this.nom = nom;
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
    public int getNombreDeCapteurs() {
        return capteurs.size();
    }

    @Override
    public boolean supprimerCapteur(Capteur capteur) {
        return this.capteurs.remove(capteur);
    }

    @Override
    public Capteur getCapteur(String nomCapteur) throws Exception {
        for (Capteur capteur : capteurs) {
            if (capteur.getNom().equals(nomCapteur)) return capteur;
        }
        throw new Exception("Capteur inexistant");
    }

    @Override
    public Set<String> getMessagesDesCapteurs() {
        Set<String> messages = new HashSet<>();
        for (Capteur capteur : this.capteurs) {
            String message = capteur.getDernierMessage();
            if (message != null) {
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public boolean estEquipeDuCapteur(String nomCapteur) {
        for (Capteur capteur : this.capteurs) {
            if (capteur.getNom().equals(nomCapteur)) return true;
        }
        return false;
    }

    @Override
    public int compareTo(Appareil app) {
        return this.nom.compareTo(app.getNom());
    }

}
