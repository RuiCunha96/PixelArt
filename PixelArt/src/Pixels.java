import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pixels {

    private int col;
    private int row;
    private Color color;
    private Rectangle pixel;




    public Pixels(int col, int row){
        this.col = col;
        this.row = row;
        this.color = Color.BLACK;
        pixelDraw();

    }

    public void pixelDraw(){

       pixel = new Rectangle(col, row, Grid.PIXEL_SIZE, Grid.PIXEL_SIZE );
       pixel.setColor(color);
       pixel.draw();

    }

    public void setDraw() {

        pixel.draw();
    }
    public void setFill(){

        pixel.fill();
    }

    public boolean isFilled(){
        return pixel.isFilled();
    }

    public String getColorString() {

        if (color.equals(Color.BLACK)){
            return "BLACK";
        }
        if (color.equals(Color.BLUE)){
            return "BLUE";
        }
        if (color.equals(Color.RED)){
            return "RED";
        }
        if (color.equals(Color.GREEN)){
            return "GREEN";
        }
        return "BLACK";

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color){
        this.color = color;
        pixel.setColor(color);
    }

}
