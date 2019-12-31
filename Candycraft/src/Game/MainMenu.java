package Game;

import org.lwjgl.input.Mouse;
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
public class MainMenu extends BasicGameState {
	private Image imgMainMenu;
	private Image imScore;
    private Image play;
    private Image highScore;
	MyFont fontSign;

    String mouse = "No Input!";

	@Override
	public void init(GameContainer ag, StateBasedGame sbg) throws SlickException {
		imgMainMenu = new Image("images/mainMenu.jpg");

		imScore = new Image("images/menu.png");
		fontSign = new MyFont("font/scoreApear.ttf", 40);

		play =new Image("images/play-512.png");
        highScore = new Image("images/hs1.png");

	}

	@Override
	public void render(GameContainer ag, StateBasedGame sbg, Graphics g) throws SlickException {
		imgMainMenu.draw(0, 0);
		imScore.draw(400,400);

        play.draw(600,400,150,150);
        highScore.draw(600,550,150,150);
        fontSign.myFontDraw(50,50,mouse,Color.black);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

	    int xpos = Mouse.getX();
        int ypos = Mouse.getY();
		if ( (xpos>600)&&(xpos<750) && (ypos>400) && (ypos<550)) {
            if(Mouse.isButtonDown(0)){
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}}
		else if( (xpos>600)&&(xpos<750) && (ypos>250) && (ypos<400)){
            if(Mouse.isButtonDown(0)){
			sbg.enterState(8,new FadeOutTransition(), new FadeInTransition());
		}}
	}
	@Override
	public int getID() {
		return 1;
	}
	
	
}
