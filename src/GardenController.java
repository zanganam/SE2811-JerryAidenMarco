import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class GardenController {

    private static GardenController controller = null;

    public static final int SQUARE_SIZE = 55;
    private static final int BOARD_WIDTH = 10;
    private List<Flower> flowers = new ArrayList<>();
    private List<Bee> bees = new ArrayList<>();
    private List<Square> squares = new ArrayList<>();

    @FXML
    private Pane theGarden;


    private void createBees(){
        for (int index = 0; index < 7; index++){
            Bee bee;
            if (index<=3){
                bee = new LineBee(0,0, false, 10);
            } else {
                bee = new RandomBee(0,0, false, 10);
            }
            bees.add(bee);
            controller.getSquare(bee.getX(), bee.getY()).placeBee(bee);
        }
    }


    private void createFlowers(){
        for (int index = 0; index<10; index++){
            Flower flower;
            if ((index%2)==0){
                flower = new RegenFlower(0,0, false, 10);
            } else {
                flower = new DrainFlower(0,0, false, 10);
            }
            flowers.add(flower);
        }
    }


    private void createSquares() {
        for(int indRow = 0; indRow < BOARD_WIDTH; indRow++) {
            for(int indCol = 0; indCol < BOARD_WIDTH; indCol++) {
                Square square = new Square(indCol, indRow);
                squares.add(square);
            }
        }
    }


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

    public static Square getSquare(int x, int y) {
        return getTheController().instanceGetSquare(x, y);
    }

    private Square instanceGetSquare(int x, int y) {
        if(!isValidPosition(x, y)) {
            throw new IllegalArgumentException("This square does not exist: "+x+ " "+ y);
        }
    return squares.get(y*BOARD_WIDTH + x);
    }

    public static boolean isValidPosition(int x, int y) {
        return getTheController().instanceIsValidPosition(x,y);
    }
    private boolean instanceIsValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < SQUARE_SIZE && y < SQUARE_SIZE;
    }



    @FXML
    public void initialize(){
        controller = this;

        createSquares();

        createBees();
        createFlowers();

        theGarden.setFocusTraversable(true);
        //bee.setX() bee.setY()
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        for (int index =0; index< bees.size(); index++){
            Bee bee = bees.get(index);
            bee.move();


        }
    }
}
