package GameAlgorithm.FunctionCheckExplossion;

import obj.TextEffect;

import java.util.ArrayList;

public class AddText {
    public static void addtext(float x, float y, int type, float moveSpeedY, String text, int typeScore, ArrayList<TextEffect> textEffectsArr) {
        textEffectsArr.add(new TextEffect(x, y, type, moveSpeedY, text, typeScore));
    }
}
