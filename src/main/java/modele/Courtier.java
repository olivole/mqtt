package modele;

public interface Courtier {
    boolean ajouterAppareil(Appareil appareil);

    Appareil getAppareil(String nom);
}
