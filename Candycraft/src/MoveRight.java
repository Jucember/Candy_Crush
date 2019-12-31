package GameAlgorithm.FunctionDetechMoving;

import Game.CongfigGame;
import obj.GameBoard;

public class MoveRight {
    public static int moveRight(GameBoard gameBoard, Float posX, Float posY, int saveType, int stateInGame) {
        // check candy is active?
        if(gameBoard.isActive) {
            // check is hit the end of colum
            if(gameBoard.activeY  + 1  <= CongfigGame.getLengthColum() - 1) {
                // check xem candy va candy ben phai no co dang falling hay ko
                if(gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy != 10 && gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].typeCandy != 10)
                    // if mouse hit the right candy
                    if(posY > gameBoard.Board[gameBoard.activeX ][gameBoard.activeY + 1].x && posY < (gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].x + 80)
                            && posX > gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].y &&  posX < gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].y + 80 ) {

                        //de-active
                        gameBoard.isActive = false;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].isActived = false;

                        // swap candy
                        saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].typeCandy;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].typeCandy = saveType;

                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].y += 80;
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].y -= 80;
                        gameBoard.notDetectRight = true;
                        // move to detect candy
                        stateInGame = 1;
                        // console
                        System.out.println("after swap: ");
                        gameBoard.showMatrix2D();

                    }

            }
        }
        return stateInGame;
    }
}
