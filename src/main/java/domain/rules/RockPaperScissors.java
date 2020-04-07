package domain.rules;

import domain.Move;
import domain.Result;
import domain.Rules;

public class RockPaperScissors implements Rules {
    @Override
    public Result decide(Move mine, Move theirs) {
        if ((mine == Move.ROCK && theirs == Move.SCISSORS) ||
                (mine == Move.SCISSORS && theirs == Move.PAPER) ||
                    (mine == Move.PAPER && theirs == Move.ROCK)) {
            return Result.WIN;
        } else if ((mine == Move.ROCK && theirs == Move.ROCK) ||
                        (mine == Move.SCISSORS && theirs == Move.SCISSORS) ||
                            (mine == Move.PAPER && theirs == Move.PAPER)) {
            return Result.DRAW;
        } else {
            return Result.LOSE;
        }
    }
}
