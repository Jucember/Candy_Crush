package Game;

import User.GetUserScore;
import User.SaveUserScore;
import User.User;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Login extends BasicGameState {
    public static TextField textfield;
    private Image image;
    private Image submit;
    private static String userName;

    @Override
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {
    image = new Image("images/LOGIN.jpg");
    textfield = new TextField(gc, gc.getDefaultFont(), 300, 350, 300, 40);
    submit = new Image("images/enter.png");

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbs, Graphics g) throws SlickException {

    image.draw(0,0);
    textfield.render(gc, g);
    submit.draw(380,420);


    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int i) throws SlickException {
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();


        if( (xpos > 360) && (xpos < 460) && (ypos > 380) && (ypos < 460) ) {

            if(Mouse.isButtonDown(0)) {
                setUserName(textfield.getText());
                stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
                System.out.print(getUserName());
            }

        }
    }
    @Override
    public int getID() {
        return 0;
    }

    public static TextField getTextfield() {
        return textfield;
    }

    public static void setTextfield(TextField textfield) {
        Login.textfield = textfield;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Login.userName = userName;
    }
}
