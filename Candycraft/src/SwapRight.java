package GameAlgorithm.FunctionDetechMoving;

import Game.CongfigGame;
import obj.GameBoard;

public class SwapRight {

    public static void drawSwapRight(GameBoard gameBoard, boolean checkbug) {
        if(checkbug)
            for(int i = 0; i < CongfigGame.getLengthRow() ; i++) {
                for(int j = 0; j < CongfigGame.getLengthColum(); j ++) {
                    if(gameBoard.Board[i][j].y > gameBoard.locateCandy[i][j].y) {
                        gameBoard.Board[i][j].y -= 10;
                    }

                    if(gameBoard.Board[i][j].y < gameBoard.locateCandy[i][j].y) {
                        gameBoard.Board[i][j].y += 10;
                    }

                    if(gameBoard.Board[i][j].x < gameBoard.locateCandy[i][j].x) {
                        gameBoard.Board[i][j].x += 10;
                    }

                    if(gameBoard.Board[i][j].x > gameBoard.locateCandy[i][j].x) {
                        gameBoard.Board[i][j].x -= 10;
                    }
                }
            }
    }





}
