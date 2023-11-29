package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@TestMethodOrder(OrderAnnotation.class)
public class TestRegistre {

    private static final String NOM_CAPTEUR1 = "capteur tension";
    private static final String NOM_CAPTEUR2 = "capteur intensite";
    private static final String MESSAGE1 = "tension 55.2 v";
    private static final String MESSAGE2 = "intensite 4 A";
    private static Capteur capteur1 = new Capteur(TypeCapteur.TENSION, NOM_CAPTEUR1);
    private static Capteur capteur2 = new Capteur(TypeCapteur.INTENSITE, NOM_CAPTEUR2);
    private static final String NOM_BATTERIE1 = "batterie B";
    private static final String NOM_BATTERIE2 = "batterie A";
    private static final Appareil batterie1 = new AppareilImpl(NOM_BATTERIE1);
    private static final Appareil batterie2 = new AppareilImpl(NOM_BATTERIE2);
    private static final Registre registre = new RegistreImpl();


    // Test ajout batterie1
    @Test
    @Order(1)
    public void testAjoutBatterie1() {
        assertTrue(registre.ajouterAppareil(batterie1));
        Appareil app1 = registre.getAppareil(NOM_BATTERIE1);
        assertNotNull(app1);
        assertEquals(0, batterie1.compareTo(app1));
    }

    // Test ajout à nouveau batterie1
    @Test
    @Order(2)
    public void testAjoutBatterie1DeNouveau() {
        assertFalse(registre.ajouterAppareil(batterie1));
        assertEquals(batterie1, registre.getAppareil(NOM_BATTERIE1));
    }

    // Test ajout batterie2
    @Test
    @Order(3)
    public void testAjoutBatterie2() {
        assertTrue(registre.ajouterAppareil(batterie2));
        Appareil app2 = registre.getAppareil(NOM_BATTERIE2);
        assertNotNull(app2);
        assertEquals(0, batterie2.compareTo(app2));
    }

    @Test
    @Order(4)
    public void testMemoriserMessage1() {
        try {
            batterie1.ajouterCapteur(capteur1);
            registre.memoriserMessage(NOM_BATTERIE1, NOM_CAPTEUR1, MESSAGE1);
            Set<String> messages = registre.getMessagesDesCapteursDUnAppareil(NOM_BATTERIE1);
            assertNotNull(messages);
            assertEquals(1, messages.size());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    @Order(5)
    public void testMemoriserMessage2() {
        try {
            batterie1.ajouterCapteur(capteur2);
            registre.memoriserMessage(NOM_BATTERIE1, NOM_CAPTEUR2, MESSAGE2);
            Set<String> messages = registre.getMessagesDesCapteursDUnAppareil(NOM_BATTERIE1);
            assertNotNull(messages);
            assertEquals(2, messages.size());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    @Order(6)
    public void testMemoriserMessageAppareilInexistant() {
        try {
            registre.memoriserMessage("appareil inexistant", NOM_CAPTEUR2, MESSAGE2);
            fail("Il aurait du lancer une exception car l'appareil est inexistant");
        } catch (Exception ex) {
            // ok
        }
    }

    @Test
    @Order(7)
    public void testMemoriserMessageCapteurInexistant() {
        try {
            registre.memoriserMessage(NOM_BATTERIE1, "capteur inexistant", MESSAGE2);
            fail("Il aurait du lancer une exception car le capteur est inexistant");
        } catch (Exception ex) {
            // ok
        }
    }
        @Test
        @Order(8)
        public void testGetListeTrieeAppareilsSurLesNoms () {
            Comparator<Appareil> comparateurNoms = (ap1, ap2) -> ap1.getNom().compareTo(ap2.getNom());
            List<Appareil> appareilsTries = registre.getListeTrieeAppareils(comparateurNoms);
            assertNotNull(appareilsTries);
            assertEquals(2, appareilsTries.size());
            assertEquals(batterie2, appareilsTries.get(0));
            assertEquals(batterie1, appareilsTries.get(1));
        }
    @Test
    @Order(9)
    public void testGetListeTrieeAppareilsSurLeNombreDeCapteurs () {
        Comparator<Appareil> comparateurCapteurs = (ap1, ap2) -> ap1.getNombreDeCapteurs()-ap2.getNombreDeCapteurs();
        List<Appareil> appareilsTries = registre.getListeTrieeAppareils(comparateurCapteurs);
        assertNotNull(appareilsTries);
        assertEquals(2, appareilsTries.size());
        assertEquals(batterie2, appareilsTries.get(0));
        assertEquals(batterie1, appareilsTries.get(1));
    }
}
