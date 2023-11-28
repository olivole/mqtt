package modele;

import java.util.Set;

// la comparaison des appareils doit se faire sur les noms des appareils
public interface Appareil extends Comparable<Appareil>{
    String getNom();
    boolean ajouterCapteur(Capteur capteur);

    int getNombreDeCapteurs();

    boolean supprimerCapteur(Capteur capteur);

    // lance une exception si l'appareil n'est pas équipé de ce capteur
    Capteur getCapteur(String nomCapteur) throws Exception;

    Set<String> getMessagesDesCapteurs();

    boolean estEquipeDuCapteur(String nomCapteur);
}
