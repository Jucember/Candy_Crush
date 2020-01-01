package GameAlgorithm.UpdateScore;

import obj.TextEffect;

import java.util.ArrayList;

public class ScoreUpdate {
    public static int collectScore(ArrayList<TextEffect> textEffectsArr, float posX, float posY, int Score) {
        for(TextEffect t : textEffectsArr ) {
            // if mouse hit the text
            if(posX >= t.x && posX <= (t.x + 70) && posY >= t.y && posY <= (t.y  + 70)) {
                t.moveScore = true;
                t.isDestroy = true;
                if(t.typeScore == 3)
                    Score += 30;
                else if(t.typeScore == 4)
                    Score += 40;
                else if(t.typeScore == 5)
                    Score += 50;
            }
        }
        return Score;
    }
}
