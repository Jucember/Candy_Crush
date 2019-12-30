package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetUserScore {
    public static ArrayList retrieveScore() throws FileNotFoundException {
        ArrayList<User> list= new ArrayList<>();
        Scanner sc = new Scanner(new File("HighScore.txt"));
        while(sc.hasNext()) {
            User user= new User();
            user.setName(sc.nextLine());
            user.setScore(Integer.parseInt(sc.nextLine()));
            list.add(user);
        }
        sc.close();
        return list;
    }
}
