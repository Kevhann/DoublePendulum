package doublependulum.graphics;

import doublependulum.logic.Ball;
import doublependulum.logic.Logic;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * @author kevhann
 * Draw the pendulum on a 2d canvas.
 * A separate 2d canvas contains the trace of the lower ball.
 */
public class Drawing {
    private Logic logic;

    /**
     * Start the simulation by creating the window
     */
    public void start() {
        Stage pendulums = new Stage();
        final int leveys = 1000;
        final int korkeus = 800;
        final int xoffset = leveys / 2;
        final int yoffset = 200;
        Line upperLine = new Line();
        Line lowerLine = new Line();
        upperLine.setTranslateX(xoffset);
        upperLine.setTranslateY(yoffset);
        lowerLine.setTranslateX(xoffset);
        lowerLine.setTranslateY(yoffset);
        
        pendulums.setTitle("DoublePendulum");

        Group root = new Group();
        Scene doublependulum = new Scene(root);
        pendulums.setScene(doublependulum);

        Canvas drawingTable = new Canvas(leveys, korkeus);
        Canvas shadowTable = new Canvas(leveys, korkeus);
        root.getChildren().addAll(shadowTable, drawingTable, upperLine, lowerLine);

        GraphicsContext drawer = drawingTable.getGraphicsContext2D();
        GraphicsContext shadowDrawer = shadowTable.getGraphicsContext2D();
        shadowDrawer.setFill(Color.BLACK);
        drawer.clearRect(0, 0, leveys, korkeus);
        drawer.translate(xoffset, yoffset);
        shadowDrawer.translate(xoffset, yoffset);
        shadowDrawer.fillOval(-5, -5, 10, 10);
        
        new AnimationTimer() {
            private final long sleepNanoseconds = 5 * 1000000;
            private long prevTime = 0;
            public void handle(long currentNanoTime) {
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }
                drawer.clearRect(-xoffset, -yoffset, leveys, korkeus);
                
                drawLines(logic.getUpperBall(), logic.getLowerBall(), upperLine, lowerLine);
                
                drawer.setFill(Color.FIREBRICK);
                drawer.fillOval(logic.getUpperBall().getXlocation(), logic.getUpperBall().getYlocation(), logic.getUpperBall().getMass(), logic.getUpperBall().getMass());
                
                drawer.fillOval(logic.getLowerBall().getXlocation(), logic.getLowerBall().getYlocation() , logic.getLowerBall().getMass(), logic.getLowerBall().getMass());
                shadowDrawer.fillOval(logic.getLowerBall().getXlocation() + (logic.getLowerBall().getMass() / 2), logic.getLowerBall().getYlocation() + (logic.getLowerBall().getMass() / 2), 2, 2);
                
                logic.calculateAcceleration(); 
                prevTime = currentNanoTime;
            }
        }.start();
        pendulums.show();
    }

    /**
     * Draw the lines connecting the balls
     * @param upper the parent ball 
     * @param lower the child ball
     * @param upperLine the line connecting the parent ball to the origin
     * @param lowerLine the line connecting the child ball to the parent ball
     */
    public void drawLines(Ball upper, Ball lower, Line upperLine, Line lowerLine) {
        upperLine.setEndX(logic.getUpperBall().getXlocation()  + logic.getUpperBall().getMass() / 2);
        upperLine.setEndY(logic.getUpperBall().getYlocation() + logic.getUpperBall().getMass() / 2);

        lowerLine.setStartX(logic.getUpperBall().getXlocation() + logic.getUpperBall().getMass() / 2);
        lowerLine.setStartY(logic.getUpperBall().getYlocation() + logic.getUpperBall().getMass() / 2);
        lowerLine.setEndX(logic.getLowerBall().getXlocation() + logic.getLowerBall().getMass() / 2);
        lowerLine.setEndY(logic.getLowerBall().getYlocation() + logic.getLowerBall().getMass() / 2);
    }
    
    /**
     * Create an instance of logic from the given parameters. This is the logic that runs the simulation.
     * Place the balls on their starting positions.
     * @param upper the parent ball
     * @param lower the child ball
     * @param gravity the gravity of the simulation
     */
    public void initializeLogic(Ball upper, Ball lower, double gravity) {
        this.logic = new Logic(upper, lower, gravity);
        logic.setBalls(upper.calculateStartingAngle(), lower.calculateStartingAngle(upper));
    }
}