package obj;

import java.util.ArrayList;

import Interface.Stage;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Game.CongfigGame;
import Game.Stage1;

public class DrawCandy {

	public GameBoard gameBoard;
	public ArrayList<TextEffect> textEffectArr;
	public Image cdImg;
	Stage stage;
	public DrawCandy() throws SlickException {
		this.gameBoard = Stage1.getGameBoard();
		this.textEffectArr = Stage1.textEffectsArr;
		// candy
		 for(int i = 0; i < CongfigGame.getLengthRow(); i++) {
			 for(int j = 0; j < CongfigGame.getLengthColum(); j++) {
				 if(gameBoard.Board[i][j].x >= 145) {
					 boolean isClicked = gameBoard.Board[i][j].isActived;
					 if(!isClicked) {
						 myDraw(i, j);
					 }
					 else if(isClicked ) {
						 mydrawClicked(i, j);
					 }
					 
				 }
				
			 }
		 }
		 // score appear
		
		 for(TextEffect textEffect : Stage1.textEffectsArr) {
			textEffect.update();
			if(textEffect.typeTextEffect == 0) {
				Stage1.getScoreApear().myFontDraw(textEffect.x, textEffect.y, textEffect.str, Color.green);
			}
			if(textEffect.typeTextEffect == 1) {
				Stage1.getScoreApear().myFontDraw(textEffect.x, textEffect.y, textEffect.str, Color.blue);
			}
			if(textEffect.typeTextEffect == 2) {
				Stage1.getScoreApear().myFontDraw(textEffect.x, textEffect.y, textEffect.str, Color.yellow);
			}
			if(textEffect.typeTextEffect == 3) {
				Stage1.getScoreApear().myFontDraw(textEffect.x, textEffect.y, textEffect.str, Color.orange);
			}
			if(textEffect.typeTextEffect == 4) {
				Stage1.getScoreApear().myFontDraw(textEffect.x, textEffect.y, textEffect.str, Color.lightGray);
			}
			if(textEffect.typeTextEffect == 5) {
				Stage1.getScoreApear().myFontDraw(textEffect.x, textEffect.y, textEffect.str, Color.red);
			}
			
			
		 }
		 
		 
	}
	public void getImg(int i, int j) throws SlickException {
		int n = gameBoard.Board[i][j].typeCandy;
		if(n<10)
		{

		if(n == 5 ) {
			cdImg = new Image("images/Redcandy.png");
		}
		else if(n == 1) {
			cdImg = new Image("images/blueCandy.png");
		}
		else if(n == 0) {
			cdImg = new Image("images/Greencandy.png");
		}
		else if(n == 2) {
			cdImg = new Image("images/Yellowcandy.png");
		}
		else if(n == 3) {
			cdImg = new Image("images/Orangecandy.png");
		}
		else if(n == 4) {
			cdImg = new Image("images/Lightbluecandy.png");
		}
	}
}
	
	public void myDraw(int i, int j) throws SlickException {
		getImg(i, j);
		cdImg.draw( gameBoard.Board[i][j].y , gameBoard.Board[i][j].x);
	}
	
	public void mydrawClicked(int i, int j) throws SlickException {
		getImg(i, j);
		cdImg.draw( gameBoard.Board[i][j].y , gameBoard.Board[i][j].x, Color.gray);
	}
}
