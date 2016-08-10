package org.chabala.example;

public class Calculator {
    private double operand1, operand2, result;

    public void setOperand1(double o) {
        operand1 = o;
    }

    public void setOperand2(double o) {
        operand2 = o;
    }

    public void add() {
        result = operand1 + operand2;
    }

    public double getResult() {
        return result;
    }
}