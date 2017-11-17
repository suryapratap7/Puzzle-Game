package comp1110.ass2;
/**
 * A simple enumeration describing the placement of pegs on the basis of a coordinate system. (x,y). The first value indicating
 * x coordinate and the second value indicating y coordinating.
 */

public enum  Pegs {
    A(0, 0),
    B(100, 0),
    C(200, 0),
    D(300, 0),
    E(400, 0),
    F(500, 0),
    G(50, 88),
    H(150, 88),
    I(250, 88),
    J(350, 88),
    K(450, 88),
    L(550, 88),
    M(0, 176),
    N(100, 176),
    O(200, 176),
    P(300, 176),
    Q(400, 176),
    R(500, 176),
    S(50, 264),
    T(150, 264),
    U(250, 264),
    V(350, 264),
    W(450, 264),
    X(550, 264);

    public int x;
    public int y;

    Pegs(int x, int y){
        this.x = x;
        this.y = y;
    }




}
