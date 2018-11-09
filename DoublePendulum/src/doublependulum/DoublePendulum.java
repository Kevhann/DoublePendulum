/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum;

import doublependulum.graphics.Drawing;
import doublependulum.logic.Ball;
import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author kevhann
 */
public class DoublePendulum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Simple Sketching Program");
        frame.getContentPane().add(new Drawing(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);;
        
    }
    
}
