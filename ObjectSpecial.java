import greenfoot.*;

public class ObjectSpecial extends Actor {
    private GreenfootSound collectSound = new GreenfootSound("x.mp3");

    public ObjectSpecial() {
        setImage("bomb.png");
    }

    public void act() {
        checkForCollision();
    }

    public void checkForCollision() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            player.increaseScore();
            getWorld().removeObject(this);
            collectSound.play(); // Memainkan suara saat mengambil ObjectSpecial
        }
    }
}
