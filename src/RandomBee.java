import javafx.scene.image.Image;

public class RandomBee extends Bee{

    protected Image image;

    @Override
    public void move() {

    }

    @Override
    public void setImage() {
        image = new Image("images/garden_jpgs/bee-3.jpg");
    }
}