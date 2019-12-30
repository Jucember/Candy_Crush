package Interface;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public interface Stage {
   void StageCondition(StateBasedGame sbg, GameContainer gc);

   void checkExplossion();

   void resetWhenGameOver();
}
