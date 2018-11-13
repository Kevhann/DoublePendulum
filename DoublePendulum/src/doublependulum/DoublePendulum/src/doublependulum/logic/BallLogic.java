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
public class BallLogic {
    private Ball lowerBall;
    private Ball upperBall;
    private double g;
    private double upperLength;
    private double lowerLength;
    private double upperAngle;
    private double upperAngleVel;
    private double upperAngleAcc;
    private double lowerAngleAcc;
    private double lowerAngleVel;
    private double lowerAngle;
    private double lowerMass;
    private double upperMass;

    public BallLogic(Ball lowerBall, Ball upperBall, double g) {
        this.lowerBall = lowerBall;
        this.upperBall = upperBall;
        this.g = g;
        this.upperLength = Math.sqrt((this.upperBall.getXlocation()) * (this.upperBall.getXlocation()) + (this.upperBall.getYlocation()) * (this.upperBall.getYlocation()));
        this.lowerLength = Math.sqrt(((this.lowerBall.getXlocation() - this.upperBall.getXlocation()) * (this.lowerBall.getXlocation() - this.upperBall.getXlocation())) + (lowerBall.getYlocation() - upperBall.getYlocation()) * (lowerBall.getYlocation() - upperBall.getYlocation()));
        this.upperAngle = Math.asin(this.upperBall.getXlocation() / this.upperLength);
        this.upperAngleVel = 0;
        this.upperAngleAcc = 0;
        this.lowerAngleAcc = 0;
        this.lowerAngleVel = 0;
        this.lowerAngle = Math.asin(((this.lowerBall.getXlocation() - this.upperBall.getXlocation()) / this.lowerLength));
        this.lowerMass = lowerBall.getMass();
        this.upperMass = upperBall.getMass();
    }
    
    public void setBalls(double angle1, double angle2){
        int x1 =(int) Math.round(this.upperLength * Math.sin(angle1));
        int y1 = (int) -Math.round(this.upperLength * Math.cos(angle1));
        
        int x2 = (int) (x1 + Math.round(this.lowerLength * Math.sin(angle2)));
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
        
        this.upperAngleVel += this.upperAngleAcc;
        this.upperAngle += this.upperAngleVel;
        
        this.lowerAngleVel += this.lowerAngleAcc;
        this.lowerAngle += this.lowerAngleVel;
        
        setBalls(this.upperAngle, this.lowerAngle);  
    }    
}
