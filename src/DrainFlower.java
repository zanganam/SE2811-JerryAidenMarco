import javafx.scene.image.Image;

public class DrainFlower extends Flower{

    protected Image image;
    protected Boolean die;
    protected int health;

    public DrainFlower(boolean die, int health) {
        this.die = die;
        this.health = health;
        this.image = new Image("images/garden_jpgs/rose.jpg");
    }
}
