package modele;

import java.util.*;

public class RegistreImpl implements Registre {
    private Map<String, Appareil> appareils = new HashMap<String, Appareil>();

    @Override
    public boolean ajouterAppareil(Appareil appareil) {
        if (appareils.containsKey(appareil.getNom())) return false;
        this.appareils.put(appareil.getNom(), appareil);
        return true;
    }

    @Override
    public Appareil getAppareil(String nom) {
        return appareils.get(nom);
    }

    @Override
    public Set<String> getMessagesDesCapteursDUnAppareil(String nomAppareil) throws Exception {

        Set<String> messages=new HashSet();
        for (Appareil app : this.appareils.values()) {
            if (app.getNom().equals(nomAppareil)) {
                return app.getMessagesDesCapteurs();
            }
        }
        throw new Exception("Appareil inexistant");
    }

    @Override
    public void memoriserMessage(String nomAppareil, String nomCapteur, String message) throws Exception {
        if (!this.appareils.containsKey(nomAppareil)) throw new Exception("Appareil inexistant");
        Appareil appareil = this.appareils.get(nomAppareil);
        Capteur capteur = appareil.getCapteur(nomCapteur);
        capteur.setDernierMessage(message);
    }

    @Override
    public List<Appareil> getListeTrieeAppareils(Comparator<Appareil> comparator) {
        List<Appareil> appareils= new ArrayList<>(this.appareils.values());
        Collections.sort(appareils,comparator);
        return appareils;
    }
}
