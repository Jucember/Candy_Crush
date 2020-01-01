package GameAlgorithm.TextEffect;

import Game.Stage1;
import obj.TextEffect;

import java.util.ArrayList;

public class DeleteText {
    public static void deleteText(ArrayList<TextEffect> textEffectsArr) {
        boolean rp = false;
        for(TextEffect t : textEffectsArr ) {
            if(t.isDestroy) {
                textEffectsArr.remove(t);
                rp = true;
                break;
            }
        }
        if(rp) {
            deleteText(textEffectsArr);
        }
    }
}
