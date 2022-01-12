import javafx.scene.image.Image;

public class LineBee extends Bee{
    protected Image image;

    @Override
    public void move() {

    }

    @Override
    public void setImage() {
        image = new Image("images/garden_jpgs/bee-1.jpg");
    }
}