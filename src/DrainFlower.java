import javafx.scene.image.Image;

public class DrainFlower extends Flower{

    protected Image image;
    public int damage = 1;

    public DrainFlower(int x, int y, boolean die, int health) {
        super(x, y, die, health);
        this.image = new Image("garden_jpgs/rose.jpg");
    }

    @Override
    public Image getImage() {
        return new Image("garden_jpgs/rose.jpg");
    }

}
