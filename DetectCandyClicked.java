package GameAlgorithm.FunctionCandyClicked;

import Game.CongfigGame;
import obj.GameBoard;

public class DetectCandyClicked {
    public static void detectClickCandy(GameBoard gameBoard, boolean isClickLeftMouse, float posX, float posY){
        for(int i = 0; i <= CongfigGame.getLengthRow(); i++) {
            for(int j = 0; j < CongfigGame.getLengthColum(); j ++) {
                if(isClickLeftMouse) {
                    if(posX > 95 + 80 * j && posX < 95 + 80 + 80 * j && posY > 150 + 80 * i && posY < 230 + 80 * i) {
                        gameBoard.Board[gameBoard.activeX][gameBoard.activeY].isActived = false;
                        gameBoard.Board[i][j].isActived = true;
                        gameBoard.isActive = true;
                        gameBoard.activeX = i;
                        gameBoard.activeY = j;
                    }
                }
            }
        }
    }
}
