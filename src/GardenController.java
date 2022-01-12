import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.List;

public class GardenController {

    private List<Flower> flowers;
    private List<Bee> bees;

    @FXML
    private Pane theGarden;


    private void createBee(){
        for (int index = 0; index < 7; index++){
            Bee bee;
            if (index<=3){
                bee = new LineBee();
            } else {
                bee = new RandomBee();
            }
            bees.add(bee);
        }
    }

/*    private void addBees(){
        for (int index = 0; index<10; index++){
            Bee bee;
            if (index<=4){
                bee = new LineBee("images/garden_jpgs/bee-1.jpg", image);
            } else {
                bee = new RandomBee("images/garden_jpgs/bee-2.jpg");
            }
            ImageView beeImage = new ImageView(bee.getImage());
            bees.add(bee);
        }
    }


    private void removeBee(Bee bee){
    }

    private void addFlowers(){
        for (int index = 0; index<16; index++){
            Flower flower;
            if (index <=7){
                flower = new RegenFlower("images/garden_jpgs/daisy.jpg");
            } else{
                flower = new DrainFlower("images/garden_jpgs/rose.jpg");
            }
            flowers.add(flower);
        }
    }

*//*    private void removeFlower(Flower flower){
    }

    public double beeGetX(){
    }

    public double beeGetY(){
    }


    public double flowerGetX(){
    }

    public double flowerGetY(){
    }
    */



    //create imageView objects


    public void loadGarden(){
        theGarden = new Pane();


        //bee.setX() bee.setY()
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        for (int index =0; index< bees.size(); index++){
            Bee bee = bees.get(index);
            bee.move();


        }
    }
}
