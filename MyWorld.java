import greenfoot.*;
import java.util.List;

public class MyWorld extends World {
    private int currentLevel = 1;

    public MyWorld() {
        super(800, 600, 1);
        prepare();
    }

    public void act() {
        // Periksa apakah level selesai
        if (getObjects(ObjectSpecial.class).isEmpty()) {
            if (currentLevel < 10) {
                currentLevel++;
                addObject(new LevelComplete(currentLevel), getWidth() / 2, getHeight() / 2);
                Greenfoot.delay(100);
                nextLevel();
            } else {
                showText("Game Over You Win!", getWidth() / 2, getHeight() / 2);
                Greenfoot.stop();
            }
        }
        List<Enemy> enemies = getObjects(Enemy.class);
        for (Enemy enemy : enemies) {
            enemy.act();
        }
    }

    public void prepare() {
        // Tambahkan inisialisasi objek dan karakter utama untuk level pertama di sini
        addObject(new Player(), getWidth() / 2, getHeight() - 30);
        addObject(new ObjectSpecial(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        addObject(new Enemy(), 400, 300);
    }

    public void nextLevel() {
        // Fungsi ini akan mempersiapkan level selanjutnya
        removeObjects(getObjects(ObjectSpecial.class));
        removeObjects(getObjects(LevelComplete.class));
        prepare();
    }
}
