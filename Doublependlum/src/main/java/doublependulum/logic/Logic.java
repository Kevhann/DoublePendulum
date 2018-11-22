/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum.logic;


public class Logic {
    private final Ball lowerBall;
    private final Ball upperBall;
    private final double g;
    private final double upperLength;
    private final double lowerLength;
    private double upperAngle;
    private double upperAngleVel;
    private double upperAngleAcc;
    private double lowerAngleAcc;
    private double lowerAngleVel;
    private double lowerAngle;
    private final double lowerMass;
    private final double upperMass;

    public Logic(Ball upperBall, Ball lowerBall, double g) {
        this.lowerBall = lowerBall;
        this.upperBall = upperBall;
        this.g = g;
        this.upperAngle = upperBall.calculateStartingAngle();
        this.upperAngleVel = 0;
        this.upperAngleAcc = 0;
        this.lowerAngleAcc = 0;
        this.lowerAngleVel = 0;
        this.lowerAngle = lowerBall.calculateStartingAngle(upperBall);
        this.lowerMass = lowerBall.getMass();
        this.upperMass = upperBall.getMass();
        this.upperLength = upperBall.getLength();
        this.lowerLength = lowerBall.getLength();
    }
    
    public void setBalls(double angle1, double angle2){
        System.out.println(-Math.round(this.upperLength * Math.cos(angle1)));
        
        int x1 = (int) Math.round(this.upperLength * Math.sin(angle1));
        int y1 = (int) -Math.round(this.upperLength * Math.cos(angle1));
        
        int x2 = (int) (x1 + (Math.round(this.lowerLength * Math.sin(angle2))));
        int y2 = (int)  (y1 - (Math.round(this.lowerLength * Math.cos(angle2))));
        
        this.upperBall.setXY(x1, y1);
        this.lowerBall.setXY(x2, y2);
        
    }
    public void calculateAcceleration(){
        
        double den =((2 * upperMass) + lowerMass - (lowerMass * (Math.cos(2 * (upperAngle-lowerAngle)))));
        
        double num1p1 = ((-g) * ((2 * upperMass) + lowerMass) * Math.sin(upperAngle));
        double num1p2 = (lowerMass * g * Math.sin(upperAngle - (2 * lowerAngle)));
        double num1p3 = (2 * Math.sin(upperAngle - lowerAngle) * lowerMass);
        double num1p4 = ( lowerAngleVel * lowerAngleVel * lowerLength) + (upperAngleVel * upperAngleVel * upperLength * Math.cos(upperAngle - lowerAngle));
        
        
        this.upperAngleAcc = (num1p1 - num1p2 - (num1p3 * num1p4))/ (den * upperLength);

        double num2p1 =  2 * Math.sin(upperAngle - lowerAngle);
        double num2p2 = (upperAngleVel * upperAngleVel * upperLength * (upperMass + lowerMass));
        double num2p3 = ( g * (lowerMass + upperMass) * Math.cos(upperAngle));
        double num2p4 = (lowerAngleVel * lowerAngleVel * lowerLength * lowerMass * Math.cos(upperAngle - lowerAngle));
        this.lowerAngleAcc = (num2p1 * (num2p2 + num2p3 + num2p4)) / ( den * lowerLength);
        
        System.out.println("upper: A: " + upperAngle + " X: " + upperBall.getXlocation() + " Y: " + upperBall.getYlocation() + " L: " + upperLength);
        System.out.println("lower: A: " + lowerAngle + " X: " + lowerBall.getXlocation() + " Y: " + lowerBall.getYlocation() + " L: " + lowerLength);

        
        this.upperAngleVel += this.upperAngleAcc;
        this.upperAngle += this.upperAngleVel;
        
        this.lowerAngleVel += this.lowerAngleAcc;
        this.lowerAngle += this.lowerAngleVel; 
        
                
        setBalls(this.upperAngle, this.lowerAngle);
        
        
    }
    
    public double getLowerLength() {
        return lowerLength;
    }
    public double getUpperLength() {
        return upperLength;
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
    
}
