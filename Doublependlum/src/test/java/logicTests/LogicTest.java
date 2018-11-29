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
    Ball upper3;
    Ball lower1;
    Ball lower2;
    Ball lower3;
    Logic logic1;
    Logic logic2;
    Logic logic3;
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
        lower1 = new Ball(upper1,20,0,100);
        logic1 = new Logic(upper1,lower1,g);
        upper2 = new Ball(10,80,150);
        lower2 = new Ball(upper2,10,-123,-123);
        logic2 = new Logic(upper2,lower2,g);
        upper3 = new Ball(10,-66,150);
        lower3 = new Ball(upper3,10,-123,123);
        logic3 = new Logic(upper3,lower3,g);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ballsHaveCorrectLength1(){
        assertEquals(50.0,logic1.getUpperBall().getLength(), 0.0001);
        assertEquals(100.0,logic1.getLowerBall().getLength(), 0.0001);
    }
    @Test
    public void ballsHaveCorrectLength2(){
        assertEquals(170.0,logic2.getUpperBall().getLength(), 0.0001);
        assertEquals(173.94827,logic2.getLowerBall().getLength(), 0.0001);
    }
    @Test
    public void ballsHaveCorrectAngle1(){
        assertEquals(2.57695,logic1.getUpperAngle(), 0.0001);
        assertEquals(Math.PI,logic1.getLowerAngle(), 0.0001);
    }
    @Test
    public void ballsHaveCorrectAngle2(){
        assertEquals(2.68818,logic2.getUpperAngle(), 0.0001);
        assertEquals(-0.64963,logic2.getLowerAngle(), 0.0001);
    }
    @Test
    public void ballsHaveCorrectAngle3(){
        assertEquals(-2.74965,logic3.getUpperAngle(), 0.0001);
        assertEquals(-2.49195,logic3.getLowerAngle(), 0.0001);
    }
    @Test
    public void correctAngleAccelerationCalculation(){
        logic1.calculateAcceleration();
        assertEquals(-0.00816607358,logic1.getUpperAngleAcc(), 0.0000001);
        assertEquals(0.00344926770,logic1.getLowerAngleAcc(), 0.0000001);
    }
    @Test
    public void ballsMoveCorrectlyWithSetXY(){
        assertEquals(30, upper1.getXlocation());
        assertEquals(-40, upper1.getYlocation());
        assertEquals(30, lower1.getXlocation());
        assertEquals(-140, lower1.getYlocation());
        upper1.setXY(-55, 55);
        lower1.setXY(123, 123);
        assertEquals(-55, upper1.getXlocation());
        assertEquals(-55, upper1.getXlocation());
        assertEquals(123, lower1.getXlocation());
        assertEquals(-123, lower1.getYlocation());

    }
    
}
