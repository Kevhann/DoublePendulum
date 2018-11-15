/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicTests;

import doublependulum.logic.Ball;
import doublependulum.logic.Logic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eben
 */
public class LogicTest {
    Ball upper1;
    Ball upper2;
    Ball lower1;
    Ball lower2;
    Logic logic1;
    Logic logic2;
    double g;
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = 0.4;
        upper1 = new Ball(10,30,40);
        lower1 = new Ball(10,30,140);
        logic1 = new Logic(upper1,lower1,g);
        upper2 = new Ball(10,80,150);
        lower2 = new Ball(10,80,150);
        logic2 = new Logic(upper2,lower2,g);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ballsHaveCorrectLength1(){
        assertEquals(100.0,logic1.getLowerLength(),0.0001);
        assertEquals(50.0,logic1.getUpperLength(),0.0001);
        assertEquals(170.0,logic2.getUpperLength(),0.0001);
        assertEquals(0.0,logic2.getLowerLength(),0.0001);
    }
}
