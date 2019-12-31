package GameAlgorithm.FunctionDetechMoving;

import obj.GameBoard;

public class MoveLeft {
    public static int moveLeft(GameBoard gameBoard, Float posX, Float posY, int saveType, int stateInGame) {
        // check candy is active?
        if(gameBoard.isActive) {
            // check is hit the begin of colum
            if(gameBoard.activeY - 1 >= 0) {
                // check xem candy va candy ben trai no co dang falling hay ko
                if(gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy != 10 && gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].typeCandy != 10)
                    // if the mouse hit the left candy
                    if(posY > gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].x && posY < (gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].x + 80)
                            && posX > gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].y &&  posX < gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].y + 80 ) {


                        //de-active
                        gameBoard.isActive = false;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].isActived = false;

                        // swap candy
                        saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].typeCandy;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].typeCandy = saveType;

                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].y -= 80;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].y += 80;

                        gameBoard.notDetectLeft = true;

                        stateInGame = 1;
                        System.out.println("after swap: ");
                        gameBoard.showMatrix2D();
                    }


            }
        }
        return stateInGame;
    }
}
