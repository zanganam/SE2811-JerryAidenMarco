import javafx.scene.image.Image;

public class RandomBee extends Bee{

    protected Image image;

    @Override
    public void move() {
        int tempx,tempy;
        tempx = (int)(Math.random()*2);
        tempy = (int)(Math.random()*2);

        if (getX() == 0) {
            setX((getX()+tempx));
        } else if (getX() == 5) {
            setX((getX()-tempx));
        } else {
            setX(getX()+((int)(Math.random()*3)-1));
        }
        if (getY() == 0) {
            setY((getY()+tempy));
        } else if (getX() == 5) {
            setY((getY()-tempy));
        } else {
            setY(getY()+((int)(Math.random()*3)-1));
        }
    }

    @Override
    public Image getImage() {
        if (die) {
            return null;
        }
        return new Image("garden_jpgs/bee-3.jpg");
    }


    public RandomBee(int x, int y, boolean die, int health){
        super(x, y, die, health);
        image = new Image("garden_jpgs/bee-3.jpg");

    }
}