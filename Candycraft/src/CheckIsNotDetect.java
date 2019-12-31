package GameAlgorithm.FunctionDetechMoving;

import obj.GameBoard;

public class CheckIsNotDetect {
    public static boolean checkIsNotDetect(GameBoard gameBoard, int saveType ) {
        if(gameBoard.notDetectRight) {
            System.out.println("RIGHT!!!!!!!!!!!!!!!");
            saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
            gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].typeCandy;
            gameBoard.Board[gameBoard.activeX][gameBoard.activeY + 1].typeCandy = saveType;
            gameBoard.notDetectRight = false;
        }

        if(gameBoard.notDetectLeft) {
            saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
            gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].typeCandy;
            gameBoard.Board[gameBoard.activeX][gameBoard.activeY - 1].typeCandy = saveType;
            gameBoard.notDetectLeft = false;
        }
        if(gameBoard.notDetectUp) {
            saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
            gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].typeCandy;
            gameBoard.Board[gameBoard.activeX - 1][gameBoard.activeY].typeCandy = saveType;
            gameBoard.notDetectUp = false;
        }

        if(gameBoard.notDetectDown) {
            saveType = gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy;
            gameBoard.Board[gameBoard.activeX][gameBoard.activeY].typeCandy = gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].typeCandy;
            gameBoard.Board[gameBoard.activeX + 1][gameBoard.activeY].typeCandy = saveType;
            gameBoard.notDetectDown = false;
        }
        System.out.println("Not detect match!!!!");
        gameBoard.showMatrix2D();

        return gameBoard.notDetectDown;
    }

}
