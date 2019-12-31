package GameAlgorithm.FunctionDetechMoving;

import obj.GameBoard;

public class MoveUp {
    public static int moveUp(GameBoard gameBoard, Float posX, Float posY, int saveType, int stateInGame) {
        if(gameBoard.isActive) {

            if(gameBoard.activeX - 1  >= 0) {
                if(gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy != 10 && gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].typeCandy != 10)
                    if(posY > gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].x && posY < (gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].x + 80)
                            && posX > gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].y &&  posX < gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].y + 80 ) {

                        //de-active
                        gameBoard.isActive = false;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].isActived = false;

                        // swap
                        saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].typeCandy;
                        gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].typeCandy = saveType;

                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].x -= 80;
                        gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].x += 80;

                        gameBoard.notDetectUp = true;

                        System.out.println("after swap: ");
                        stateInGame = 1;
                        gameBoard.showMatrix2D();
                    }


            }
        }
        return stateInGame;
    }
}
