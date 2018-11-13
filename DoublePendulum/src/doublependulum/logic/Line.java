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
public class Line {
    public Ball ball;
    public int startx;
    public int starty;
    public int length;
    

    public Line(int startx, int starty, int length) {
        this.startx = startx;
        this.starty = starty;
        this.length = length;
        
    }
    public Line(Ball ball, int length){
        this.startx = ball.getXlocation();
        this.starty = ball.getYlocation();
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    
    
}
