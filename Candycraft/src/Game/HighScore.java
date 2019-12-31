package Game;

import User.GetUserScore;
import User.User;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import User.SortHighScore;

public class HighScore extends BasicGameState {
    private Image background;
    private static ArrayList<User> userList;
    MyFont fontScore;
    MyFont fontSign;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        background = new Image("images/candybk.jfif");
        fontSign = new MyFont("font/scoreApear.ttf", 40);
        fontScore = new MyFont("font/1979_dot_matrix.ttf", 25);


        try {
            userList = GetUserScore.retrieveScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbc, Graphics graphics) throws SlickException {
        background.draw(0,0);
        fontSign.myFontDraw(300,150,"High Score!!",Color.red);
        int i=1;
        userList= SortHighScore.sortScore(userList);

        for (User user :userList) {
            fontScore.myFontDraw(100, 200 + i * 50, i + "--" + user.getName() + "......" + user.getScore(), Color.black);
            i++;
            if (i > 10)
                break;
        }
        fontSign.myFontDraw(200,850,"Press Space to Go Back. ", Color.magenta);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }
    @Override
    public int getID() {
        return 8;
    }

    public static ArrayList<User> getUserList() {
        return HighScore.userList;
    }

    public static void setUserList(ArrayList<User> userList) {
        HighScore.userList = userList;
    }
}
