/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.logic;

/**
 *
 * @author kevhann
 */
public class Ball {
    private int xlocation;
    private int ylocation;
    final private double mass;
    final private double length;
/**
 * Create a ball which tracks it's x and y location
 * @param mass the mass of the ball
 */
    public Ball(double mass, int x, int y) {
        this.mass = mass;
        this.xlocation = x;
        this.ylocation = y;
        this.length = Math.sqrt((x * x) + (y * y));
    }
    public Ball(Ball ball, double mass, int x, int y) {
        this.mass = mass;
        this.xlocation = x + ball.getXlocation();
        this.ylocation = y - ball.getYlocation();
        this.length = Math.sqrt((x * x) + (y * y));
    }
    public double calculateStartingAngle(){
        double angle = Math.sin(xlocation / length);
        if (ylocation > 0){
            if (xlocation < 0){
                return -((Math.PI) + angle);
            } else {
                return ((Math.PI) - angle);
            }
        }
        return angle;
    }
    public double calculateStartingAngle(Ball ball){
        double angle = Math.sin(((xlocation - ball.getXlocation())/ length));
        if (ylocation > 0){
            if (xlocation < ball.getXlocation()){
                return -((Math.PI) + angle);
            } else {
                return ((Math.PI) - angle);
            }
        }
        return angle;
    }

    public double getMass() {
        return mass;
    }
    public void setXY(int x, int y){
        this.xlocation = x;
        this.ylocation = y;
    }
    public int getXlocation() {
        return xlocation;
    }
    public int getYlocation() {
        return -ylocation;
    }
    public double getLength() {
        return length;
    }
}
