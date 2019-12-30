package GameAlgorithm.FunctionCandyFall;

import Game.CongfigGame;
import obj.Candy;
import obj.GameBoard;

public class CandyFalling {


    public static int Falling(GameBoard gameBoard, int saveType, boolean checkbug, int stateInGame) {


        if(!checkbug) {
            boolean rp = false;
            for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
                for(int j = 0; j <	CongfigGame.getLengthColum(); j++) {
                    if(gameBoard.Board[i][j].typeCandy != 10) {
                        if((i + 1 ) < CongfigGame.getLengthRow() ) {
                            if(gameBoard.Board[i + 1][j].typeCandy == 10) {
                                saveType = gameBoard.Board[i][j].typeCandy;
                                gameBoard.Board[i][j].typeCandy = gameBoard.Board[i + 1][j].typeCandy;
                                gameBoard.Board[i + 1][j].typeCandy = saveType;

                                gameBoard.Board[i + 1][j].x = gameBoard.Board[i][j].x;
                                gameBoard.Board[i + 1][j].isFalling = true;
                                rp = true;
                                gameBoard.showMatrix2D();
                            }
                        }
                    }
                }
            }


            for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
                for(int j = 0; j < CongfigGame.getLengthColum(); j++) {
                    if(gameBoard.Board[i][j].typeCandy == 10) {
                        if(i == 0) {
                            gameBoard.Board[i][j].x = 70;
                            gameBoard.Board[i][j].isFalling = true;
                            gameBoard.Board[i][j].typeCandy = Candy.getTypeCandy();
                            System.out.println("Add new random candy at "+ i + " " + j);
                            rp = true;
                            gameBoard.showMatrix2D();
                        }

                    }
                }
            }

            if(rp ) {
                Falling(gameBoard,saveType,  checkbug, stateInGame);
            }
            stateInGame = 1;
            System.out.println("falling!!!");
        }
        return stateInGame;
    }
}
