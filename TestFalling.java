package GameAlgorithm.FunctionCandyFall;

import Game.CongfigGame;
import obj.GameBoard;

public class TestFalling {


    public static void testFalling(GameBoard gameBoard, boolean checkbug) {
        if(!checkbug ) {
            for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
                for(int j = 0; j < CongfigGame.getLengthColum(); j++) {
                    if(gameBoard.Board[i][j].isFalling) {
                        if(gameBoard.Board[i][j].x < gameBoard.locateCandy[i][j].x ) {
                            gameBoard.Board[i][j].x += 20;
                        }
                        else if(gameBoard.Board[i][j].x == gameBoard.locateCandy[i][j].x) {
                            gameBoard.Board[i][j].isFalling = false;
                        }
                    }
                }
            }
        }
    }
}
