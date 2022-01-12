import javafx.scene.Node;
import javafx.scene.image.Image;

public abstract class Flower {

    protected int x,y;
    protected Image image;
    protected Boolean die;
    protected int health;

    Flower() {

    }

    public Flower(int x, int y, boolean die, int health) {
        this.x = x;
        this.y = y;
        this.die = die;
        this.health = health;
    }

    public void setDie(boolean die){
        this.die = die;
    }

    public void die(boolean die){
        this.die = true;
    }
}
