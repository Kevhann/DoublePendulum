/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum;

import doublependulum.UI.UI;
import doublependulum.graphics.Drawing;
import doublependulum.logic.Ball;
import doublependulum.logic.Logic;

/**
 *
 * @author kevhann
 */
public class Doublependulum{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launchBalls(args);
        UI ui = new UI();
        ui.compile(args);
    }
    public static void launchBalls(String[] args){
        Ball upper = new Ball(20,50,50);
        Ball lower = new Ball(upper,20,50,50);
        Logic logic = new Logic(upper,lower,0.5);
        Drawing dr = new Drawing();
        dr.compile(args);
    }
    
}
