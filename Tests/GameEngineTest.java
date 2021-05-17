import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {
GameEngine gEngine = new GameEngine();
    Dice [] diceRoll = new Dice[5];
    @Test
    void changeNumberOfDiceArray() {
        Arrays.toString(diceRoll);
        gEngine.changeNumberOfDiceArray(diceRoll);
        Arrays.toString(diceRoll);
    }
}