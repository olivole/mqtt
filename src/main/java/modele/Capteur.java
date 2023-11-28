package modele;

public class Capteur {
    private TypeCapteur typeCapteur;
    private String nom;

    private String dernierMessage;

    public Capteur(TypeCapteur typeCapteur, String nom) {
        this.typeCapteur = typeCapteur;
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDernierMessage() {
        return dernierMessage;
    }

    public void setDernierMessage(String dernierMessage) {
        this.dernierMessage = dernierMessage;
    }
}
