import javafx.scene.image.Image;

public class RegenFlower extends Flower{

    protected Image image;
    public int damage = -1;

    public RegenFlower(int x, int y, boolean die, int health) {
        super(x, y, die, health);
        this.image = new Image("garden_jpgs/daisy.jpg");
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public Image getImage() {
        return new Image("garden_jpgs/daisy.jpg");
    }
}
