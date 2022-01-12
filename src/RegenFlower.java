import javafx.scene.image.Image;

public class RegenFlower extends Flower{

    protected Image image;
    protected Boolean die;
    protected int health;

    public RegenFlower(boolean die, int health) {
        this.die = die;
        this.health = health;
        this.image = new Image("images/garden_jpgs/daisy.jpg");
    }
}
