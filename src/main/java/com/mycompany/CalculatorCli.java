/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

/**
 *
 * Командный интерфейс, принимающий значения из консоли, которые вводит пользователь.
 * Вызывает класс CalculatorImp.
 * Вызывает интерактивную сессию. Работает с потоками(stream Reader). 
 */
public class CalculatorCli {

    private final Calculator calculator;

    public CalculatorCli(Calculator calculator) {
        this.calculator = calculator;
    }

 /**
  * Вызов интерактивной сессии
  * @param reader 
  */
    public void runInteractiveSession(Reader reader) {
        runInteractiveSession(reader, System.out::println);
    }
/**
 * Сессия, проверяюшая действия пользователя.
 * @param reader
 * @param resultConsumer 
 */
    public void runInteractiveSession(Reader reader, DoubleConsumer resultConsumer) {
        new BufferedReader(reader).lines()
                .flatMap(s -> Stream.of(s.split(";")))
                .filter(s -> !s.trim().isEmpty())
                .mapToDouble(calculator::calculate)
                .forEach(resultConsumer);
    }

    public static void main(String[] args) throws Exception {
        CalculatorCli calcolatorCli = new CalculatorCli(new CalculatorImp());
        try (Reader reader = new InputStreamReader(System.in)) {
            calcolatorCli.runInteractiveSession(reader);
        }

    }

}
