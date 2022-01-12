import javafx.scene.image.Image;

public class RandomBee extends Bee{

    protected Image image;

    @Override
    public void move() {

    }


    public RandomBee(int x, int y, boolean die, int health){
        super(x, y, die, health);
        image = new Image("images/garden_jpgs/bee-3.jpg");
    }
}