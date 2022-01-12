import javafx.scene.image.Image;

public abstract class Bee {

    private int x,y;
    protected boolean die;
    protected int health;
    protected Flower flower;
    protected Image image;


    public Bee(int x, int y, boolean die, int health, Image image){
        this.x = x;
        this.y = y;
        this.die = die;
        this.health = health;
        this.image = image;

    }

    public Bee() {
    }

    public void setDie(boolean die){
        this.die = false;
    }

    public void die(){
        die = true;
    }

    public void setHealth(){
        this.health = 10;
    }

    public int getHealth(int health){
        return health;
    }

    private void drainHealth(int damage){
        health-=damage;
    }

    private void regenHealth(int flowerHealing){
        health+= flowerHealing;
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

    public abstract void move();

    public abstract void setImage();



}
