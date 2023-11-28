package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Set;

@TestMethodOrder(OrderAnnotation.class)
public class TestAppareil {
    private static final String NOM_BATTERIE1 = "batterie B";
    private static final String NOM_BATTERIE2 = "batterie A";
    private static final Appareil batterie1 = new AppareilImpl(NOM_BATTERIE1);
    private static final Appareil batterie2 = new AppareilImpl(NOM_BATTERIE2);
    private static final String NOM_CAPTEUR_1 = "capteur tension";
    private static final String NOM_CAPTEUR_2 = "capteur intensite";
    private static Capteur capteur1 = new Capteur(TypeCapteur.TENSION, NOM_CAPTEUR_1);
    private static Capteur capteur2 = new Capteur(TypeCapteur.INTENSITE, NOM_CAPTEUR_2);
    @Test @Order(1)
    public void testAjoutCapteur1() {
        assertTrue(batterie1.ajouterCapteur(capteur1));
        assertTrue(batterie1.estEquipeDuCapteur(capteur1.getNom()));
    }
    @Test @Order(2)
    public void testAjoutANouveauCapteur1() {
        assertFalse(batterie1.ajouterCapteur(capteur1));
    }
    @Test @Order(3)
    public void testAjoutCapteur2() {
        assertTrue(batterie1.ajouterCapteur(capteur2));
        assertTrue(batterie1.estEquipeDuCapteur(capteur2.getNom()));
        assertEquals(2,batterie1.getNombreDeCapteurs());
    }
    @Test @Order(4)
    public void testSuppressionCapteurExistant() {
        assertTrue(batterie1.supprimerCapteur(capteur2));
        assertFalse(batterie1.estEquipeDuCapteur(capteur2.getNom()));
        assertEquals(1,batterie1.getNombreDeCapteurs());
    }
    @Test @Order(5)
    public void testSuppressionCapteurInexistant() {
        assertFalse(batterie1.supprimerCapteur(capteur2));
        assertFalse(batterie1.estEquipeDuCapteur(capteur2.getNom()));
        assertEquals(1,batterie1.getNombreDeCapteurs());
    }

    @Test @Order(6)
    public void testGetMessagesCapteursAvec0Message() {
        assertTrue(batterie1.ajouterCapteur(capteur2));
        Set<String> messages = batterie1.getMessagesDesCapteurs();
        assertNotNull(messages);
        assertEquals(0, messages.size());
    }
    @Test @Order(7)
    public void testGetMessagesCapteursAvec1Message() {
        capteur1.setDernierMessage("message capteur 1");
        Set<String> messages = batterie1.getMessagesDesCapteurs();
        assertNotNull(messages);
        assertEquals(1, messages.size());
    }
    @Test @Order(8)
    public void testGetMessagesCapteursAvec2Messages() {
        capteur2.setDernierMessage("message capteur 2");
        Set<String> messages = batterie1.getMessagesDesCapteurs();
        assertNotNull(messages);
        assertEquals(2, messages.size());
    }
    @Test
    @Order(9)
    public void testMemoriserMessageCapteurInexistant() {
        try {
            batterie1.getCapteur( "capteur inexistant");
            fail("Il aurait du lancer une exception car le capteur est inexistant");
        } catch (Exception ex) {
            // ok
        }
    }
    @Test @Order(10)
    public void testComparable() {
        assertEquals(1, batterie1.compareTo(batterie2));
    }

}
