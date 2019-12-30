package User;

public class User implements Comparable<User>{
    private String name;
    private int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public User(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public  int compareTo(User user) {
        return (this.getScore()>user.getScore() ?-1 :
                (this.getScore()==user.getScore() ? 0:1));
    }


}
