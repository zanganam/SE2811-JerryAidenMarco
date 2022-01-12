import javafx.scene.Node;
import javafx.scene.image.Image;

public abstract class Flower {

    protected Image image;
    protected Boolean die;
    protected int health;

    Flower() {

    }

    public Flower(boolean die, int health) {
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
