package Game;

import User.User;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	// App Properties
	
	private static int WIDTH = 900;
	private static int HEIGHT = 900;
	private static final int FPS = 60;

	// Constructor
	
	public Game(String appName) {
		super(appName);
	}
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Login());
		addState(new MainMenu());
		addState(new HighScore());
		addState(new Stage1());
		addState(new Stage2());
		addState(new GameOver());
		addState(new Victory());
	}
	// Main
	public static void main(String[] args) {	
		try {
			
			AppGameContainer appGameContainer = new AppGameContainer(new Game("CandyCrush Project"));
			appGameContainer.setDisplayMode(WIDTH, HEIGHT, false);
			appGameContainer.setTargetFrameRate(FPS);
			appGameContainer.setShowFPS(true);
			appGameContainer.start();
		} 
		catch (SlickException e) {
			e.printStackTrace();
		}

	}
}
