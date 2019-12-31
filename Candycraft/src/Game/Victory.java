package Game;

import User.User;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.FileNotFoundException;

import  User.SaveUserScore;

public class Victory extends BasicGameState {
    public Image overGameImage;
    private int score = Stage2.getScore();
    private static int n=1;
    public MyFont myFont;

    public static User user ;


    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        overGameImage = new Image("images/victory.jpg");

        myFont = new MyFont("font/scoreApear.ttf", 50);


    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        overGameImage.draw(0, 0,900,900);
        myFont.myFontDraw(250, 300, "VICTORY!!!", Color.black);
        myFont.myFontDraw(150, 400, "your score: " + score, Color.black);
        myFont.myFontDraw(100, 500, "Press Space to play again !!!", Color.black);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        user = new User(Login.getUserName(),score);
        score = Stage2.getScore();
        if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {

            HighScore.getUserList().add(user);
            try {
                SaveUserScore.saveSocre(HighScore.getUserList());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Stage1.setScore(0);

            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

    }

    @Override
    public int getID() {
        return 9;
    }

}
