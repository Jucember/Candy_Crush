package GameAlgorithm.FunctionCheckExplossion;

import Game.CongfigGame;
import obj.GameBoard;
import obj.TextEffect;

import java.util.ArrayList;
import java.util.Random;

public class Explosion3X {

    public static Random random = new Random();


    static public boolean explossion3X(GameBoard gameBoard, ArrayList<TextEffect> textEffectsArr) {
        // search board
        int n=0;
        for(int i = 0; i < CongfigGame.getLengthColum(); i++) {
            for(int j = 0; j < CongfigGame.getLengthRow(); j++) {
                if(gameBoard.Board[i][j].typeCandy != 10) {
                    if((j + 2) < CongfigGame.getLengthRow()) {
                        // neu tim duoc 1 day 3 candy trung nhau
                        if(gameBoard.Board[i][j].typeCandy == gameBoard.Board[i][j + 1].typeCandy && gameBoard.Board[i][j].typeCandy == gameBoard.Board[i][j + 2].typeCandy ) {
                            // add text score
                            AddText.addtext(random.nextFloat() * 810, random.nextFloat() * (894 - 150 ) + 150 , gameBoard.Board[i][j].typeCandy, 5, "30 Score", 3,textEffectsArr);
                            AddText.addtext(500, 50 , gameBoard.Board[i][j].typeCandy, 1, "+ 2 second", 0,textEffectsArr);

                            // danh dau
                            for(int k = 0 ; k < 3; k++) {
                                gameBoard.Board[i][j + k].typeCandy = 10;
                            }
                            System.out.println("match 3X at: " + i + " " + j);
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
