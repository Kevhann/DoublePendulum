package doublependulum.logic;

/**
 * The ball of the simulation.
 * Has specified x and y coordinates, mass and length from its starting position.
 */
public class Ball {
    private int xlocation;
    private int ylocation;
    final private double mass;
    final private double length;
    
    /**
     * Create a parent ball which tracks it's x and y location
     * @param x the x location of the ball
     * @param y the y location of the ball. Y location increases upwards.
     * @param mass the mass of the ball
     */
    public Ball(double mass, int x, int y) {
        this.mass = mass;
        this.xlocation = x;
        this.ylocation = y;
        this.length = Math.sqrt((x * x) + (y * y));
    }
    /**
    * Create a child ball with it's x and y location in relation
    * to the parent ball.
    * @param ball the parent ball.
    * @param mass the mass of the ball.
    * @param x the x location of the ball in relation to the parent ball.
    * @param y the y location of the ball in relation to the parent ball. Y location increases upwards.
    */
    public Ball(Ball ball, double mass, int x, int y) {
        this.mass = mass;
        this.xlocation = x + ball.getXlocation();
        this.ylocation = y - ball.getYlocation();
        this.length = Math.sqrt((x * x) + (y * y));
    }

    /**
     * Calculates the starting angle for the parent ball in relation to a vertical line from the given user inputs.
     * @return angle from -PI to PI. Positive angle is counter clockwise.
     */
    public double calculateStartingAngle() {
        double angle = Math.sin(xlocation / length);
        if (ylocation > 0) {
            if (xlocation < 0) {
                return -(Math.PI + angle);
            } else {
                return (Math.PI - angle);
            }
        }
        return angle;
    }

    /**
     * Calculates the starting angle for the child ball in relation to a vertical line from the user inputs.
     * @param ball the parent ball
     * @return angle from -PI to PI. Positive angle is counter clockwise.
     */
    public double calculateStartingAngle(Ball ball) {
        double angle = Math.sin(((xlocation - ball.getXlocation()) / length));
        if (ylocation + ball.getYlocation() > 0) {
            if (xlocation < ball.getXlocation()) {
                return -(Math.PI + angle);
            } else {
                return (Math.PI - angle);
            }
        }
        return angle;
    }

    public double getMass() {
        return mass;
    }

    /**
     * Set the x and y coordinates for the ball
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setXY(int x, int y) {
        this.xlocation = x;
        this.ylocation = y;
    }
    public int getXlocation() {
        return xlocation - (int) (mass / 2);
    }
    public int getYlocation() {
        return -ylocation - (int) (mass / 2);
    }
    public double getLength() {
        return length;
    }
}
