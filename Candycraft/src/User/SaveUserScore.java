package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveUserScore {
        public static void saveSocre(ArrayList<User> list) throws FileNotFoundException {

            PrintWriter pw = new PrintWriter(new File("HighScore.txt"));
            for (User user : list){
                pw.println(user.getName());
                pw.println(user.getScore());
            }
            pw.close();

        }

}
