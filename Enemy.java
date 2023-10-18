import greenfoot.*;

public class Enemy extends Actor {
    private GreenfootSound collisionSound = new GreenfootSound("peng1.mp3");
    private int speed = 2;

    public Enemy() {
        setImage("ant3.png");
    }

    public void act() {
        Actor player = getOneIntersectingObject(Player.class);

        if (player != null) {
            // Memainkan suara saat tabrakan terdeteksi
            collisionSound.play();

            // Akhiri permainan atau lakukan tindakan lain
            Greenfoot.stop();
        } else {
            chasePlayer();
        }
    }

    public void chasePlayer() {
        Actor player = getWorld().getObjects(Player.class).get(0);

        int playerX = player.getX();
        int playerY = player.getY();
        int enemyX = getX();
        int enemyY = getY();

        double angle = Math.atan2(playerY - enemyY, playerX - enemyX);
        int deltaX = (int) (speed * Math.cos(angle));
        int deltaY = (int) (speed * Math.sin(angle));

        setLocation(enemyX + deltaX, enemyY + deltaY);
    }
}
