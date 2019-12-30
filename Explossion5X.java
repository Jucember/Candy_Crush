package GameAlgorithm.FunctionCheckExplossion;

import Game.CongfigGame;
import obj.GameBoard;
import obj.TextEffect;

import java.util.ArrayList;
import java.util.Random;

public class Explossion5X {
    public static Random random = new Random();

    static public boolean explossion5X(GameBoard gameBoard, ArrayList<TextEffect> textEffectsArr) {
        int n=0;
        for(int i = 0; i < CongfigGame.getLengthColum(); i++) {
            for(int j = 0; j < CongfigGame.getLengthRow(); j++) {
                if(gameBoard.Board[i][j].typeCandy != 10) {
                    if((j + 4) < CongfigGame.getLengthColum()) {
                        if(gameBoard.Board[i][j].typeCandy == gameBoard.Board[i][j + 1].typeCandy && gameBoard.Board[i][j].typeCandy == gameBoard.Board[i][j + 2].typeCandy &&
                                gameBoard.Board[i][j].typeCandy == gameBoard.Board[i][j + 3].typeCandy  && gameBoard.Board[i][j].typeCandy == gameBoard.Board[i][j + 4].typeCandy ) {
                            AddText.addtext(random.nextFloat() * 810, random.nextFloat() * (894 - 150 ) + 150 , gameBoard.Board[i][j].typeCandy, 5, "50 Scoreee", 5, textEffectsArr);
                            AddText.addtext(500, 50 , gameBoard.Board[i][j].typeCandy, 1, "+ 2 second", 0, textEffectsArr);

                            for(int k = 0; k < 5; k++) {
                                gameBoard.Board[i][j + k].typeCandy = 10;
                            }
                            System.out.println(" find  match 5X at" + i + " " + j);

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
