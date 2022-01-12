import javafx.scene.image.Image;

public abstract class Bee {

    private int x,y;
    protected boolean die;
    protected int health;
    protected Flower flower;
    public int damage = 1;


    public Bee(int x, int y, boolean die, int health) {
        this.x = x;
        this.y =y;
        this.die = die;
        this.health = health;
    }

    private void show(){
    }

    public void die(){
        die = true;

    }

    public void setHealth(){
        this.health = 10;
    }

    public int getHealth(){
        return health;
    }

    public void changeHealth(int damage){
        health-=damage;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public int getDamage(){
        return damage;
    }

    public abstract void move();

    public abstract Image getImage();



}
