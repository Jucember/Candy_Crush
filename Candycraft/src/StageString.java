package GameAlgorithm.TextEffect;

public class StageString {
    public static void SignString(boolean isSignMoveRight, float signX){
        if(isSignMoveRight == true) {
            signX +=0.5f;
            //System.out.println(signX);
            if(signX == 635.0) {
                isSignMoveRight =  false;
            }
        }
        else {
            signX -= 0.5f;
            if(signX == 81) {
                isSignMoveRight = true;
            }
        }
    }
}
