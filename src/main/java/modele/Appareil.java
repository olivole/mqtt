package modele;

import java.util.Set;

// la comparaison des appareils doit se faire sur les noms des appareils
public interface Appareil extends Comparable<Appareil>{

    // permet d'obtenir le nom de l'appareil
    String getNom();
    // permet d'ajouter un capteur
    // si capteur déjà présent, renvoie false
    // renvoie true si ajouté
    boolean ajouterCapteur(Capteur capteur);

    // renvoie le nombre de capteurs dont cet appareil est équipé
    int getNombreDeCapteurs();

    // permet de supprimer un capteur de l'appareil
    // renvoie false si l'appareil n'est pas équipé de ce capteur
    // renvoie true si le capteur a été supprimé
    boolean supprimerCapteur(Capteur capteur);

    // permet d'obtenir la référence du capteur dont on précise le nom
    // lance une exception si l'appareil n'est pas équipé de ce capteur
    Capteur getCapteur(String nomCapteur) throws Exception;

    // permet d'obtenir les messages des capteurs dont cet appreil est équippé
    // si pas de message, une liste vide est renvoyée
    Set<String> getMessagesDesCapteurs();

    // permet de savoir si l'appareil est équipé du capteur dont on précise le nom en paramètre
    boolean estEquipeDuCapteur(String nomCapteur);
}
