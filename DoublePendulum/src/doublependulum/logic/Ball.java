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
    private double mass;
    private int radius;
/**
 * Create a ball which tracks it's x and y location
 * @param mass the mass of the ball
 */
    public Ball(double mass, int x, int y) {
        this.mass = mass;
        this.radius = (int) mass * 20;
        this.xlocation = x;
        this.ylocation = -y;
       }

    public double getMass() {
        return mass;
    }
    public void setXY(int x, int y){
        this.xlocation = x;
        this.ylocation = -y;
    }

    public int getXlocation() {
        return xlocation;
    }

    public int getYlocation() {
        return ylocation;
    }

    public int getRadius() {
        return radius;
    }
    
    
}
