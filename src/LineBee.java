import javafx.scene.image.Image;

public class LineBee extends Bee{

    private Image image;

    @Override
    public void move() {

    }

    public LineBee(String filePath){
        super(filePath);
    }

    public void setImage(Image image) {
        this.image = "images/garden_jpgs/bee-1.jpg";
    }
}