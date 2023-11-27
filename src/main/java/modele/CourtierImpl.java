package modele;

import java.util.*;

public class CourtierImpl implements Courtier {
    private Map<String,Appareil> appareils = new HashMap<String,Appareil>();
    @Override
    public boolean ajouterAppareil(Appareil appareil) {
        if (appareils.containsKey(appareil.getNom())) return false;
        this.appareils.put(appareil.getNom(),appareil);
        return true;
    }

    @Override
    public Appareil getAppareil(String nom) {
        return appareils.get(nom);
    }
}
