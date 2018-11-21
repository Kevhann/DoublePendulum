/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import doublependulum.logic.Ball;
import doublependulum.logic.Logic;


/**
 *
 * @author kevhann
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
        lower1 = new Ball(upper1,10,0,100);
        logic1 = new Logic(upper1,lower1,g);
        upper2 = new Ball(10,80,150);
        lower2 = new Ball(upper2,10,-123,-123);
        logic2 = new Logic(upper2,lower2,g);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ballsHaveCorrectLength1(){
        assertEquals(100.0,logic1.getLowerLength(),0.0001);
        assertEquals(50.0,logic1.getUpperLength(),0.0001);
    }
    @Test
    public void ballsHaveCorrectLength2(){
        assertEquals(170.0,logic2.getUpperLength(),0.0001);
        assertEquals(173.94827,logic2.getLowerLength(),0.0001);
    }
    @Test
    public void ballsHaveCorrectAngle1(){
        assertEquals(2.57695,logic1.getUpperAngle(),0.0001);
        assertEquals(Math.PI,logic1.getLowerAngle(),0.0001);
    }
    @Test
    public void ballsHaveCorrectAngle2(){
        assertEquals(2.68818,logic2.getUpperAngle(),0.0001);
        assertEquals(-0.64963,logic2.getLowerAngle(),0.0001);
    }
}
