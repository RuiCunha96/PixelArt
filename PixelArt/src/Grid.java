

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.io.*;


public class Grid implements ToDo {

    String PATH = "/Users/codecadet/Desktop/Modulo1Java/projetos intelij/PixelArt/src/saveFile";

    public static int PIXEL_SIZE = 15;
    public static int PADDING = 10;

    private Rectangle grid;

    private Color currentColor = Color.BLACK;

    private Rectangle toolWindow;
    private int tools = 8;
    private int toolPixelSize = 20;
    private Rectangle[] toolPixels = new Rectangle[tools];
    private Text[] toolPixelsText = new Text[tools];

    private int maxCols = 40;
    private int maxRows = 50;

    private Pixels[][] pixels = new Pixels[maxRows][maxCols];
    private Cursor cursor;

    private boolean spacePressed = false;
    private boolean ePressed = false;

    public Grid() throws IOException {


        Inputs.setInputScreen(this);
        grid = new Rectangle(PADDING, PADDING, maxCols * PIXEL_SIZE, maxRows * PIXEL_SIZE);
        grid.draw();
        pixelPlacement();
        tools();
        cursorInit();
        load();
    }

    private void tools() {
        toolWindow = new Rectangle(grid.getWidth() + PIXEL_SIZE, grid.getX(), toolPixelSize, toolPixelSize * tools);

        for (int i = 0; i < tools; i++) {
            toolPixels[i] = new Rectangle(toolWindow.getX(), toolWindow.getY() + (i * toolPixelSize), toolPixelSize, toolPixelSize);
            toolPixels[i].draw();
        }

        toolPixels[0].setColor(Color.BLACK);
        toolPixels[1].setColor(Color.BLUE);
        toolPixels[2].setColor(Color.RED);
        toolPixels[3].setColor(Color.GREEN);

        toolPixels[0].fill();
        toolPixels[1].fill();
        toolPixels[2].fill();
        toolPixels[3].fill();

        toolPixelsText[0] = new Text(toolPixels[0].getX() + (toolPixelSize / 3), toolPixels[0].getY() + (toolPixelSize / 10), "1");
        toolPixelsText[1] = new Text(toolPixels[1].getX() + (toolPixelSize / 3), toolPixels[1].getY() + (toolPixelSize / 10), "2");
        toolPixelsText[2] = new Text(toolPixels[2].getX() + (toolPixelSize / 3), toolPixels[2].getY() + (toolPixelSize / 10), "3");
        toolPixelsText[3] = new Text(toolPixels[3].getX() + (toolPixelSize / 3), toolPixels[3].getY() + (toolPixelSize / 10), "4");

        toolPixelsText[4] = new Text(toolPixels[4].getX() + (toolPixelSize / 3), toolPixels[4].getY() + (toolPixelSize / 10), "D");
        toolPixelsText[5] = new Text(toolPixels[5].getX() + (toolPixelSize / 3) + 1, toolPixels[5].getY() + (toolPixelSize / 10), "S");
        toolPixelsText[6] = new Text(toolPixels[6].getX() + (toolPixelSize / 3) + 1, toolPixels[6].getY() + (toolPixelSize / 10), "L");
        toolPixelsText[7] = new Text(toolPixels[7].getX() + (toolPixelSize / 3) + 1, toolPixels[7].getY() + (toolPixelSize / 10), "E"); //erase


        toolPixelsText[0].setColor(Color.WHITE);
        toolPixelsText[1].setColor(Color.WHITE);
        toolPixelsText[2].setColor(Color.WHITE);
        toolPixelsText[3].setColor(Color.BLACK);

        for (int i = 0; i < tools; i++) {
            toolPixelsText[i].draw();
        }

        toolWindow.draw();


    }


    private void pixelPlacement() {
        int columns = 0;
        int rows = 0;

        for (int row = PADDING; row < PIXEL_SIZE * maxRows; row += PIXEL_SIZE) {

            for (int col = PADDING; col < PIXEL_SIZE * maxCols; col += PIXEL_SIZE) {

                pixels[rows][columns++] = new Pixels(col, row);
            }
            columns = 0;
            rows++;
        }
    }


    private boolean nearBordersUp() {
        if (cursor.getRow() <= 0) {
            return true;
        }
        return false;
    }

    private boolean nearBordersLeft() {
        if (cursor.getCol() <= 0) {
            return true;
        }
        return false;
    }

    private boolean nearBordersDown() {
        if (cursor.getRow() >= PADDING + PIXEL_SIZE * (maxRows - 2)) {
            return true;
        }
        return false;
    }

    private boolean nearBordersRight() {
        if (cursor.getCol() >= PADDING + PIXEL_SIZE * (maxCols - 2)) {
            return true;
        }
        return false;
    }


    private void cursorInit() {
        cursor = new Cursor();
    }

    private int row2y(int row) {
        return (row) / PIXEL_SIZE;
    }

    private int col2x(int col) {
        return (col) / PIXEL_SIZE;
    }


    private void coloring() {

        if (ePressed) {
            pixels[row2y(cursor.getRow())][col2x(cursor.getCol())].setColor(Color.BLACK);
            pixels[row2y(cursor.getRow())][col2x(cursor.getCol())].setDraw();
            return;
            }

        pixels[row2y(cursor.getRow())][col2x(cursor.getCol())].setColor(currentColor);
        pixels[row2y(cursor.getRow())][col2x(cursor.getCol())].setFill();
    }

    @Override
    public void actionPressed(int key) throws IOException {

        switch (key) {
            case KeyboardEvent.KEY_UP:
                if (nearBordersUp()) {
                    break;
                }
                if (spacePressed) {
                    coloring();
                }
                cursor.moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                if (nearBordersDown()) {
                    break;
                }

                if (spacePressed) {
                    coloring();
                }
                cursor.moveDown();
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (nearBordersRight()) {
                    break;
                }

                if (spacePressed) {
                    coloring();
                }
                cursor.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                if (nearBordersLeft()) {
                    break;
                }

                if (spacePressed) {
                    coloring();
                }
                cursor.moveLeft();
                break;

            case KeyboardEvent.KEY_SPACE:
                spacePressed = true;
                coloring();
                break;

            case KeyboardEvent.KEY_D:
                for (int i = 0; i < maxRows; i++) {
                    for (int j = 0; j < maxCols; j++) {
                        pixels[i][j].setColor(Color.BLACK);
                        pixels[i][j].setDraw();
                    }
                }
                break;

            case KeyboardEvent.KEY_S:
                save();
                break;

            case KeyboardEvent.KEY_L:
                load();
                break;

            case KeyboardEvent.KEY_1:
                cursor.setColor(Color.BLACK);
                currentColor = Color.BLACK;
                break;
            case KeyboardEvent.KEY_2:
                cursor.setColor(Color.BLUE);
                currentColor = Color.BLUE;
                break;
            case KeyboardEvent.KEY_3:
                cursor.setColor(Color.RED);
                currentColor = Color.RED;
                break;
            case KeyboardEvent.KEY_4:
                cursor.setColor(Color.GREEN);
                currentColor = Color.GREEN;
                break;
            case KeyboardEvent.KEY_E:
                ePressed = true;
                coloring();
                break;
        }

    }


    @Override
    public void actionReleased(int key) {
        switch (key) {
            case KeyboardEvent.KEY_SPACE:
                spacePressed = false;
                break;

            case KeyboardEvent.KEY_E:
                ePressed = false;
                break;

        }
    }


    public void save() throws IOException {

        FileWriter fileOut = new FileWriter(PATH);
        BufferedWriter bufferOut = new BufferedWriter(fileOut);
        String line = "";

        for (int i = 0; i < maxRows; i++) {

            for (int j = 0; j < maxCols; j++) {

                if (pixels[i][j].isFilled()) {
                    //line += "1";
                    line = "1:" + pixels[i][j].getColorString();

                    bufferOut.write(line, 0, line.length());
                    bufferOut.newLine();
                    line = "";
                    continue;
                }

                line = "0:" + pixels[i][j].getColorString();
                bufferOut.write(line, 0, line.length());
                bufferOut.newLine();
                line = "";
                //line += "0";
            }

  /*          bufferOut.write(line, 0,1);
            bufferOut.newLine();
            line = "";*/
        }

        bufferOut.close();
    }

    private void load() throws IOException {

        FileReader fileIn = new FileReader(PATH);

        BufferedReader bufferIn = new BufferedReader(fileIn);

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                String in = bufferIn.readLine();
                String[] inSplit = in.split(":");
                switch (inSplit[1]) {
                    case "BLACK":
                        pixels[i][j].setColor(Color.BLACK);
                        break;
                    case "BLUE":
                        pixels[i][j].setColor(Color.BLUE);
                        break;
                    case "RED":
                        pixels[i][j].setColor(Color.RED);
                        break;
                    case "GREEN":
                        pixels[i][j].setColor(Color.GREEN);
                        break;
                }

                if (inSplit[0].equals("1")) {
                    pixels[i][j].setFill();
                } else {
                    pixels[i][j].setDraw();
                }
            }
        }
        bufferIn.close();
    }
}
