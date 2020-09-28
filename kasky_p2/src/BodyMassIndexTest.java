import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    //Under weight
    private BodyMassIndex underWeight = new BodyMassIndex(78, 150);

    //Normal weight
    private BodyMassIndex normalWeight = new BodyMassIndex(65, 130);

    //Over weight
    private BodyMassIndex overWeight = new BodyMassIndex(56, 125);

    //Obese
    private BodyMassIndex obese = new BodyMassIndex(66, 300);

    @Test
    void getBmi() {

        assertEquals(21.6, normalWeight.getBmi());

    }

    @Test
    void getCat() {

        assertEquals("Normal Weight", normalWeight.getCat());

    }

    @Test
    void calcBmiUnderWeight() {

        assertEquals(17.3, underWeight.getBmi());

    }

    @Test
    void categoryUnderWeight() {

        assertEquals("Under Weight", underWeight.getCat());

    }

    @Test
    void calcBmiNormalWeight() {

        assertEquals(21.6, normalWeight.getBmi());

    }

    @Test
    void categoryNormalWeight() {

        assertEquals("Normal Weight", normalWeight.getCat());

    }

    @Test
    void calcBmiOverWeight() {

        assertEquals(28.0, overWeight.getBmi());

    }

    @Test
    void categoryOverWeight() {

        assertEquals("Over Weight", overWeight.getCat());

    }

    @Test
    void calcBmiObese() {

        assertEquals(48.4, obese.getBmi());

    }

    @Test
    void categoryObese() {

        assertEquals("Obese", obese.getCat());

    }

}