import javafx.scene.image.Image;

public class LineBee extends Bee{

    private final Image image;

    @Override
    public void move() {

    }

    public LineBee(String filePath, Image image){
        super(filePath);
        this.image = image;
    }

}