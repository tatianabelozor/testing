/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * Класс, который будет заниматься вычислениями:метод calculate отвечает за
 * деление на ноль, операциями с отрицательными числами и числами с плавающей
 * точкой, * Тип строка(String) используется для вычисления.
 */
public class CalculatorImp implements Calculator {

    /**
     *
     * Отвечает за деление на ноль, вычиления с плавающей точкой, работа с
     * функциями, сложные вычисления
     */
    @Override

    public double calculate(String expression) {

        // throw new UnsupportedOperationException();
        //return 0;
        //return Double.parseDouble(expression);
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            defineMathFunctions(scriptEngine);
            return ((Number) scriptEngine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Failed to evaluate expression", e);
        }
    }

    /**
     * 
     *  Метод defineMathFunctions вычисляет значения функций.
     * @param scriptEngine
     * @throws ScriptException 
     */
    private static void defineMathFunctions(ScriptEngine scriptEngine) throws ScriptException {
        for (String function : new String[]{"sin", "cos", "sqrt"}) {
            scriptEngine.eval("function " + function + "(x){return Java.type('java.lang.Math')." + function + "(x);}");
        }
    }
}
