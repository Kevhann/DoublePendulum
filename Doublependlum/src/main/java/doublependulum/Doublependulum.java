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
import static javafx.application.Application.launch;

/**
 *
 * @author kevhann
 */
public class Doublependulum{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Drawing dr = new Drawing();
        dr.compile(args);
//        UI ui = new UI();
//        ui.compile(args);
    }
    public static void initializeLogic(int upperMass,int upperX,int upperY,int lowerMass,int lowerX,int lowerY,double gravity){
        Drawing dr = new Drawing();
        Ball upper = new Ball(upperMass,upperX,upperY);
        Ball lower = new Ball(upper,lowerMass,lowerX,lowerY);
        dr.setLogic(new Logic(upper,lower,gravity));
    }
    
}
