package comp1110.ass2;

// Please do not grade this class it is just a practice class, doesnt affect game

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prac {

   /* Shape atIndex0;
    Shape atIndex1;
    Shape atIndex2;

    //public Piece(char pieceName, Shape atIndex0, Shape atIndex1, Shape atIndex2){
//        this.pieceName = pieceName;
//        this.atIndex0 = atIndex0;
//        this.atIndex1 = atIndex1;
//        this.atIndex2 = atIndex2;
//    }


    //Piece piece = new Piece('A', Shape.BALL, Shape.BALL, Shape.BALL);
    //pieces.put(piece.getPieceName(), new String[]{piece.atIndex0.name(), piece.atIndex1.name(), piece.atIndex2.name()});
    //pieces.put('A', new Shape[]{Shape.BALL, Shape.BALL, Shape.BALL});



      /*  A(BALL, HALF_RING, BALL),
    B(BALL, FULL_RING, RING_60),
    C(BALL, FULL_RING, RING_360),
    D(RING_180, BALL, FULL_RING),
    E(RING_300, BALL, FULL_RING),
    F(RING_360, BALL, FULL_RING),
    G(BALL, BALL, RING_240),
    H(RING_60, RING_360, FULL_RING),
    I(RING_360, BALL, BALL),
    J(RING_300, BALL, BALL),
    K(BALL, BALL, RING_180),
    L(RING_120, BALL, RING_180);

    Shape[] shapes;

    Piece(Shape a, Shape b, Shape c){
        shapes = new Shape[3];
        shapes[0] = a;
        shapes[1]= b;
        shapes[2] = c;
    }





    int translatePosition(int origin, Piece piece, Orientation orientation){
        return -1;
    }*/

    static int[] getPegsForPiecePlacement(String piecePlacement) {
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
        //System.out.println(x0 + "' " + y0);
        //System.out.println(x2 + "' " + y2);
        //System.out.println(pegs[0] + ", " + pegs[1] + ", " + pegs[2]);
        return pegs;
    }

    class prop{
        int pegLocation;
        int value;

        public prop(int pegLocation, int value){
            this.pegLocation = pegLocation;
            this.value = value;
        }
    }

    static void isPlacementValid(String placement) {
        // FIXME Task 7: determine whether a placement is valid
            String[] piece = new String[placement.length()/3];
            //int[] location = new int[3];
        //int[][] loca = new int[3][2];
        List<Integer> pegPoints = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        List<String> shape = new ArrayList<>();



        for (int i = 0; i< placement.length()/3; i++) {
                piece[i] = placement.substring(3 * i, 3 * i + 3);
                int[] location = getPegsForPiecePlacement(piece[i]);
                /*for (int j = 0; j<location.length; j++){
                    System.out.println(location[j]);
                }*/

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
                if (index0Prop == -60) {
                    index0Prop = 300;
                }
                if (index0Prop == -120) {
                    index0Prop = 240;
                }
                if (index0Prop == -180) {
                    index0Prop = 180;
                }
                if (index0Prop == -240) {
                    index0Prop = 120;
                }
                if (index0Prop == -300) {
                    index0Prop = 60;
                }
                if (index1Prop == -60) {
                    index1Prop = 300;
                }
                if (index1Prop == -120) {
                    index1Prop = 240;
                }
                if (index1Prop == -180) {
                    index1Prop = 180;
                }
                if (index1Prop == -240) {
                    index1Prop = 120;
                }
                if (index1Prop == -300) {
                    index1Prop = 60;
                }
                if (index2Prop == -60) {
                    index2Prop = 300;
                }
                if (index2Prop == -120) {
                    index2Prop = 240;
                }
                if (index2Prop == -180) {
                    index2Prop = 180;
                }
                if (index2Prop == -240) {
                    index2Prop = 120;
                }
                if (index2Prop == -300) {
                    index2Prop = 60;
                }

            int[] valueArray = new int[3];
                valueArray[0] = index0Prop;
                valueArray[1] = index1Prop;
                valueArray[2] = index2Prop;
            String[] shapeArray = new String[3];
            shapeArray[0] = Pieces.valueOf(pieceName).atIndex0.description;
            shapeArray[1] = Pieces.valueOf(pieceName).atIndex1.description;
            shapeArray[2] = Pieces.valueOf(pieceName).atIndex2.description;;
                //System.out.println(location.length);
            for (int x = 0; x < location.length; x++) {
                    //System.out.println(loca[x][0] + ", " + loca[x][1]);
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
            System.out.println(pegPoints.get(x) + ", " + value.get(x));
            for (int i = 0; i < pegPoints.size() ; i++) {
                if (pegPoints.get(x) == pegPoints.get(i)){
                    if (x == i){

                    } else{
                        if (!value.get(x).equals(value.get(i))) {
                            System.out.println("--------------" + value.get(x) + ", " + value.get(i) + ",");
                            System.out.println("Overlaping 0");

                        }
                        if (shape.get(x).equals(shape.get(i))){
                            System.out.println("Overlaping");

                        }
                    }
                }
            }
            //System.out.println(students.get(x));
        }

    }

    public static void main(String[] args) {
        /*int pos = 'C' - 'A';
        int o = ('W' - 'W');
        int x = (pos % 4) - (((o + 1) / 2) % 2);
        int y = (pos / 4) - (o / 2);
        int setLayoutX= (200 + x * 100);
        int setLayoutY = (100 + y * 100);
        //System.out.println(setLayoutX + " " + setLayoutY);
        //System.out.println(x +" "+ y);

        String peg = "A";
        int a = (int) (Pegs.valueOf(peg).x + 100) / 100;
        int b = (int) (Pegs.valueOf(peg).y + 50) / 100;

        System.out.println("x = " + Pegs.valueOf(peg).x + " y = " + Pegs.valueOf(peg).y );
        System.out.println("a = " + a + " b = " + b );
        int x1 = 250;
        int y1 = 88;
        int x0 = x1 - 100;
        int y0 = y1;

        for (char i = 'B'; i <= 'K'; i++) {
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

        //System.out.println( x0 + ", " + y0);
        getPegsForPiecePlacement("LKC");
        String pieceName = "B";/*
        System.out.println(Pieces.valueOf(pieceName).atIndex0.degree);
        System.out.println(Pieces.valueOf(pieceName).atIndex1.degree);
        System.out.println(Pieces.valueOf(pieceName).atIndex2.degree);
        int turns = 'F' - 'A';
        int index0Prop = 300 + (turns * -60);
        System.out.println(" ");
        System.out.println(" ");*/

        isPlacementValid("OEAGJD");

    }


}
