import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private int col;
    private int row;
    private Color color;
    private Rectangle cursor;
    private Rectangle cursorBorder;


    public Cursor() {
        this.col = 0 ;
        this.row = 0 ;
        this.color = Color.BLACK;
        cursorDraw();

    }
    // GETTERS && SETTERS //

    public int getCol() {
        return col;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }
    public Color getColor() {
        return color;
    }
    public Rectangle getCursor() {
        return cursor;
    }


    // METHODS //

    public void cursorDraw() {

        cursor = new Rectangle(col + Grid.PADDING, row + Grid.PADDING, Grid.PIXEL_SIZE, Grid.PIXEL_SIZE);
        cursor.setColor(color);
        cursor.fill();

        cursorBorder = new Rectangle(col + Grid.PADDING, row + Grid.PADDING, Grid.PIXEL_SIZE, Grid.PIXEL_SIZE);
        cursorBorder.setColor(Color.BLACK);
        cursorBorder.draw();


    }


    public void moveUp(){
        this.row = (this.row - Grid.PIXEL_SIZE);
        cursorUpdate();
    }

    public void moveDown(){
        this.row = (this.row + Grid.PIXEL_SIZE);
        cursorUpdate();
    }

    public void moveRight() {
        this.col = (this.col + Grid.PIXEL_SIZE);
        cursorUpdate();
    }

    public void moveLeft(){
        this.col = (this.col - Grid.PIXEL_SIZE);
        cursorUpdate();
    }

    private void cursorUpdate(){
        cursor.delete();
        cursorBorder.delete();

        cursor = new Rectangle(col + Grid.PADDING, row + Grid.PADDING, Grid.PIXEL_SIZE, Grid.PIXEL_SIZE);
        cursor.setColor(color);
        cursor.fill();

        cursorBorder = new Rectangle(col + Grid.PADDING, row + Grid.PADDING, Grid.PIXEL_SIZE, Grid.PIXEL_SIZE);
        cursorBorder.setColor(Color.BLACK);
        cursorBorder.draw();

    }
}
