package modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class TestCourtier {

    private static final String NOM_BATTERIE1 = "batterie1";
    private static final String NOM_BATTERIE2 = "batterie2";
    private static final Appareil batterie1 = new AppareilImpl(NOM_BATTERIE1);
    private static final Appareil batterie2 = new AppareilImpl(NOM_BATTERIE2);
    private static final Courtier courtier = new CourtierImpl();

    // Test ajout à nouveau batterie1
    @Test
    @Order(1)
    public void testAjoutBatterie1() {
        assertTrue(courtier.ajouterAppareil(batterie1));
        Appareil app1 = courtier.getAppareil(NOM_BATTERIE1);
        assertEquals(0, batterie1.compareTo(app1));
    }

    // Test ajout à nouveau batterie1
    @Test
    @Order(2)
    public void testAjoutBatterie1DeNouveau() {
        assertFalse(courtier.ajouterAppareil(batterie1));
        assertEquals(batterie1, courtier.getAppareil(NOM_BATTERIE1));
    }

    // Test ajout batterie2
    @Test
    @Order(3)
    public void testAjoutBatterie2() {
        assertTrue(courtier.ajouterAppareil(batterie2));
        Appareil app2 = courtier.getAppareil(NOM_BATTERIE2);
        assertEquals(0, batterie2.compareTo(app2));
    }


}
