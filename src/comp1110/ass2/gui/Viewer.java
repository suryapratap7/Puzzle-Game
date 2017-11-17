package comp1110.ass2.gui;

import comp1110.ass2.Pegs;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import comp1110.ass2.Pegs.*;

/**
 * A very simple viewer for piece placements in the link game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 *
 * This is also our JavaFX practice class. Our main class for running the application is Board Class.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int SQUARE_SIZE = 100;
    private static final int PIECE_IMAGE_SIZE = 3*SQUARE_SIZE;
    private static final double ROW_HEIGHT = SQUARE_SIZE * 0.8660254; // 60 degrees
    private static final int VIEWER_WIDTH = 933;
    private static final int VIEWER_HEIGHT = 700;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    private final Group control = new Group();

    TextField textField;

    HBox hb1 = new HBox();



    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {


        // FIXME Task 5: implement the simple placement viewer
        ImageView pieceImage = new ImageView();
        ImageView pieceImage1 = new ImageView();

        pieceImage.setImage(new Image(Board.class.getResource(URI_BASE + placement.charAt(1) + ".png").toString()));
        pieceImage1.setImage(new Image(Board.class.getResource(URI_BASE + placement.charAt(4) + ".png").toString()));


        String s = placement.charAt(0) + "";
        //String sa = (String) s;
        //Pegs pegs = new Pegs();


        pieceImage.setLayoutX(Pegs.valueOf(s).x - 100);
        pieceImage.setLayoutY(Pegs.valueOf(s).y);
        pieceImage.setFitHeight(PIECE_IMAGE_SIZE);
        pieceImage.setFitWidth(PIECE_IMAGE_SIZE);

        String s1 = placement.charAt(3) + "";

        pieceImage1.setLayoutX(Pegs.valueOf(s1).x -100);
        pieceImage1.setLayoutY(Pegs.valueOf(s1).y);
        pieceImage1.setFitHeight(PIECE_IMAGE_SIZE);
        pieceImage1.setFitWidth(PIECE_IMAGE_SIZE);



        //pieceImage.setLayoutX(750);

        //hb1.getChildren().add(pieceImage);
        //hb1.setScaleX(0.2);
        //hb1.setScaleY(0.2);
        root.getChildren().addAll(pieceImage, pieceImage1);


    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {



        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               if (!hb1.getChildren().isEmpty()){

                    hb1.getChildren().remove(0);
                }
                makePlacement(textField.getText());
                textField.clear();

            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LinkGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        ImageView pieceImageA = new ImageView();
        pieceImageA.setImage(new Image(Board.class.getResource(URI_BASE + "A.png").toString()));
        pieceImageA.setLayoutX(0);
        pieceImageA.setLayoutY(-50);
        pieceImageA.setFitHeight(SQUARE_SIZE*2);
        pieceImageA.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageB = new ImageView();
        pieceImageB.setImage(new Image(Board.class.getResource(URI_BASE + "B.png").toString()));
        pieceImageB.setLayoutX(200);
        pieceImageB.setLayoutY(-50);
        pieceImageB.setFitHeight(SQUARE_SIZE*2);
        pieceImageB.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageC = new ImageView();
        pieceImageC.setImage(new Image(Board.class.getResource(URI_BASE + "C.png").toString()));
        pieceImageC.setLayoutX(400);
        pieceImageC.setLayoutY(-50);
        pieceImageC.setFitHeight(SQUARE_SIZE*2);
        pieceImageC.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageD = new ImageView();
        pieceImageD.setImage(new Image(Board.class.getResource(URI_BASE + "D.png").toString()));
        pieceImageD.setLayoutX(600);
        pieceImageD.setLayoutY(0);
        pieceImageD.setFitHeight(SQUARE_SIZE*2);
        pieceImageD.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageE = new ImageView();
        pieceImageE.setImage(new Image(Board.class.getResource(URI_BASE + "E.png").toString()));
        pieceImageE.setLayoutX(720);
        pieceImageE.setLayoutY(70);
        pieceImageE.setFitHeight(SQUARE_SIZE*2);
        pieceImageE.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageF = new ImageView();
        pieceImageF.setImage(new Image(Board.class.getResource(URI_BASE + "F.png").toString()));
        pieceImageF.setLayoutX(720);
        pieceImageF.setLayoutY(200);
        pieceImageF.setFitHeight(SQUARE_SIZE*2);
        pieceImageF.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageG = new ImageView();
        pieceImageG.setImage(new Image(Board.class.getResource(URI_BASE + "G.png").toString()));
        pieceImageG.setLayoutX(720);
        pieceImageG.setLayoutY(330);
        pieceImageG.setFitHeight(SQUARE_SIZE*2);
        pieceImageG.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageH = new ImageView();
        pieceImageH.setImage(new Image(Board.class.getResource(URI_BASE + "H.png").toString()));
        pieceImageH.setLayoutX(600);
        pieceImageH.setLayoutY(460);
        pieceImageH.setFitHeight(SQUARE_SIZE*2);
        pieceImageH.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageI = new ImageView();
        pieceImageI.setImage(new Image(Board.class.getResource(URI_BASE + "I.png").toString()));
        pieceImageI.setLayoutX(450);
        pieceImageI.setLayoutY(460);
        pieceImageI.setFitHeight(SQUARE_SIZE*2);
        pieceImageI.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageJ = new ImageView();
        pieceImageJ.setImage(new Image(Board.class.getResource(URI_BASE + "J.png").toString()));
        pieceImageJ.setLayoutX(300);
        pieceImageJ.setLayoutY(460);
        pieceImageJ.setFitHeight(SQUARE_SIZE*2);
        pieceImageJ.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageK = new ImageView();
        pieceImageK.setImage(new Image(Board.class.getResource(URI_BASE + "K.png").toString()));
        pieceImageK.setLayoutX(150);
        pieceImageK.setLayoutY(460);
        pieceImageK.setFitHeight(SQUARE_SIZE*2);
        pieceImageK.setFitWidth(SQUARE_SIZE*2);

        ImageView pieceImageL = new ImageView();
        pieceImageL.setImage(new Image(Board.class.getResource(URI_BASE + "L.png").toString()));
        pieceImageL.setLayoutX(0);
        pieceImageL.setLayoutY(460);
        pieceImageL.setFitHeight(SQUARE_SIZE*2);
        pieceImageL.setFitWidth(SQUARE_SIZE*2);





        root.getChildren().addAll(controls, hb1, control, pieceImageA, pieceImageB, pieceImageC, pieceImageD, pieceImageE, pieceImageF, pieceImageG, pieceImageH, pieceImageI, pieceImageJ, pieceImageK, pieceImageL);

        makeControls();
        makePeg();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void makePeg(){
        ImageView pegA = new ImageView();
        pegA.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegA.setFitHeight(300);
        pegA.setFitWidth(300);
        pegA.setX(-100);
        pegA.setY(0);

        ImageView pegB = new ImageView();
        pegB.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegB.setFitHeight(300);
        pegB.setFitWidth(300);
        pegB.setX(0);
        pegB.setY(0);

        ImageView pegC = new ImageView();
        pegC.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegC.setFitHeight(300);
        pegC.setFitWidth(300);
        pegC.setX(100);
        pegC.setY(0);

        ImageView pegD = new ImageView();
        pegD.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegD.setFitHeight(300);
        pegD.setFitWidth(300);
        pegD.setX(200);
        pegD.setY(0);

        ImageView pegE = new ImageView();
        pegE.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegE.setFitHeight(300);
        pegE.setFitWidth(300);
        pegE.setX(300);
        pegE.setY(0);

        ImageView pegF = new ImageView();
        pegF.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegF.setFitHeight(300);
        pegF.setFitWidth(300);
        pegF.setX(400);
        pegF.setY(0);

        ImageView pegG = new ImageView();
        pegG.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegG.setFitHeight(300);
        pegG.setFitWidth(300);
        pegG.setX(-50);
        pegG.setY(88);

        ImageView pegH = new ImageView();
        pegH.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegH.setFitHeight(300);
        pegH.setFitWidth(300);
        pegH.setX(50);
        pegH.setY(88);

        ImageView pegI = new ImageView();
        pegI.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegI.setFitHeight(300);
        pegI.setFitWidth(300);
        pegI.setX(150);
        pegI.setY(88);

        ImageView pegJ = new ImageView();
        pegJ.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegJ.setFitHeight(300);
        pegJ.setFitWidth(300);
        pegJ.setX(250);
        pegJ.setY(88);

        ImageView pegK = new ImageView();
        pegK.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegK.setFitHeight(300);
        pegK.setFitWidth(300);
        pegK.setX(350);
        pegK.setY(88);

        ImageView pegL = new ImageView();
        pegL.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegL.setFitHeight(300);
        pegL.setFitWidth(300);
        pegL.setX(450);
        pegL.setY(88);

        ImageView pegM = new ImageView();
        pegM.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegM.setFitHeight(300);
        pegM.setFitWidth(300);
        pegM.setX(-100);
        pegM.setY(176);

        ImageView pegN = new ImageView();
        pegN.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegN.setFitHeight(300);
        pegN.setFitWidth(300);
        pegN.setX(0);
        pegN.setY(176);


        ImageView pegO = new ImageView();
        pegO.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegO.setFitHeight(300);
        pegO.setFitWidth(300);
        pegO.setX(100);
        pegO.setY(176);


        ImageView pegP = new ImageView();
        pegP.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegP.setFitHeight(300);
        pegP.setFitWidth(300);
        pegP.setX(200);
        pegP.setY(176);


        ImageView pegQ = new ImageView();
        pegQ.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegQ.setFitHeight(300);
        pegQ.setFitWidth(300);
        pegQ.setX(300);
        pegQ.setY(176);


        ImageView pegR = new ImageView();
        pegR.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegR.setFitHeight(300);
        pegR.setFitWidth(300);
        pegR.setX(400);
        pegR.setY(176);

        ImageView pegS = new ImageView();
        pegS.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegS.setFitHeight(300);
        pegS.setFitWidth(300);
        pegS.setX(-50);
        pegS.setY(264);



        ImageView pegT = new ImageView();
        pegT.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegT.setFitHeight(300);
        pegT.setFitWidth(300);
        pegT.setX(50);
        pegT.setY(264);



        ImageView pegU = new ImageView();
        pegU.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegU.setFitHeight(300);
        pegU.setFitWidth(300);
        pegU.setX(150);
        pegU.setY(264);



        ImageView pegV = new ImageView();
        pegV.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegV.setFitHeight(300);
        pegV.setFitWidth(300);
        pegV.setX(250);
        pegV.setY(264);



        ImageView pegW = new ImageView();
        pegW.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegW.setFitHeight(300);
        pegW.setFitWidth(300);
        pegW.setX(350);
        pegW.setY(264);



        ImageView pegX = new ImageView();
        pegX.setImage(new Image(Board.class.getResource(URI_BASE + "peg.png").toString()));
        pegX.setFitHeight(300);
        pegX.setFitWidth(300);
        pegX.setX(450);
        pegX.setY(264);

        control.getChildren().addAll(pegA, pegB, pegC, pegD, pegE, pegF, pegG, pegH, pegI, pegJ, pegK, pegL, pegM, pegN, pegO, pegP, pegQ, pegR, pegS, pegT, pegU, pegV, pegW, pegX);



    }
}
