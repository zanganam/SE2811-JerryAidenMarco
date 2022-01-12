import javafx.scene.image.Image;

public class LineBee extends Bee{
    protected Image image;

    public LineBee(int x, int y, boolean die, int health) {
        super(x, y, die, health);
        image = new Image("garden_jpgs/bee-1.jpg");
    }

    @Override
    public void move() {

    }

}