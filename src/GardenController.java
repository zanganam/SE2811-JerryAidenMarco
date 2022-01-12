import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class GardenController {

    private static GardenController controller = null;

    public static final int SQUARE_SIZE = 55;
    private static final int BOARD_WIDTH = 10;
    private List<Flower> flowers = new ArrayList<>();
    private List<Bee> bees = new ArrayList<>();
//    private List<Square> squares = new ArrayList<>();

    @FXML
    private Pane theGarden;
    @FXML
    private GridPane garden;


    private void createBees(){
        for (int index = 0; index < 7; index++){
            Bee bee;
            if (index<=3){
                bee = new LineBee((int)Math.floor((Math.random() * 5)),(int)Math.floor((Math.random() * 5)), false, 10);
            } else {
                bee = new RandomBee((int)Math.floor((Math.random() * 5)),(int)Math.floor((Math.random() * 5)), false, 10);
            }
            bees.add(bee);
//            controller.getSquare(bee.getX(), bee.getY()).placeBee(bee);
        }
    }


    private void createFlowers(){
        for (int index = 0; index<10; index++){
            Flower flower;
            if ((index%2)==0){
                flower = new RegenFlower((int)Math.floor((Math.random() * 5)),(int)Math.floor((Math.random() * 5)), false, 10);
            } else {
                flower = new DrainFlower((int)Math.floor((Math.random() * 5)),(int)Math.floor((Math.random() * 5)), false, 10);
            }
            flowers.add(flower);
        }
    }


//    private void createSquares() {
//        for(int indRow = 0; indRow < BOARD_WIDTH; indRow++) {
//            for(int indCol = 0; indCol < BOARD_WIDTH; indCol++) {
//                Square square = new Square(indCol, indRow);
//                squares.add(square);
//            }
//        }
//    }


    public static GardenController getTheController() {
        if(controller == null) {
            throw new IllegalStateException("theController should not be accessed before the " +
                    "gameboard is initialized.");
        }
        return controller;
    }


    public static void addChild(Node node) {
        getTheController().instanceAddChild(node);
    }

    private void instanceAddChild(Node node) {
        theGarden.getChildren().add(node);
    }

    public static void removeChild(Node node) {
        getTheController().instanceRemoveChild(node);
    }

    private void instanceRemoveChild(Node node) {
        theGarden.getChildren().remove(node);
    }

//    public static Square getSquare(int x, int y) {
//        return getTheController().instanceGetSquare(x, y);
//    }

//    private Square instanceGetSquare(int x, int y) {
//        if(!isValidPosition(x, y)) {
//            throw new IllegalArgumentException("This square does not exist: "+x+ " "+ y);
//        }
//    return squares.get(y*BOARD_WIDTH + x);
//    }

    public static boolean isValidPosition(int x, int y) {
        return getTheController().instanceIsValidPosition(x,y);
    }
    private boolean instanceIsValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < SQUARE_SIZE && y < SQUARE_SIZE;
    }



    @FXML
    public void initialize(){
        controller = this;
//        createSquares();

        createBees();
        createFlowers();

        addElements();

        theGarden.setFocusTraversable(true);
        //bee.setX() bee.setY()
    }

    private void addElements() {
        for(int i = 0; i < bees.size(); i++) {
            VBox pane = new VBox();
            ImageView beeImage = new ImageView();

            beeImage.setImage(bees.get(i).getImage());
            beeImage.setFitHeight(30);
            beeImage.setFitWidth(30);
            Rectangle healtbar = new Rectangle(200.0, 50.0, Color.BLUE);
            pane.setSpacing(5);
            pane.getChildren().add(healtbar);
            pane.getChildren().add(beeImage);

            garden.add(beeImage,bees.get(i).getY(),bees.get(i).getX());
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
