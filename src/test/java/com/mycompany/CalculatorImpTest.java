/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.concurrent.TimeUnit;
import static jdk.nashorn.internal.objects.Global.Infinity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

/**
 *
 * @author user
 */
public class CalculatorImpTest {

    @Rule
    public TestRule timeout = new Timeout(1, TimeUnit.MINUTES);
    // public TestRule timeout = new Timeout(1, TimeUnit.MILLISECONDS);//выдаст ошибку
    private CalculatorImp calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new CalculatorImp();
    }

    @Test
    public void zeroTest() throws Exception {
        double result = new CalculatorImp().calculate("0");
        assertEquals(0, result, 1e-9);
    }

    /* @Test(timeout = 100)
    public void zeroTest() throws Exception {
        double result = new CalculatorImp().calculate("1");
        assertEquals(0, result, 1e-9);
    }
     */
    
  @Test
    public void Zero() throws Exception {
        double result = new CalculatorImp().calculate("1/0");
        assertEquals(Infinity, result, 1e-9);
    }
    
    @Test
    public void floatingPointTest() throws Exception {
        double result = new CalculatorImp().calculate("-3000.02");
        assertEquals(-3000.02, result, 1e-9);
    }

    @Test
    public void addTest_1() throws Exception {
        double result = new CalculatorImp().calculate("30.4/2");
        assertEquals(15.2, result, 1e-9);
    }

    @Test
    public void addTest_2() throws Exception {
        double result = new CalculatorImp().calculate("(2+2)*1.5/10-444");
        assertEquals(-443.4, result, 1e-9);
    }

    @Test
    public void functionTest() throws Exception {
        double result = new CalculatorImp().calculate("sin(1)*sin(1)+cos(1)*cos(1)");
        assertEquals(1, result, 1e-9);
    }
}
