package modele;

public enum TypeCapteur {
    TENSION("Tension", "V"), INTENSITE("Intensite","A"), TEMPERATURE("Temperature","°C"), SOC("Etat de charge", "%");

    private final String nom;
    private final String uniteMesure;

    TypeCapteur(String nom, String uniteMesure) {
        this.nom=nom;
        this.uniteMesure=uniteMesure;
    }

}
