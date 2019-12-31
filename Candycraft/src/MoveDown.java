package GameAlgorithm.FunctionDetechMoving;

import Game.CongfigGame;
import obj.GameBoard;

public class MoveDown {
    public static int moveDown(GameBoard gameBoard, Float posX, Float posY, int saveType, int stateInGame) {
        if(gameBoard.isActive) {
            if(gameBoard.activeX + 1  <= CongfigGame.getLengthRow() - 1) {
                if(gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy != 10 && gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].typeCandy != 10)
                    if(posY > gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].x && posY < (gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].x + 80)
                            && posX > gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].y &&  posX < gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].y + 80 ) {

                        //de-active
                        gameBoard.isActive = false;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].isActived = false;


                        saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].typeCandy;
                        gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].typeCandy = saveType;

                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].x += 80;
                        gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].x -= 80;

                        gameBoard.notDetectDown = true;
                        System.out.println("after swap: ");
                        stateInGame = 1;
                        gameBoard.showMatrix2D();

                    }


            }
        }
        return stateInGame;
    }
}
