package GameAlgorithm.FunctionCheckExplossion;

import Game.CongfigGame;
import obj.GameBoard;
import obj.TextEffect;

import java.util.ArrayList;
import java.util.Random;

public class Explossion3Y {
    public static Random random = new Random();

    public static boolean explossion3Y(GameBoard gameBoard, ArrayList<TextEffect> textEffectsArr) {
        // search the board
        int n=0;
        for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
            for(int j = 0; j < CongfigGame.getLengthColum(); j++) {
                if(gameBoard.Board[i][j].typeCandy != 10) {
                    if((i + 2) < CongfigGame.getLengthColum()) {
                        if(gameBoard.Board[i][j].typeCandy == gameBoard.Board[i + 1][j].typeCandy && gameBoard.Board[i][j].typeCandy == gameBoard.Board[i + 2][j].typeCandy ) {
                            AddText.addtext(random.nextFloat() * 810, random.nextFloat() * (894 - 150 ) + 150 , gameBoard.Board[i][j].typeCandy, 5, "30 Score", 3,textEffectsArr);
                            // set type 10 for all match candy
                            for(int k = 0 ; k < 3; k++) {
                                gameBoard.Board[i + k][j].typeCandy = 10;
                            }
                            // console
                            System.out.println("match 3Y at " + i + " " + j);
                            n=1;
                            return true;
                        }
                    }
                }
            }
        }
        if(n==1){
            return true;
        } else
            return false;
    }


}
