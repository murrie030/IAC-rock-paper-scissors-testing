package domain;

import domain.rules.RockPaperScissors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsTest {

    // The next three tests are results into WIN
    // These are the specific test cases
//    @Test
//    @DisplayName("Rock crushes scissors")
//    void rockCrushesScissors(){
//        Rules game = new RockPaperScissors();
//        Result result = game.decide(Move.ROCK, Move.SCISSORS);
//        assertEquals(result.WIN, result);
//    }
//
//    @Test
//    @DisplayName("Scissor cuts paper")
//    void scissorCutsPaper(){
//        Rules game = new RockPaperScissors();
//        Result result = game.decide(Move.SCISSORS, Move.PAPER);
//        assertEquals(result.WIN, result);
//    }
//
//    @Test
//    @DisplayName("Paper covers rock")
//    void paperCoversRock(){
//        Rules game = new RockPaperScissors();
//        Result result = game.decide(Move.PAPER, Move.ROCK);
//        assertEquals(result.WIN, result);
//    }

    // Now the Parameterized Tests will take place
    private static Stream<Arguments> provideMovesAndResults(){
        return Stream.of(
                Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
                Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),
                Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),

                Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),
                Arguments.of(Move.PAPER, Move.PAPER, Result.DRAW),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.DRAW),

                Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE),
                Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE),
                Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    void verifyMovesAndResult(Move mine, Move theirs, Result expectedResult){
        Rules game = new RockPaperScissors();
        Result result = game.decide(mine, theirs);
        assertEquals(expectedResult, result);
    }
}
