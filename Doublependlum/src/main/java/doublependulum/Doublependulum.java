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
        UI ui = new UI();
        
        Drawing dr = new Drawing();
        ui.compile(args);
        
    }
    
}
