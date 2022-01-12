import javafx.scene.image.Image;

public class RegenFlower extends Flower{

    protected Image image;
    protected Boolean die;
    protected int health;

    public RegenFlower(int x, int y, boolean die, int health) {
        super(x, y, die, health);
        this.image = new Image("images/garden_jpgs/daisy.jpg");
    }
}
