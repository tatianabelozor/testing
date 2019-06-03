/*
 * Интерфейс предназначен для установки методов по-умолчанию
 *классы, реализующие данный интерфейс должны реализовать указанные методы
 */
package com.mycompany;

/**
 *
 * Метод calculate должен принимать на вход данные для вычисления.
 *
 */
public interface Calculator {

    public double calculate(String expression);

}
