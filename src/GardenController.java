import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GardenController {

    private List<Flower> flowers = new ArrayList<>();
    private List<Bee> bees = new ArrayList<>();

    @FXML
    private Pane theGarden;
    @FXML
    private GridPane garden;


    private void createBees(){
        for (int index = 0; index < 7; index++){
            Bee bee;
            if (index<=3){
                bee = new LineBee((int)Math.floor((Math.random() * 10)),(int)Math.floor((Math.random() * 10)), false, 10);
            } else {
                bee = new RandomBee((int)Math.floor((Math.random() * 10)),(int)Math.floor((Math.random() * 10)), false, 10);
            }
            bees.add(bee);
        }
    }

    private void createFlowers(){
        for (int index = 0; index<10; index++){
            Flower flower;
            if ((index%2)==0){
                flower = new RegenFlower((int)Math.floor((Math.random() * 10)),(int)Math.floor((Math.random() * 10)), false, 10);
            } else {
                flower = new DrainFlower((int)Math.floor((Math.random() * 10)),(int)Math.floor((Math.random() * 10)), false, 10);
            }
            flowers.add(flower);
        }
    }

    @FXML
    public void initialize(){
        createBees();
        createFlowers();

        addElements();

        theGarden.setFocusTraversable(true);
    }

    private void addElements() {
        for(int i = 0; i < bees.size(); i++) {
            StackPane pane = new StackPane();
            ImageView beeImage = new ImageView();
            Label health = new Label();

            beeImage.setImage(bees.get(i).getImage());
            beeImage.setFitHeight(30);
            beeImage.setFitWidth(30);

            health.setText(String.valueOf(bees.get(i).getHealth()));
            health.setMinSize(100,100);
            health.setTextFill(Color.RED);

            pane.getChildren().add(health);
            pane.getChildren().add(beeImage);
            pane.setAlignment(Pos.BOTTOM_LEFT);

            garden.add(pane,bees.get(i).getY(),bees.get(i).getX());
        }

        for(int i = 0; i < flowers.size(); i++) {
            ImageView flowerImage = new ImageView();

            flowerImage.setImage(flowers.get(i).getImage());
            flowerImage.setFitHeight(30);
            flowerImage.setFitWidth(30);

            garden.add(flowerImage,flowers.get(i).getY(),flowers.get(i).getX());
        }
    }

    private void refresh() {
        garden.getChildren().clear();
        addElements();
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.RIGHT
                || keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.LEFT) {
            if (bees.size() > 0) {
                for (int index = 0; index < bees.size(); index++) {
                    Bee bee = bees.get(index);
                    bee.move();
                    bee.changeHealth(1);
                    if (bee.getHealth() <= 0) {
                        bee.die();
                        bees.remove(bee);
                    }
                    refresh();
                }
                collision();
            }
        }
    }

    private void collision() {
        for (int i = 0; i < bees.size(); i++) {
            for (int q = 0; q < bees.size(); q++) {
                if ((bees.get(q) != bees.get(i)) && ((bees.get(q).getX() == bees.get(i).getX()) && (bees.get(q).getY() == bees.get(i).getY()))) {
                        bees.get(q).changeHealth(bees.get(i).getDamage());
                        bees.get(i).changeHealth(bees.get(q).getDamage());
                }
            }
            for (int e = 0; e < flowers.size(); e++) {
                Flower flower = flowers.get(e);
                if ((flower.getX() == bees.get(i).getX()) && (flower.getY() == bees.get(i).getY())) {
                    bees.get(i).changeHealth(flower.getDamage());
                }
            }
        }
    }
}
