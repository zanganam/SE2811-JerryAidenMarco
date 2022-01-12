import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Represents a place on the board where a piece can sit.
 */
public class Square {
    private int x;
    private int y;
    private static int SQUARE_SIZE = GardenController.SQUARE_SIZE;

    /**
     * The piece currently sitting on this square.
     *
     * null if this square is empty.
     */
    private Bee bee = null;
    private Flower flower = null;
    private final Rectangle rectangle;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;

        rectangle = new Rectangle(SQUARE_SIZE, SQUARE_SIZE, Color.GREEN);
        rectangle.setX(this.x *SQUARE_SIZE);
        rectangle.setY(this.y *SQUARE_SIZE);
        GardenController.addChild(rectangle);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


/*    private void tryMovePieceHere() {
        GardenController.tryMovePiece(this);
    }*/

    /**
     * @return The piece currently sitting on this square.
     * null if this square is empty.
     */

    public Bee getBee() {
        return bee;
    }

    public Flower getFlower(){
        return flower;
    }

    public void removeBee() {
        if(bee == null) {
            throw new UnsupportedOperationException("Cannot remove piece from an empty square.");
        }
        bee = null;
    }

    public void removeFlower(){
        if(flower == null) {
            throw new UnsupportedOperationException("Cannot remove piece from an empty square.");
        }
        flower = null;
    }

    public void placeBee(Bee bee) {
        if(bee == null) {
            throw new IllegalArgumentException("No piece provided.");
        }
        this.bee = bee;
    }

    public void placeFlower(Flower flower) {
        if(flower == null) {
            throw new IllegalArgumentException("No piece provided.");
        }
        this.flower = flower;
    }

}
