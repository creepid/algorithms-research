/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author rusakovich
 */
public class DijkstrasSimple {

    private static final String TOKEN = " ";

    private final String expression;

    private final Stack<String> operations = new Stack<>();
    private final Stack<Double> vals = new Stack<>();

    public DijkstrasSimple(String expression) {
        this.expression = expression;
        this.parse();
    }

    private void calculate() {
        String operationLast = operations.pop();
        double valueLast = vals.pop();

        switch (operationLast) {
            case "+":
                valueLast = vals.pop() + valueLast;
                break;
            case "-":
                valueLast = vals.pop() - valueLast;
                break;
            case "*":
                valueLast = vals.pop() * valueLast;
                break;
            case "/":
                valueLast = vals.pop() / valueLast;
                break;
            case "sqrt":
                valueLast = Math.sqrt(valueLast);
                break;
        }

        vals.push(valueLast);
    }

    private void parse() {
        StringTokenizer tokenizer = new StringTokenizer(expression, TOKEN);
        while (tokenizer.hasMoreElements()) {
            String element = tokenizer.nextToken();

            switch (element) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operations.push(element);
                    break;
                case ")":
                    calculate();
                    break;
                default:
                    vals.push(Double.parseDouble(element));
            }
        }
    }

    public double getResult() {
        return vals.pop();
    }

}
