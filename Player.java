import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor {
    private int score = 0;
    private boolean isCollided = false; // Menambahkan variabel untuk melacak tabrakan

    public Player() {
        setImage("snake2.png");
    }

    public void act() {
        move(3); // Pergerakan default

        // Menerima masukan dari tombol panah
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 10, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
        }

        checkForCollision();
    }

    public void checkForCollision() {
        if (!isCollided) { // Periksa apakah objek sudah pernah dihitung
            Actor object = getOneIntersectingObject(ObjectSpecial.class);
            if (object != null) {
                increaseScore();
                getWorld().removeObject(object);
                isCollided = true; // Tandai objek sudah dihitung
            }
        }
    }

    public void increaseScore() {
        score += 10;
        getWorld().showText("score: " + score, 50, 25);
    }
}
