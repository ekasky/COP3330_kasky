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

        double expectedBmi = 21.6;
        assertEquals(expectedBmi, normalWeight.getBmi());

    }

    @Test
    void getCat() {

        String expectedCat = "Normal Weight";
        assertEquals(expectedCat, normalWeight.getCat());

    }

    @Test
    void calcBmiUnderWeight() {

        double expectedBmi = 17.3;
        assertEquals(expectedBmi, underWeight.getBmi());

    }

    @Test
    void categoryUnderWeight() {

        String expectedCat = "Under Weight";
        assertEquals(expectedCat, underWeight.getCat());

    }

    @Test
    void calcBmiNormalWeight() {

        double expectedBmi = 21.6;
        assertEquals(expectedBmi, normalWeight.getBmi());

    }

    @Test
    void categoryNormalWeight() {

        String expectedCat = "Normal Weight";
        assertEquals(expectedCat, normalWeight.getCat());

    }

    @Test
    void calcBmiOverWeight() {

        double expectedBmi = 28.0;
        assertEquals(expectedBmi, overWeight.getBmi());

    }

    @Test
    void categoryOverWeight() {

        String expectedCat = "Over Weight";
        assertEquals(expectedCat, overWeight.getCat());

    }

    @Test
    void calcBmiObese() {

        double expectedBmi = 48.4;
        assertEquals(expectedBmi, obese.getBmi());

    }

    @Test
    void categoryObese() {

        String expectedCat = "Obese";
        assertEquals(expectedCat, obese.getCat());

    }

}