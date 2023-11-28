package modele;
import java.util.*;

public interface Registre {

    // permet d'ajouter un appareil au registre
    // return true si l'appareil a été ajouté.
    // l'appareil n'est pas ajouté si déjà présent dans le registre. Return false dans ce cas.
    boolean ajouterAppareil(Appareil appareil);

    // permet d'obtenir la référence de l'appareil dont on précise le nom
    // renvoie null, si l'appareil n'est pas présent dans le registre
    Appareil getAppareil(String nom);

    // permet d'obtenir les messages des capteurs d'un appareil dont on précise le nom en paramètre
    // lance une exception si cet appareil n'est pas présent de le registre
    Set<String> getMessagesDesCapteursDUnAppareil(String nomAppareil) throws Exception;

    // permet de mémoriser un message obtenu lors d'un relevé d'un capteur
    // le message est mémorisé dans le capteur dont on précise en paramètre le nom, ainsi que le nom de l'appareil qui devrait en être équipé
    // lance une exception si cet appareil n'est pas présent de le registre
    // lance une exception si l'appareil n'est pas équipé de ce capteur
    // si un message existe déjà pour le capteur de cet appareil, il est remplacé par le nouveau
     void memoriserMessage(String nomAppareil, String nomCapteur, String message) throws Exception;


     // renvoie une liste triée des appareils du registre
    //  cette liste sera triée en tenant compte du comparateur passé en paramètre
    List<Appareil> getListeTrieeAppareils(Comparator<Appareil> comparator);
}
