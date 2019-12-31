package Game;

import User.User;
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

import User.SaveUserScore;

import java.io.FileNotFoundException;

public class GameOver extends BasicGameState{
	public Image overGameImage;

	private int score= Stage2.getScore();;
	
	public MyFont myFont;
	
	// debug mouse
	private int posX;
	private int posY;
	private static User user;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		overGameImage = new Image("images/gameover.jpg");
		myFont = new MyFont("font/scoreApear.ttf", 50);


	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		overGameImage.draw(0, 0);
		myFont.myFontDraw(250, 400, "GAME OVER !!!", Color.black);
		myFont.myFontDraw(150, 500, "your score: " + score, Color.black);
		myFont.myFontDraw(100, 600, "Press Space to play again !!!", Color.black);



	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		score = Stage2.getScore();

		user = new User(Login.getUserName(),score);

		if(gc.getInput().isKeyDown(Input.KEY_SPACE)) {
			Stage1.setScore(0);
			HighScore.getUserList().add(user);
			try {
				SaveUserScore.saveSocre(HighScore.getUserList());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
	}

	@Override
	public int getID() {
		return 6;
	}
	
}
