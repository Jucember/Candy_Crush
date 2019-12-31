package Game;

import GameAlgorithm.FunctionCandyClicked.DetectCandyClicked;
import GameAlgorithm.FunctionCandyFall.CandyFalling;
import GameAlgorithm.FunctionCandyFall.TestFalling;
import GameAlgorithm.FunctionCheckExplossion.*;
import GameAlgorithm.FunctionDetechMoving.*;
import GameAlgorithm.TextEffect.DeleteText;
import GameAlgorithm.UpdateScore.ScoreUpdate;
import Interface.Stage;
import obj.DrawCandy;
import obj.GameBoard;
import obj.TextEffect;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;

public class Stage2 extends BasicGameState implements Stage {
	private Image inGame;
	private static GameBoard gameBoard;
	DrawCandy drawCandy;
	
	// sign game
	private static final String sign = "Stage 2";
	private static float signX = 81;
	private float signY = 118;
	
	// draw mouse pos to debug game
	String mouse = "No Input!";
	String scoreString = "No";
	
	// is click left mouse
	private static boolean isClickLeftMouse;
	
	// position of mouse
	private static float posX;
	private static float posY;

	// list obj text score and time
	private static ArrayList<TextEffect> textEffectsArr;

	// candy temp
	private static int saveType;
	
	// boolean variable
	private static boolean isMatching = false;
	private static boolean gameOver = false;
	
	// state game
	private int stateInGame = 0;
	
	// time
	private static int countTime = 0;
	private static int minute = 25;

	// score game
	private static int Score = Stage1.getScore();
	
	
	// font define	
	private boolean isSignMoveRight = true;
	private MyFont fontScore;
	private static MyFont fontSign;
	private static MyFont scoreApear;
	private String time;

	// fix bug with boolean variable
	public boolean checkbug = false;

	@Override
	public void init(GameContainer ag, StateBasedGame sbg) throws SlickException {
		
		// back ground inGame
		inGame = new Image("images/inGame2.jpg");
		
		// install obj matrix2d
		gameBoard = new GameBoard();
		
		// install arr obj text effect
		textEffectsArr = new ArrayList<TextEffect>();
		
		// in stall obj font score
		fontScore = new MyFont("font/1979_dot_matrix.ttf", 25);
		fontSign = new MyFont("font/scoreApear.ttf", 40);
		scoreApear = new MyFont("font/Snowdrift.ttf", 25 );

	}


	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// draw a background behind candy
		g.setColor(Color.white);
        g.fillRect(0, 0, 900, 900);
        inGame.draw(0, 0);
        g.setColor(new Color(0, 0, 70, 100));
        g.fillRoundRect(80, 140, 730, 730, 30, 30);

		// draw Score & Time 
		fontScore.myFontDraw(250, 50,  scoreString + "    " + time , Color.blue);
		
		// draw my Sign
		fontSign.myFontDraw(signX, signY, sign, Color.red);
		
		g.setColor(Color.black);
		
	    g.drawString(mouse, 50, 50);
		// draw candy & text effect
		drawCandy = new DrawCandy();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		// make Sign String move
		if(isSignMoveRight == true) {
			signX +=0.5f;
			//System.out.println(signX);
			if(signX == 635.0) {
				isSignMoveRight =  false;
			}
		}
		else {
			signX -= 0.5f;
			if(signX == 81) {
				isSignMoveRight = true;
			}
		}
		countTime += delta;
		// tao hieu ung dem nguoc
		time = "Time:  " + (minute - (countTime / 1000));
		
		// update score
		scoreString = "Score: " + Score; 

		// update postion of mouse 
		posX = gc.getInput().getMouseX();
		posY = gc.getInput().getMouseY();
		mouse = "X:" + posX + "Y:" + posY; 
		
		// set true when mouse clicking
		isClickLeftMouse = gc.getInput().isMousePressed(0);
		
		// delete text 
		DeleteText.deleteText(textEffectsArr);
		// Score
		Score = ScoreUpdate.collectScore(textEffectsArr, posX, posY,Score);
		
		// xu li roi candy
		TestFalling.testFalling(gameBoard,checkbug);
		
		SwapRight.drawSwapRight(gameBoard,checkbug);
		
		
		// logic game

		if(stateInGame == 0) {
			DetectCandyClicked.detectClickCandy(gameBoard, isClickLeftMouse,posX, posY);
			detectMove();
		}

		if(stateInGame == 1) {
			checkExplossion();
		}
		if(stateInGame == 2) {
			stateInGame=CandyFalling.Falling(gameBoard,saveType,checkbug,stateInGame);
		}
		if(stateInGame == 3) {
			CheckIsNotDetect.checkIsNotDetect(gameBoard, saveType);
			stateInGame=0;
		}
        StageCondition(sbg, gc);
		resetWhenGameOver();

	} // end function update

public void detectMove() {
		stateInGame= MoveRight.moveRight(gameBoard, posX, posY,saveType, stateInGame);
		stateInGame= MoveDown.moveDown(gameBoard, posX, posY,saveType, stateInGame);
		stateInGame= MoveUp.moveUp(gameBoard, posX, posY,saveType, stateInGame);
		stateInGame= MoveLeft.moveLeft(gameBoard, posX, posY,saveType, stateInGame);

}

	public void checkExplossion() {
		// state hien tai = 1
		isMatching = false;

		if(Explossion5X.explossion5X(gameBoard, textEffectsArr)){
			Score+=40;
			isMatching=true;
		};
		if(Explossion5Y.explossion5Y(gameBoard,  textEffectsArr)){
			Score+=50;isMatching=true;
		};
		if(Explossion4X.explossion4X(gameBoard,  textEffectsArr)){
			Score+=40;isMatching=true;
		};
		if(Explossion4Y.explossion4Y(gameBoard, textEffectsArr)){
			Score+=40;isMatching=true;
		};
		if(Explosion3X.explossion3X(gameBoard, textEffectsArr)){
			Score+=30;isMatching=true;
		};
		if(Explossion3Y.explossion3Y(gameBoard, textEffectsArr)){
			Score+=40;isMatching=true;
		};
		if(isMatching) {
			// set false to function checkIsNotDetect
			checkbug = false;
			gameBoard.notDetectRight = false;
			gameBoard.notDetectDown = false;
			gameBoard.notDetectLeft = false;
			gameBoard.notDetectUp = false;
			// chay ham faling
			stateInGame = 2;

		}
		else {
			checkbug = true;
			// chay ham checkIsNotDetect
			stateInGame = 3;
		}
	}


@Override
	public void resetWhenGameOver() {
		if(gameOver == true) {
			//Score = 0;
			isMatching = false;
			signX = 0;
			countTime = 0;
			minute = 60;
			try {
				gameBoard = new GameBoard();
			} catch (SlickException e) {
				e.printStackTrace();
			}
			gameOver = false;
			
		}
	}



	@Override
	public void StageCondition(StateBasedGame sbg, GameContainer gc) {

		// check game over
		if((minute - (countTime / 1000) == 0)&& Score<1000) {
			gameOver = true;
			sbg.enterState(6, new FadeOutTransition(), new FadeInTransition());
		}
		else if((minute - (countTime / 1000) == 0) && Score>=1000){
			sbg.enterState(9, new FadeOutTransition(), new FadeInTransition());
		}

	}


	@Override
	public int getID() {
		return 3;
	}

	public static int getScore() {
		return Score;
	}

	public static void setScore(int score) {
		Score = score;
	}
}
