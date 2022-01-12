import javafx.scene.image.Image;

public abstract class Flower {

    protected int x,y;
    protected Boolean die;
    protected int health;
    public int damage;


    public Flower(int x, int y, boolean die, int health) {
        this.x = x;
        this.y = y;
        this.die = die;
        this.health = health;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public abstract int getDamage();

    public abstract Image getImage();
}
