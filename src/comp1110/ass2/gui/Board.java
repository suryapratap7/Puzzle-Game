package comp1110.ass2.gui;

import comp1110.ass2.LinkGame;
import comp1110.ass2.Pegs;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;


/**
 *
 * Our game imitates most of the code of assignment 1. But some of the code that could not have been implemented was
 * created on our own. No, other sources have been referenced besides assignment one.
 *
 *
 * Controls:-
 *
 * The pieces can rotated using the buttons and flipped using the 'F' key on the keyboard.
 */

public class Board extends Application {

    /* board layout */
    private static final int SQUARE_SIZE = 100;
    private static final int PIECE_IMAGE_SIZE = 3*SQUARE_SIZE;
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    /* where to find media assets */
    private static final String URI_BASE = "assets/";


    // FIXME Task 8: Implement a basic playable Link Game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 9: Implement starting placements

    // FIXME Task 11: Implement hints

    // FIXME Task 12: Generate interesting starting placements

    /* node groups */
    private final Group root = new Group();
    private final Group control = new Group();
    private final Group pieces = new Group();
    private final Group grid = new Group();
    private final Group peg = new Group();

    LinkGame linkGame;
    private final Text competionText = new Text("Error");
    ImageView wrongImage = new ImageView();

    void setImage(){
        wrongImage.setImage(new Image(Board.class.getResource(URI_BASE + "wrong.png").toString()));
        wrongImage.setFitHeight(50);
        wrongImage.setFitWidth(50);
        wrongImage.setOpacity(0);
        wrongImage.toBack();
        root.getChildren().add(wrongImage);

    }

    void showImage(int x, int y){
        wrongImage.setLayoutX(x);
        wrongImage.setLayoutY(y);
        wrongImage.toFront();
        wrongImage.setOpacity(1);
    }





//----------------------------------------------------------------------------------------------------------------------

    /**
     * An inner class that represents a peg.  The class extends
     * Java FX's ImageView class (used for displaying bitmap images).
     */
    class Peg extends ImageView {

        /**
         * Construct a particular peg at already defined location by class Pegs
         * @param name A character representing the peg image.
         * Pegs.valueOf x and y are representing the location on the grid
         */

        Peg(char name) {
            setImage(new Image(Board.class.getResource(URI_BASE  +  "peg.png").toString()));
            setFitHeight(PIECE_IMAGE_SIZE);
            setFitWidth(PIECE_IMAGE_SIZE);
            String pegName = name + "";
            setLayoutX(Pegs.valueOf(pegName).x);
            setLayoutY(Pegs.valueOf(pegName).y);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * An inner class that represents transparent pieces used in the game.
     * Each of these is a visual representaton of an underlying piece.
     */
    class FXPiece extends ImageView{
        char piece;


        /**
         * Construct a particular playing piece
         * @param piece The letter representing the piece to be created.
         */
        FXPiece(char piece){
            setImage(new Image(Board.class.getResource(URI_BASE + piece + ".png").toString()));
            this.piece = piece;
            setFitHeight(SQUARE_SIZE*2);
            setFitWidth(SQUARE_SIZE*2);

        }

        FXPiece(String position){
            this(position.charAt(1));

            String s = position.charAt(0) + "";
            setLayoutX(Pegs.valueOf(s).x);
            setLayoutY(Pegs.valueOf(s).y);

        }
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * This class extends FXPiece with the capacity for it to be dragged and dropped,
     * and snap-to-grid.
     */
    class DraggableFXPiece extends FXPiece {

        int position;                           // the current game position of the piece 1 .. 24 (-1 is off-board)
        int homeX, homeY;                       // the position in the window where the piece should be when not on the board
        double mouseX, mouseY;                  // the last known mouse positions (used when dragging)

        /**
         * Construct a draggable piece
         * @param piece The piece identifier ('A' - 'L')
         */
        DraggableFXPiece(char piece){
            super(piece);
            position = -1; // off screen
            if (piece >= 'A' && piece <= 'C') {
                homeX = (piece - 'A') * 200 + 120;
                setLayoutX(homeX);
                homeY = -50;
                setLayoutY(homeY);
            }
            if (piece >= 'D' && piece <= 'F') {
                homeX = 740;
                setLayoutX(homeX);
                homeY = ((piece - 'D') * 180) + 50;
                setLayoutY(homeY);
            }
            if (piece >= 'G' && piece <= 'I') {
                homeX = (piece - 'G') * 200 + 140;
                setLayoutX(homeX);
                homeY = 460;
                setLayoutY(homeY);
            }
            if (piece >= 'J' && piece <= 'L') {
                homeX = -10;
                setLayoutX(homeX);
                homeY = ((piece - 'J') * 180) + 50;
                setLayoutY(homeY);
            }

             /* event handlers */
            setOnMousePressed(event -> {                            // mouse press indicates begin of drag
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
                setFitHeight(PIECE_IMAGE_SIZE);
                setFitWidth(PIECE_IMAGE_SIZE);
            });

            setOnMouseDragged(event -> {                            // mouse is being dragged
                toFront();
                double movementX = event.getSceneX() - mouseX;
                double movementY = event.getSceneY() - mouseY;
                setLayoutX(getLayoutX() + movementX);
                setLayoutY(getLayoutY() + movementY);
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();
                event.consume();
            });
            setOnMouseReleased(event -> {                           // drag is complete
                snapToGrid();

            });



        }

        /**
         * Snap the piece to the nearest grid position (if it is over the grid)
         */
        private void snapToGrid() {

            System.out.println(getLayoutX() + ", " + getLayoutY());
            System.out.println(getRotate());

            int x = (SQUARE_SIZE * (((int) getLayoutX() + (SQUARE_SIZE / 2)) / SQUARE_SIZE));
            int y = 88 * (((int) getLayoutY() + (SQUARE_SIZE / 2)) / SQUARE_SIZE);
            if (y == 88 || y == 264){
                setLayoutX(x - 50);
                setLayoutY(y);
            } else {
                setLayoutX(x);
                setLayoutY(y);
            }
            System.out.println(getLayoutX() + ", " + getLayoutY());
            setPosition();
            System.out.println(position);

            if (position != -1) {
                int num = checkMove();
                if (num == 0){
                    wrongImage.setOpacity(0);
                }
            } else {
                snapToHome();
            }
            System.out.println(toString());
        }

        /**
         * Snap the piece to its home position (if it is not on the grid)
         */
        private void snapToHome() {
            setLayoutX(homeX);
            setLayoutY(homeY);
            setRotate(0);                           //set rotation to original
            position = -1;
            setScaleY(1);                           //set image to original scale
            setFitHeight(SQUARE_SIZE*2);
            setFitWidth(SQUARE_SIZE*2);
        }


        /**
         * Determine whether the whole piece is on the board, given x and y
         * coordinates representing the top-left corner of the piece in its
         * current rotation.
         * @param x The column that the origin of the piece is on
         * @param y The row that the origin of the piece is on
         * @return True if the entire piece is on the board
         */
        private boolean isOnBoard(int x, int y) {
            return x >= 0 && x < 551 && y >= 0 && y < 265;
        }

        /**
         * Determine the grid-position of the origin of the piece (1 .. 23)
         * and -1 if it is off the grid
         */
        private void setPosition() {
            int x = (int) (getLayoutX()) / SQUARE_SIZE;
            int y = (int) (getLayoutY() + 88) / SQUARE_SIZE;
            System.out.println(x + ", " + y);
            if (isOnBoard((int) (getLayoutX()),(int) (getLayoutY()))) {
                position = x + y * 6;
            } else
                position = -1;
        }

        public String toString() {
            if (getScaleY() == -1){
                char orientation = (char) ('G' + (int) (getRotate()/ 60));
                return position == -1 ? "" : "" + (char)('A'+position) + piece + orientation;
            } else {
                char orientation = (char) ('A' + (int) (getRotate()/ 60));
                return position == -1 ? "" : "" + (char)('A'+position) + piece + orientation;
            }
        }

    }

//----------------------------------------------------------------------------------------------------------------------
    /**
     * CheckMove checks for any errors that may have showed up in the Game. It also outputs an image, as well as a
     * dialog box indicating the error.
     */
    private int checkMove() {

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, Wrong piece placement!");

        String placement = "";
        for(Node p : pieces.getChildren()) {
            placement += p.toString();
        }
        System.out.println(placement);
            if(!LinkGame.isPlacementValid(placement)){
                alert.showAndWait();
            }
        String[] piece = new String[placement.length()/3];
        //int num = 0;
        for (int i = 0; i< placement.length()/3; i++) {
            piece[i] = placement.substring(3 * i, 3 * i + 3);
            System.out.println(piece[i]);
            int [] location = LinkGame.getPegsForPiecePlacement(piece[i]);
            System.out.println(location[0] + ", " + location[1] + ", " + location[2]);
            for (int j = 0; j< location.length; j++){
                if (location[j] == -1){
                    int[][] points = LinkGame.getPegsLocation(piece[i]);
                    for (int c = 0; c < points.length; c++){
                        if (points[c][1] < 0 || points[c][1] > 264 ){
                            showImage(points[c][0] + 125, points[c][1] + 125);
                            alert.showAndWait();
                            return -1;
                        }
                        if (points[c][1] == 0 || points[c][1] == 176){
                            if (points[c][0] <0 || points[c][0] > 500){
                                showImage(points[c][0] + 125, points[c][1] + 125);
                                alert.showAndWait();
                                return -1;
                            }
                        }
                        if (points[c][1] == 88 || points[c][1] == 264){
                            if (points[c][0] <50 || points[c][0] > 550){
                                showImage(points[c][0] + 125, points[c][1] + 125);
                                alert.showAndWait();
                                return -1;
                            }
                        }
                    }

                }

            }
        }
        /*if(piece.length > 0){
            for (int i = 0; i< piece.length; i++){
                //pieceList = LinkGame.getPegsForPiecePlacement(piece[i]);
                int [] location = LinkGame.getPegsForPiecePlacement(piece[i]);
                for (int j = 0; j< location.length; j++){
                    if (location[i] == -1){
                        System.out.println("Sorry you cannot place the piece here");
                    }

                }

            }
        }*/
        return 0;
    }


    /**
     * Set up all 24 pegs
     */
    private void makePeg() {
        peg.getChildren().clear();
        for (char p = 'A'; p <= 'X'; p++) {
            peg.getChildren().add(new Peg(p));
        }
        peg.toBack();
    }


    /**
     * Set up the group that represents the pieces that make the pegs
     */
    private void makePieces() {
        pieces.getChildren().clear();
        for (char p = 'A'; p <= 'L'; p++) {
            pieces.getChildren().add(new DraggableFXPiece(p));
        }
    }

    /**
     * Create the controls that allow the peg to be rotated and reset
     * level set.
     */
    private void makeControl(){
        Button resetButton = new Button("Reset");
        resetButton.setLayoutX(300);
        resetButton.setLayoutY(650);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                resetPieces();
            }
        });

        Button turnRightButton = new Button("Rotate Right");
        turnRightButton.setLayoutX(600);
        turnRightButton.setLayoutY(650);
        turnRightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                rotateRight();
            }
        });



        /*Button turnLeftButton = new Button("Rotate Left");
        turnLeftButton.setLayoutX(200);
        turnLeftButton.setLayoutY(650);
        turnLeftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                rotateLeft();
            }
        });*/



        control.getChildren().add(resetButton);
        //control.getChildren().add(turnLeftButton);
        control.getChildren().add(turnRightButton);
    }

    /**
     * Put all of the pieces back in their home position
     */
    private void resetPieces() {
        pieces.toFront();
        wrongImage.setOpacity(0);
        for (Node n : pieces.getChildren()) {
            System.out.println(pieces.getChildren().size());
            ((DraggableFXPiece) n).snapToHome();
        }
    }

    /**
     * Set up event handlers for the main game
     * @param scene  The Scene used by the game.
     */
    private void setUpHandlers(Scene scene) {
        /* create handlers for key press and release events */
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F) {
                Node n = pieces.getChildren().get(11);
                if (n.getScaleY() == 1){
                    n.setScaleY(-1);
                    int num = checkMove();
                    if (num == 0){
                        wrongImage.setOpacity(0);
                    }
                }
                else if (n.getScaleY() == -1){
                    n.setScaleY(1);
                    int num = checkMove();
                    if (num == 0){
                        wrongImage.setOpacity(0);
                    }
                }
                event.consume();
            }
        });
    }

    /**
     * Rotate current piece towards right by 60
     */
    private void rotateRight() {
        Node n = pieces.getChildren().get(11);
        //Node n = grid.getChildren().get(0);
        if (((DraggableFXPiece) n).position != -1){
            n.setRotate((n.getRotate() + 60) % 360);
            System.out.println(n.getRotate());
            int num = checkMove();
            if (num == 0){
                wrongImage.setOpacity(0);
            }
        }
    }

    /**
     * Rotate current piece towards left by 60
     */
    private void rotateLeft() {
        Node n = pieces.getChildren().get(11);
        if (((DraggableFXPiece) n).position != -1){
            n.setRotate((n.getRotate() - 60) % 360);
            int num = checkMove();
            if (num == 0){
                wrongImage.setOpacity(0);
            }
        }
    }



//----------------------------------------------------------------------------------------------------------------------

    /**
     * @param primaryStage The stage (window) in which the game occurs.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("My Game");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        makePeg();
        makeControl();
        makePieces();
        setUpHandlers(scene);
        rotateRight();
        rotateLeft();
        setImage();


        root.getChildren().add(peg);
        root.getChildren().add(control);
        root.getChildren().add(pieces);


        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
