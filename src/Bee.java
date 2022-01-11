import javafx.scene.image.Image;

public abstract class Bee {

    protected boolean die;
    protected int health;
    protected int energy;
    protected Flower flower;
    protected String FilePath;
    private Image image;



    public void setDie(boolean die){
        this.die = die;
    }

    public void die(boolean die){
        this.die = true;
    }

    public void setHealth(int health){
        this.health = health;
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

    public abstract void move();

    public Image getImage(){
        return image;
    }

    public Bee(String filePath){
        this.image = new Image(filePath);
    }



}
