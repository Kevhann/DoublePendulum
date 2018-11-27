/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.logic;


public class Logic {
    private final Ball lowerBall;
    private final Ball upperBall;
    private final double gravity;
    private double upperAngle;
    private double upperAngleVel;
    private double upperAngleAcc;
    private double lowerAngleAcc;
    private double lowerAngleVel;
    private double lowerAngle;
    
    public Logic(Ball upperBall, Ball lowerBall, double g) {
        this.lowerBall = lowerBall;
        this.upperBall = upperBall;
        this.gravity = g;
        this.upperAngle = upperBall.calculateStartingAngle();
        this.upperAngleVel = 0;
        this.upperAngleAcc = 0;
        this.lowerAngleAcc = 0;
        this.lowerAngleVel = 0;
        this.lowerAngle = lowerBall.calculateStartingAngle(upperBall);
    }
/**
 * Set the x and y location of the balls in according to the angles
 * @param angle1 the angle of the upper ball
 * @param angle2 the angle of the lower ball
 */
    public void setBalls(double angle1, double angle2) {
        
        int x1 = (int) Math.round(this.upperBall.getLength() * Math.sin(angle1));
        int y1 = (int) - Math.round(this.upperBall.getLength() * Math.cos(angle1));
        
        int x2 = (int) (x1 + (Math.round(this.lowerBall.getLength() * Math.sin(angle2))));
        int y2 = (int)  (y1 - (Math.round(this.lowerBall.getLength() * Math.cos(angle2))));
        
        this.upperBall.setXY(x1, y1);
        this.lowerBall.setXY(x2, y2);
        
    }
    public void calculateAcceleration() {
        
        double den = ((2 * upperBall.getMass()) + lowerBall.getMass() - (lowerBall.getMass() * (Math.cos(2 * (upperAngle-lowerAngle)))));
        
        double num1p1 = ((-gravity) * ((2 * upperBall.getMass()) + lowerBall.getMass()) * Math.sin(upperAngle));
        double num1p2 = (lowerBall.getMass() * gravity * Math.sin(upperAngle - (2 * lowerAngle)));
        double num1p3 = (2 * Math.sin(upperAngle - lowerAngle) * lowerBall.getMass());
        double num1p4 = (lowerAngleVel * lowerAngleVel * lowerBall.getLength() + (upperAngleVel * upperAngleVel * upperBall.getLength()) * Math.cos(upperAngle - lowerAngle));
        
        
        this.upperAngleAcc = (num1p1 - num1p2 - (num1p3 * num1p4))/ (den * upperBall.getLength());

        double num2p1 =  2 * Math.sin(upperAngle - lowerAngle);
        double num2p2 = (upperAngleVel * upperAngleVel * upperBall.getLength() * (upperBall.getMass() + lowerBall.getMass()));
        double num2p3 = ( gravity * (lowerBall.getMass() + upperBall.getMass()) * Math.cos(upperAngle));
        double num2p4 = (lowerAngleVel * lowerAngleVel * lowerBall.getLength() * lowerBall.getMass() * Math.cos(upperAngle - lowerAngle));
        this.lowerAngleAcc = (num2p1 * (num2p2 + num2p3 + num2p4)) / ( den * lowerBall.getLength()); 
        
        this.upperAngleVel += this.upperAngleAcc;
        this.upperAngle += this.upperAngleVel;
        
        this.lowerAngleVel += this.lowerAngleAcc;
        this.lowerAngle += this.lowerAngleVel;
                
        setBalls(this.upperAngle, this.lowerAngle);
    }
    public Ball getLowerBall() {
        return lowerBall;
    }
    public Ball getUpperBall() {
        return upperBall;
    }
    public double getLowerAngle() {
        return lowerAngle;
    }
    public double getUpperAngle() {
        return upperAngle;
    }
    public double getUpperAngleVel() {
        return upperAngleVel;
    }
    public double getUpperAngleAcc() {
        return upperAngleAcc;
    }
    public double getLowerAngleAcc() {
        return lowerAngleAcc;
    }
    public double getLowerAngleVel() {
        return lowerAngleVel;
    }
}
