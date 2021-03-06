package GameAlgorithm.FunctionCheckExplossion;

import Game.CongfigGame;
import obj.GameBoard;
import obj.TextEffect;

import java.util.ArrayList;
import java.util.Random;

public class Explossion4Y {
    public static Random random = new Random();

    static public boolean explossion4Y(GameBoard gameBoard, ArrayList<TextEffect> textEffectsArr) {
        int n=0;
        for(int i = 0; i < CongfigGame.getLengthColum(); i++) {
            for(int j = 0; j < CongfigGame.getLengthRow(); j++) {
                if(gameBoard.Board[i][j].typeCandy != 10) {
                    if((i + 3) < CongfigGame.getLengthColum()) {
                        if(gameBoard.Board[i][j].typeCandy == gameBoard.Board[i + 1][j].typeCandy && gameBoard.Board[i][j].typeCandy == gameBoard.Board[i + 2][j].typeCandy && gameBoard.Board[i][j].typeCandy == gameBoard.Board[i + 3][j].typeCandy) {
                            AddText.addtext(random.nextFloat() * 810, random.nextFloat() * (894 - 150 ) + 150 , gameBoard.Board[i][j].typeCandy, 5, "40 Scoreee", 4,textEffectsArr);


                            for(int k = 0; k < 4; k++) {
                                gameBoard.Board[i + k][j].typeCandy = 10;
                            }
                            System.out.println("match 4Y at:  " + i + " " + j);

                            n=1;
                            return true;
                        }
                    }
                }
            }
        }if(n==1){
            return true;
        } else
            return false;
    }
}
