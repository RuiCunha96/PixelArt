import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class Inputs implements KeyboardHandler {

    /**
     * Ao usar inputs usar sempre i setInput Screen() antes do que queremos
     */
    public static ToDo inputScreen;

    private Keyboard keyboard = new Keyboard(this);

    private KeyboardEvent upPressed = new KeyboardEvent();
    private KeyboardEvent downPressed = new KeyboardEvent();
    private KeyboardEvent rightPressed = new KeyboardEvent();
    private KeyboardEvent leftPressed = new KeyboardEvent();
    private KeyboardEvent spacePressed = new KeyboardEvent();
    private KeyboardEvent sPressed = new KeyboardEvent();
    private KeyboardEvent lPressed = new KeyboardEvent();
    private KeyboardEvent dPressed = new KeyboardEvent();
    private KeyboardEvent ePressed = new KeyboardEvent();

    private KeyboardEvent onePressed = new KeyboardEvent();
    private KeyboardEvent twoPressed = new KeyboardEvent();
    private KeyboardEvent threePressed = new KeyboardEvent();
    private KeyboardEvent fourPressed = new KeyboardEvent();

    private KeyboardEvent spaceDepressed = new KeyboardEvent();
    private KeyboardEvent eDepressed = new KeyboardEvent();


    public Inputs() {

        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        ePressed.setKey(KeyboardEvent.KEY_S);
        ePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        sPressed.setKey(KeyboardEvent.KEY_E);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        lPressed.setKey(KeyboardEvent.KEY_L);
        lPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        dPressed.setKey(KeyboardEvent.KEY_D);
        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        onePressed.setKey(KeyboardEvent.KEY_1);
        onePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        twoPressed.setKey(KeyboardEvent.KEY_2);
        twoPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        threePressed.setKey(KeyboardEvent.KEY_3);
        threePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        fourPressed.setKey(KeyboardEvent.KEY_4);
        fourPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eDepressed.setKey(KeyboardEvent.KEY_E);
        eDepressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        spaceDepressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceDepressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(sPressed);
        keyboard.addEventListener(lPressed);
        keyboard.addEventListener(dPressed);
        keyboard.addEventListener(ePressed);
        keyboard.addEventListener(onePressed);
        keyboard.addEventListener(twoPressed);
        keyboard.addEventListener(threePressed);
        keyboard.addEventListener(fourPressed);

        keyboard.addEventListener(spaceDepressed);
        keyboard.addEventListener(eDepressed);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        try {
            inputScreen.actionPressed(keyboardEvent.getKey());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        inputScreen.actionReleased(keyboardEvent.getKey());

    }

    public static void setInputScreen(ToDo inputScreen2) {
        inputScreen = inputScreen2;
    }


    //    InputsTypes inputTypes;
////    Object obj;
////    MainMenu mainMenu = (MainMenu) obj;

   /* public Inputs(InputsTypes inputTypes, Object obj){
        this.inputTypes = inputTypes;
        this.obj = obj;
        init();

    }*/

    /*public void init(){
        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);

        //TODO: adicionar o resto das teclas


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (inputTypes){
            case MAIN_MENU:
                switch (keyboardEvent.getKey()){

                    case KeyboardEvent.KEY_DOWN:
                        switch (mainMenu.getCurrentlyPressedPosition()) {

                            case 1:
                                mainMenu.getRectangle().delete();
                                mainMenu.getRectangle2().draw();
                                mainMenu.incrementCurrentlyPressedPosition();

                                break;

                            case 2:
                                mainMenu.getRectangle2().delete();
                                mainMenu.getRectangle3().draw();
                                mainMenu.incrementCurrentlyPressedPosition();
                                break;

                            case 3:
                                mainMenu.getRectangle3().delete();
                                mainMenu.getRectangle().draw();
                                mainMenu.setCurrentlyPressedPosition(1);
                                break;
                        }
                        break;

                    case KeyboardEvent.KEY_UP:
                        switch (mainMenu.getCurrentlyPressedPosition()) {

                            case 1:
                                mainMenu.getRectangle().delete();
                                mainMenu.getRectangle3().draw();
                                mainMenu.setCurrentlyPressedPosition(3);
                                break;

                            case 2:
                                mainMenu.getRectangle2().delete();
                                mainMenu.getRectangle().draw();
                                mainMenu.decrementCurrentlyPressedPosition();
                                break;

                            case 3:
                                mainMenu.getRectangle3().delete();
                                mainMenu.getRectangle2().draw();
                                mainMenu.decrementCurrentlyPressedPosition();
                                break;
                        }
                        break;

                    case KeyboardEvent.KEY_SPACE:
                        switch (mainMenu.getCurrentlyPressedPosition()) {

                            case 1:
                                System.out.println("1");
                                mainMenu.startGame();

                                break;

                            case 2:
                                System.out.println("2");
                                mainMenu.instructions();
                                break;

                            case 3:
                                // Exit clause (DONE)
                                System.out.println("3");
                                Runtime.getRuntime().exit(0);
                                break;
                            default:
                                System.out.println("DEFAULT");
                        }
                        break;
                }




                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}*/


}
