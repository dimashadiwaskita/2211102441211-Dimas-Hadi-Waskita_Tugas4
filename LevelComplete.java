import greenfoot.*;

public class LevelComplete extends Actor {
    private int level;

    public LevelComplete(int level) {
        this.level = level;
        GreenfootImage image = new GreenfootImage("Level " + level + " Complete", 36, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
