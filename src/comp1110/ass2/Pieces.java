package comp1110.ass2;


/**
 * A simple enumeration describing the default properties of each indexes. At the pieces default position.
 */

public enum Pieces{

    A (Shape.BALL_180, Shape.HALFRING_240_300, Shape.BALL_0),
    B (Shape.BALL_180, Shape.FULL_RING, Shape.RING_240),
    C (Shape.BALL_180, Shape.FULL_RING, Shape.RING_300),
    D (Shape.BALL_180, Shape.FULL_RING, Shape.RING_120),
    E (Shape.BALL_180, Shape.FULL_RING, Shape.RING_0),
    F (Shape.BALL_180, Shape.FULL_RING, Shape.RING_300),
    G (Shape.BALL_180, Shape.RING_60, Shape.BALL_60),
    H (Shape.RING_300, Shape.FULL_RING, Shape.RING_60),
    I (Shape.BALL_180, Shape.BALL_0, Shape.RING_300),
    J (Shape.BALL_180, Shape.BALL_0, Shape.RING_0),
    K (Shape.BALL_180, Shape.RING_120, Shape.BALL_120),
    L (Shape.BALL_180, Shape.RING_120, Shape.RING_180);

    Shape atIndex0;
    Shape atIndex1;
    Shape atIndex2;

    Pieces(Shape atIndex0, Shape atIndex1, Shape atIndex2){
        this.atIndex0 = atIndex0;
        this.atIndex1 = atIndex1;
        this.atIndex2 = atIndex2;
    }

}
