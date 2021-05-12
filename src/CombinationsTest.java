import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {

    Combinations comp = new Combinations();


    @Test
    @DisplayName("Test")
    public void nOfAKind() {
        int[] array = new int[]{3,3,3,3,3};
        int testPass = comp.nOfAKind(array,3);

        assertEquals(9,testPass);
    }



}