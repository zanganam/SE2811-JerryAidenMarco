import javafx.scene.image.Image;

public class LineBee extends Bee{
    protected Image image;
    private boolean isDown;
    private boolean isRight;

    public LineBee(int x, int y, boolean die, int health) {
        super(x, y, die, health);
        image = new Image("garden_jpgs/bee-1.jpg");
    }

    @Override
    public void move() {
        if (getY() == 0){
            isDown = true;
        } else if (getY()==5){
            isDown = false;
        }
        if (getX()==0){
            isRight = true;
        } else if(getX()==5){
            isRight = false;
        }
        if (isDown){
            setY(getY()+1);
        } else {
            setY(getY()-1);
        }
        if(isRight){
            setX(getX()+1);
        } else {
            setX(getX()-1);
        }


    }

    @Override
    public Image getImage() {
        if (die) {
            return null;
        }
        return new Image("garden_jpgs/bee-1.jpg");
    }

}