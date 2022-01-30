import javafx.scene.image.Image;

import java.util.ArrayList;

public class LineBee extends Bee{
    protected Image image;
    private boolean isRight = true;
    private boolean isLeft = false;
    private boolean down = true;
    private boolean reverse = false;

    public LineBee(int x, int y, boolean die, int health) {
        super(x, y, die, health);
        image = new Image("garden_jpgs/bee-1.jpg");
    }

    @Override
    public void move() {
        System.out.println("Location: " + getX() + " " + getY());

        if (getY() >= 9 && getX() >= 9) {
            setY(8);
            setX(8);
            reverse = true;
        } else if (getY() <= 0 && getX() <= 0) {
            setY(1);
            setX(1);
            reverse = false;
        }

        if (getX() <= 0){
            if (down) {
                setY(getY()+1);
            } else {
                setY(getY()-1);
            }
            if (reverse) {
                isRight = false;
                isLeft = true;
            } else {
                isRight = true;
                isLeft = false;
            }
        } else if (getX() >= 9) {
            if (down) {
                setY(getY()+1);
            } else {
                setY(getY()-1);
            }
            if (reverse) {
                isRight = true;
                isLeft = false;
            } else {
                isRight = false;
                isLeft = true;
            }
        } else if (getY() >= 0) {
            down = true;
        } else if (getY() >= 9) {
            down = false;
        }

        if(isRight) {
            setX(getX()+1);
        } else if (isLeft) {
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