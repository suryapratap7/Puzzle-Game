package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides the text interface for the Link Game
 *
 * The game is based directly on Smart Games' IQ-Link game
 * (http://www.smartgames.eu/en/smartgames/iq-link)
 */
public class LinkGame {

    private int origin;
    //private Piece piece;
    private Orientation orientation;




    /**
     * Determine whether a piece placement is well-formed according to the following:
     * - it consists of exactly three characters
     * - the first character is in the range A .. X
     * - the second character is in the range A .. L
     * - the third character is in the range A .. F if the second character is A, otherwise
     *   in the range A .. L
     *
     * @param piecePlacement A string describing a piece placement
     * @return True if the piece placement is well-formed
     */
     static boolean isPiecePlacementWellFormed(String piecePlacement) {
        // FIXME Task 3: determine whether a piece placement is well-formed.
        if (piecePlacement.length()==3){
            char [] piece = piecePlacement.toCharArray();
            if (piece[0]>='A'&&piece[0]<='X'){
                if (piece[1]>='A'&&piece[1]<='L'){
                    if (piece[1]=='A'){
                        if (piece[2]>='A'&&piece[2]<='F'){
                            return true;
                        }
                    }
                    else{
                        if (piece[2]>='A'&& piece[2]<='L'){
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    /**
     * Determine whether a placement string is well-formed:
     *  - it consists of exactly N three-character piece placements (where N = 1 .. 12);
     *  - each piece placement is well-formed
     *  - no piece appears more than once in the placement
     *
     * @param placement A string describing a placement of one or more pieces
     * @return True if the placement is well-formed
     */
    static boolean isPlacementWellFormed(String placement) {
        // FIXME Task 4: determine whether a placement is well-formed


        boolean bool = false;
        if (placement != null && placement.length() % 3 == 0 && placement.length() >= 0 && placement.length() / 3 >= 1 ){

            String[] piece = new String[placement.length()/3];
            int num = 0;
            for (int i = 0; i< placement.length()/3; i++){
                piece[i]= placement.substring(3*i,3*i+3);
                if (isPiecePlacementWellFormed(placement.substring(3*i,3*i+3))){
                    for (int j=0; j<=i; j++){

                        if (piece[i].charAt(1) == (piece[j].charAt(1))){
                            num = num + 1;
                        }
                    }

                }else {
                    return bool;
                }
            }
            if (num <= placement.length()/3){
                bool = true;
            }

        }
        return bool;
    }

    /**
     * Return a array of peg locations according to which pegs the given piece placement touches.
     * The values in the array should be ordered according to the units that constitute the
     * piece.
     * The code needs to account for the origin of the piece, the piece shape, and the piece
     * orientation.
     * @param piecePlacement A valid string describing a piece placement
     * @return An array of integers corresponding to the pegs which the piece placement touches,
     * listed in the normal order of units for that piece.   The value 0 corresponds to
     * peg 'A', 1 to peg 'B', etc.
     */


    public static int[] getPegsForPiecePlacement(String piecePlacement) {
        // FIXME Task 6: determine the pegs touched by a piece placement


        String peg = piecePlacement.charAt(0) + "";
        char piece = piecePlacement.charAt(1);
        char orientation = piecePlacement.charAt(2);
        int pegs[] = new int[3];


        int x1 = Pegs.valueOf(peg).x;
        int y1 = Pegs.valueOf(peg).y;


        int x0 = x1 - 100;
        int y0 = y1;

        int x2=0;
        int y2=0;

        if (piece >= 'A' && piece <= 'C') {

            x2 = x1 + 100;
            y2 = y1;
        } else  if (piece >='D' && piece<='H'){

            x2 = x1 + 50;
            y2 = y1-88;
        }
        else  if (piece >='I' && piece<='L'){

            x2 = x1 - 50;
            y2 = y1-88;
        }

        for (char i = 'B'; i <= orientation; i++) {
            if (x0 == x1 - 100 && y0 == y1){
                y0 = y0 - 88;
                x0 = x0 + 50;
            } else if (x0 == x1 + 100 && y0 == y1){
                y0 = y0 + 88;
                x0 = x0 - 50;
            }else if (x0 == x1 - 50 && y0 == y1 - 88){
                // y0 = y1;
                x0 = x0 + 100;
            } else if (x0 == x1 + 50 && y0 == y1 + 88){
                //y0 = y1 + 88;
                x0 = x0 - 100;
            }else if (x0 == x1 + 50 && y0 == y1 - 88){
                y0 = y0 + 88;
                x0 = x0 + 50;
            } else if (x0 == x1 - 50 && y0 == y1 + 88){
                y0 = y0 - 88;
                x0 = x0 - 50;
            }
        }
//---------------------------------------------------------------------------------------------------------------------------
        for (char i = 'B'; i <= orientation; i++) {
            if (i == 'G' && piece > 'C'){
                if (piece >='D' && piece<='H'){
                    x2 = x1 + 50;
                    y2 = y1 + 88;
                }
                else  if (piece >='I' && piece<='L'){

                    x2 = x1-50;
                    y2 = y1 +88;
                }
            } else {
                if (x2 == x1 - 100 && y2 == y1){
                    y2 = y2 - 88;
                    x2 = x2 + 50;
                } else if (x2 == x1 + 100 && y2 == y1){
                    y2 = y2 + 88;
                    x2 = x2 - 50;
                }else if (x2 == x1 - 50 && y2 == y1 - 88){
                    // y0 = y1;
                    x2 = x2 + 100;
                } else if (x2 == x1 + 50 && y2 == y1 + 88){
                    //y0 = y1 + 88;
                    x2 = x2 - 100;
                }else if (x2 == x1 + 50 && y2 == y1 - 88){
                    y2 = y2 + 88;
                    x2 = x2 + 50;
                } else if (x2 == x1 - 50 && y2 == y1 + 88){
                    y2 = y2 - 88;
                    x2 = x2 - 50;
                }}
        }


//---------------------------------------------------------------------------------------------------------------------------
        int px1 = (int) (Pegs.valueOf(peg).x + 100) / 100;
        int py1 = (int) (Pegs.valueOf(peg).y + 50) / 100;
        int px0 = (int) (x0 + 100) / 100;
        int py0 = (int) (y0 + 50) / 100;
        int px2 = (int) (x2 + 100) / 100;
        int py2 = (int) (y2 + 50) / 100;

        if (y0 <0 || y0 > 264){
            px0 = 0;
            py0 = 0;
        }
        if(y0==0||y0==176){
            if(x0<0||x0>500){
                px0 = 0;
                py0 = 0;
            }
        }

        if(y0==88||y0==264){
            if(x0<50||x0>550){
                px0 = 0;
                py0 = 0;
            }
        }
        if (y2 <0 || y2 > 264){
            px2 = 0;
            py2 = 0;
        }

        if(y2==0||y2==176){
            if(x2<0||x2>500){
                px2 = 0;
                py2 = 0;
            }
        }
        if(y2==88||y2==264){
            if(x2<50||x2>550){
                px2 = 0;
                py2 = 0;
            }
        }



        pegs[0] = ( (px0 + py0 * 6) - 1);
        pegs[1] = ( (px1 + py1 * 6) - 1);
        pegs[2] = ( (px2 + py2 * 6) - 1);
        return pegs;
    }

    public static int[][] getPegsLocation(String piecePlacement) {


        String peg = piecePlacement.charAt(0) + "";
        char piece = piecePlacement.charAt(1);
        char orientation = piecePlacement.charAt(2);
        int pegs[][] = new int[3][2];


        int x1 = Pegs.valueOf(peg).x;
        int y1 = Pegs.valueOf(peg).y;


        int x0 = x1 - 100;
        int y0 = y1;

        int x2=0;
        int y2=0;

        if (piece >= 'A' && piece <= 'C') {

            x2 = x1 + 100;
            y2 = y1;
        } else  if (piece >='D' && piece<='H'){

            x2 = x1 + 50;
            y2 = y1-88;
        }
        else  if (piece >='I' && piece<='L'){

            x2 = x1 - 50;
            y2 = y1-88;
        }

        for (char i = 'B'; i <= orientation; i++) {
            if (x0 == x1 - 100 && y0 == y1){
                y0 = y0 - 88;
                x0 = x0 + 50;
            } else if (x0 == x1 + 100 && y0 == y1){
                y0 = y0 + 88;
                x0 = x0 - 50;
            }else if (x0 == x1 - 50 && y0 == y1 - 88){
                // y0 = y1;
                x0 = x0 + 100;
            } else if (x0 == x1 + 50 && y0 == y1 + 88){
                //y0 = y1 + 88;
                x0 = x0 - 100;
            }else if (x0 == x1 + 50 && y0 == y1 - 88){
                y0 = y0 + 88;
                x0 = x0 + 50;
            } else if (x0 == x1 - 50 && y0 == y1 + 88){
                y0 = y0 - 88;
                x0 = x0 - 50;
            }
        }
//---------------------------------------------------------------------------------------------------------------------------
        for (char i = 'B'; i <= orientation; i++) {
            if (i == 'G' && piece > 'C'){
                if (piece >='D' && piece<='H'){
                    x2 = x1 + 50;
                    y2 = y1 + 88;
                }
                else  if (piece >='I' && piece<='L'){

                    x2 = x1-50;
                    y2 = y1 +88;
                }
            } else {
                if (x2 == x1 - 100 && y2 == y1){
                    y2 = y2 - 88;
                    x2 = x2 + 50;
                } else if (x2 == x1 + 100 && y2 == y1){
                    y2 = y2 + 88;
                    x2 = x2 - 50;
                }else if (x2 == x1 - 50 && y2 == y1 - 88){
                    // y0 = y1;
                    x2 = x2 + 100;
                } else if (x2 == x1 + 50 && y2 == y1 + 88){
                    //y0 = y1 + 88;
                    x2 = x2 - 100;
                }else if (x2 == x1 + 50 && y2 == y1 - 88){
                    y2 = y2 + 88;
                    x2 = x2 + 50;
                } else if (x2 == x1 - 50 && y2 == y1 + 88){
                    y2 = y2 - 88;
                    x2 = x2 - 50;
                }}
        }


//---------------------------------------------------------------------------------------------------------------------------

        pegs[0][0] = x0;
        pegs[0][1] = y0;
        pegs[1][0] = x1;
        pegs[1][1] = y1;
        pegs[2][0] = x2;
        pegs[2][1] = y2;
        return pegs;
    }


    /**
     * Determine whether a placement is valid.  To be valid, the placement must be well-formed
     * and each piece must correctly connect with each other.
     *
     * @param placement A placement string
     * @return True if the placement is valid
     */
    public static boolean isPlacementValid(String placement) {
        // FIXME Task 7: determine whether a placement is valid
        if (isPlacementWellFormed(placement)){

            String[] piece = new String[placement.length()/3];
            List<Integer> pegPoints = new ArrayList<>();
            List<Integer> value = new ArrayList<>();
            List<String> shape = new ArrayList<>();


            for (int i = 0; i< placement.length()/3; i++){
                piece[i]= placement.substring(3*i,3*i+3);
                int[] location = getPegsForPiecePlacement(piece[i]);


                String pieceName = piece[i].charAt(1) + "";
                int index0Prop = Pieces.valueOf(pieceName).atIndex0.degree;
                int index1Prop = Pieces.valueOf(pieceName).atIndex1.degree;
                int index2Prop = Pieces.valueOf(pieceName).atIndex2.degree;

                int turns= 0;
                if (piece[i].charAt(2) < 'G') {
                    turns = piece[i].charAt(2) - 'A';
                }
                if (piece[i].charAt(2) > 'F'){
                    turns = piece[i].charAt(2) - 'G';

                    if (index0Prop == 240){
                        index0Prop = 120;
                    }else if (index0Prop == 120){
                        index0Prop = 240;
                    }else if (index0Prop == 300){
                        index0Prop = 60;
                    }else if (index0Prop == 60){
                        index0Prop = 300;
                    }

                    if (index1Prop == 240){
                        index1Prop = 120;
                    }else if (index1Prop == 120){
                        index1Prop = 240;
                    }else if (index1Prop == 300){
                        index1Prop = 60;
                    }else if (index1Prop == 60){
                        index1Prop = 300;
                    }

                    if (index2Prop == 240){
                        index2Prop = 120;
                    }else if (index2Prop == 120){
                        index2Prop = 240;
                    }else if (index2Prop == 300){
                        index2Prop = 60;
                    }else if (index2Prop == 60){
                        index2Prop = 300;
                    }
                }



                index0Prop = index0Prop + (turns * -60);
                index1Prop = index1Prop + (turns * -60);
                index2Prop = index2Prop + (turns * -60);
                if (index0Prop == -60){
                    index0Prop = 300;
                }
                if (index0Prop == -120){
                    index0Prop = 240;
                }
                if (index0Prop == -180){
                    index0Prop = 180;
                }
                if (index0Prop == -240){
                    index0Prop = 120;
                }
                if (index0Prop == -300){
                    index0Prop = 60;
                }
                if (index1Prop == -60){
                    index1Prop = 300;
                }
                if (index1Prop == -120){
                    index1Prop = 240;
                }
                if (index1Prop == -180){
                    index1Prop = 180;
                }
                if (index1Prop == -240){
                    index1Prop = 120;
                }
                if (index1Prop == -300){
                    index1Prop = 60;
                }
                if (index2Prop == -60){
                    index2Prop = 300;
                }
                if (index2Prop == -120){
                    index2Prop = 240;
                }
                if (index2Prop == -180){
                    index2Prop = 180;
                }
                if (index2Prop == -240){
                    index2Prop = 120;
                }
                if (index2Prop == -300){
                    index2Prop = 60;
                }
                int[] valueArray = new int[3];
                valueArray[0] = index0Prop;
                valueArray[1] = index1Prop;
                valueArray[2] = index2Prop;

                String[] shapeArray = new String[3];
                shapeArray[0] = Pieces.valueOf(pieceName).atIndex0.description;
                shapeArray[1] = Pieces.valueOf(pieceName).atIndex1.description;
                shapeArray[2] = Pieces.valueOf(pieceName).atIndex2.description;
                for (int x = 0; x < location.length; x++) {
                    pegPoints.add(location[x]);
                }
                for (int j = 0; j < valueArray.length ; j++) {
                    value.add(valueArray[j]);
                }
                for (int c = 0; c < valueArray.length ; c++) {
                    shape.add(shapeArray[c]);
                }



            }
            for (int x = 0; x < pegPoints.size(); x++) {
                for (int i = 0; i < pegPoints.size() ; i++) {
                    if (pegPoints.get(x) == pegPoints.get(i)){
                        if (x == i){

                        } else{
                            if(!value.get(x).equals(value.get(i))) {
                                return false;
                            }
                            if (shape.get(x).equals(shape.get(i))){
                                return false;

                            }
                        }
                    }
                }
                }
            return true;
        } else {
            return false;
        }

    }

    /**
     * Return an array of all solutions given a starting placement.
     *
     * @param placement  A valid piece placement string.
     * @return An array of strings, each describing a solution to the game given the
     * starting point provied by placement.
     */
    static String[] getSolutions(String placement) {
        // FIXME Task 10: determine all solutions to the game, given a particular starting placement
        return null;
    }
}
