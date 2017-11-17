package comp1110.ass2;

/**
 * A following class which describes, All the possible properties of the indexes.
 */
public enum Shape {

    RING_0(0, "r"),
    RING_60(60, "r"),
    RING_120(120, "r"),
    RING_180(180, "r"),
    RING_240(240, "r"),
    RING_300(300, "r"),
    BALL_0(0, "b"),
    BALL_60(60, "b"),
    BALL_120(120, "b"),
    BALL_180(180, "b"),
    BALL_240(240, "b"),
    BALL_300(300, "b"),
    FULL_RING(999, "r"),
    HALFRING_0_60(0, 60, "r"),
    HALFRING_60_120(60, 120, "r"),
    HALFRING_120_180(120, 180, "r"),
    HALFRING_180_240(180, 240, "r"),
    HALFRING_240_300(240, 300, "r"),
    HALFRING_300_0(300, 0, "r"),
    HALFRING_60_0(60, 0, "r"),
    HALFRING_120_60(120, 60, "r"),
    HALFRING_180_120(180, 120, "r"),
    HALFRING_240_180(240, 180, "r"),
    HALFRING_300_240(300, 240, "r"),
    HALFRING_0_300(0, 300, "r");

    public int degree;
    public int x;
    String description;

    Shape(int degree, int x, String description) {
        this.degree = degree;
        this.x = x;
        this.description = description;
    }

    Shape(int degree, String description) {
        this.degree = degree;
        this.description= description;
    }

}