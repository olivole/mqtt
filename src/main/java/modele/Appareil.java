package modele;

public interface Appareil extends Comparable<Appareil>{
    String getNom();
    boolean ajouterCapteur(Capteur capteur);

    boolean estEquipeDuCapteur(Capteur capteur);

    int getNombreDeCapteurs();

    boolean supprimerCapteur(Capteur capteur);
}
