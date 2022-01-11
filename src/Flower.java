import javafx.scene.Node;
import javafx.scene.image.Image;

public abstract class Flower {

    protected Image image;
    protected Boolean die;

    public Flower(String filePath) {
        this.image = new Image(filePath);
    }

    public void setDie(boolean die){
        this.die = die;
    }

    public void die(boolean die){
        this.die = true;
    }
}
