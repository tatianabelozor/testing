/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import java.io.StringReader;
import org.junit.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author user
 */
public class CalculatorCliTest {

    private Calculator calculatorMock;
    private CalculatorCli calculatorCli;

    public CalculatorCliTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        calculatorMock = Mockito.mock(Calculator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void emptyExpressionsMustBeSkipped() {
        calculatorCli.runInteractiveSession(new StringReader(";\n;   ;;;\t\n;"));
        Mockito.verifyZeroInteractions(calculatorMock);
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }

    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated_2() {
        when(calculatorMock.calculate("1")).thenReturn(1d);
        when(calculatorMock.calculate("2")).thenReturn(2d);
        when(calculatorMock.calculate("3")).thenReturn(3d);

        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }
}
