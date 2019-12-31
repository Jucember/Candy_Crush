package Game;

import java.util.ArrayList;


import GameAlgorithm.FunctionCandyClicked.DetectCandyClicked;
import GameAlgorithm.FunctionCandyFall.CandyFalling;
import GameAlgorithm.FunctionCandyFall.TestFalling;
import GameAlgorithm.FunctionCheckExplossion.*;
import GameAlgorithm.FunctionDetechMoving.*;
import GameAlgorithm.TextEffect.DeleteText;
import GameAlgorithm.TextEffect.StageString;
import GameAlgorithm.UpdateScore.ScoreUpdate;
import Interface.Stage;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import obj.DrawCandy;
import obj.GameBoard;

import obj.TextEffect;

public class Stage1 extends BasicGameState implements Stage {
    private Image inGame;
    private static GameBoard gameBoard;
    DrawCandy drawCandy;

    // sign game
    private static final String sign = "Stage 1";
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
    // random text score

    // list obj text score and time
    public static ArrayList<TextEffect> textEffectsArr;

    // candy temp
    private static int saveType;
    // boolean variable
    private static boolean isMatching = false;
    private static boolean gameOver = false;
    // state game
    private static int stateInGame = 0;
    // time
    private static int countTime = 0;
    private static int minute = 30;
    // score game
    private static int Score = 0;
    // font define
    private static boolean isSignMoveRight = true;
    private MyFont fontScore;
    private static MyFont fontSign;
    private static MyFont scoreApear;
    private String time;
    // fix bug with boolean variable
    public boolean checkbug = false;


    @Override
    public void init(GameContainer ag, StateBasedGame sbg) throws SlickException {
        // back ground inGame
        inGame = new Image("images/Frosting_Springs_background.jpg");
        // install obj matrix2d
        gameBoard = new GameBoard();
        // install arr obj text effect
        textEffectsArr = new ArrayList<TextEffect>();

        // in stall obj font score
        fontScore = new MyFont("font/1979_dot_matrix.ttf", 25);
        fontSign = new MyFont("font/scoreApear.ttf", 40);
        scoreApear = new MyFont("font/Snowdrift.ttf", 25);

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
        fontScore.myFontDraw(250, 50, scoreString + "    " + time, Color.blue);

        // draw my Sign
        fontSign.myFontDraw(signX, signY, sign, Color.red);
        g.setColor(Color.black);
        // draw candy & text effect
        drawCandy = new DrawCandy();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // make Sign String move
        StageString.SignString(isSignMoveRight, signX);

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
        // detect when mouse hit text score
        Score = ScoreUpdate.collectScore(textEffectsArr, posX, posY, Score);
        // xu li roi candy
        TestFalling.testFalling(gameBoard, checkbug);
        SwapRight.drawSwapRight(gameBoard, checkbug);

        // logic game
        if (stateInGame == 0) {
            DetectCandyClicked.detectClickCandy(gameBoard, isClickLeftMouse, posX, posY);
            detectMove();
        }
        if (stateInGame == 1) {
            checkExplossion();
        }
        if (stateInGame == 2) {
            stateInGame = CandyFalling.Falling(gameBoard, saveType, checkbug, stateInGame);
        }
        if (stateInGame == 3) {
            CheckIsNotDetect.checkIsNotDetect(gameBoard, saveType);
            stateInGame = 0;
        }
        // check game over
        StageCondition(sbg,gc);
        resetWhenGameOver();

    } // end function update

    public void detectMove() {
        stateInGame = MoveRight.moveRight(gameBoard, posX, posY, saveType, stateInGame);
        stateInGame = MoveDown.moveDown(gameBoard, posX, posY, saveType, stateInGame);
        stateInGame = MoveUp.moveUp(gameBoard, posX, posY, saveType, stateInGame);
        stateInGame = MoveLeft.moveLeft(gameBoard, posX, posY, saveType, stateInGame);
    }


    @Override
    public void checkExplossion() {
        // state hien tai = 1
        isMatching = false;
        if (Explossion5X.explossion5X(gameBoard, textEffectsArr)) {
            Score += 50;
            minute += 2;
            isMatching = true;
        }
        ;
        if (Explossion5Y.explossion5Y(gameBoard, textEffectsArr)) {
            Score += 50;
            isMatching = true;
            minute += 2;
        }
        ;
        if (Explossion4X.explossion4X(gameBoard, textEffectsArr)) {
            Score += 40;
            isMatching = true;
        }
        ;
        if (Explossion4Y.explossion4Y(gameBoard, textEffectsArr)) {
            Score += 40;
            isMatching = true;
        }
        ;
        if (Explosion3X.explossion3X(gameBoard, textEffectsArr)) {
            Score += 30;
            isMatching = true;
        }
        ;
        if (Explossion3Y.explossion3Y(gameBoard, textEffectsArr)) {
            Score += 40;
            isMatching = true;
        }
        ;
        if (isMatching) {
            // set false to function checkIsNotDetect
            checkbug = false;
            gameBoard.notDetectRight = false;
            gameBoard.notDetectDown = false;
            gameBoard.notDetectLeft = false;
            gameBoard.notDetectUp = false;
            // chay ham faling
            stateInGame = 2;

        } else {
            checkbug = true;
            // chay ham checkIsNotDetect
            stateInGame = 3;
        }
    }


    @Override
    public void resetWhenGameOver() {
        if (gameOver == true) {
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
    public int getID() {
        return 2;
    }

    @Override
    public void StageCondition(StateBasedGame sbg, GameContainer gc) {
        if ((minute - (countTime / 1000) == 0) && Score < 500) {
            gameOver = true;
            Stage2.setScore(this.Score);
            sbg.enterState(6, new FadeOutTransition(), new FadeInTransition());
        } else if ((minute - (countTime / 1000) == 0) && Score > 500) {
            Stage2.setScore(this.Score);
            sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }
        if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {

            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }

    //GETTER && SETTER

    public static int getScore() {
        return Score;
    }

    public static void setScore(int score) {
        Score = score;
    }

    public static GameBoard getGameBoard() {
        return gameBoard;
    }



    public static MyFont getScoreApear() {
        return scoreApear;
    }
}
