import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.List;

public class GardenController {

    private static GardenController controller = null;

    public static final int SQUARE_SIZE = 700;
    private List<Flower> flowers;
    private List<Bee> bees;
    private Square square;

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


    private void createSquare() {
        square = new Square(SQUARE_SIZE, SQUARE_SIZE);
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

    public static Square getPosition(int x, int y) {
        return getTheController().instanceGetSquare(x, y);
    }

    private Square instanceGetSquare(int x, int y) {
        if(!isValidPosition(x, y)) {
            throw new IllegalArgumentException("This square does not exist: "+x+ " "+ y);
        }
        return square;
    }

    public static boolean isValidPosition(int x, int y) {
        return getTheController().instanceIsValidPosition(x,y);
    }
    private boolean instanceIsValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < SQUARE_SIZE && y < SQUARE_SIZE;
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

*/



    //create imageView objects


    @FXML
    public void initialize(){
//        theGarden = new Pane();
        controller = this;

        createSquare();

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
