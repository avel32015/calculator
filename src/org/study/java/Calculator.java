package org.study.java;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        while (calculator.execute()) { }
    }

    private Scanner input = new Scanner(System.in);
    private Double result = 0d;

    private final Pattern operPattern = Pattern.compile(String.format("[%s]",
            Operator.allValues().replace("-", "\\-")));

    boolean execute() {
        Request request = getRequest();
        if (request.isValid()) {
            doResponse(request);
        }
        return request.getOperator() != Operator.EXIT;
    }

    private Request getRequest() {
        message("Введите выражение:");
        Request request = new Request();

        if (input.hasNextDouble()) {
            request.setArgumentA(input.nextDouble());
        } else {
            request.setArgumentA(result);
        }

        boolean needArgument = false;
        String oper = input.findWithinHorizon(operPattern, 0);
        if (oper != null) {
            request.setOperator(Operator.find(oper));
            needArgument = !request.isValid();
        } else {
            message("Оператор не определен");
        }

        if (needArgument) {
            if (input.hasNextDouble()) {
                request.setArgumentB(input.nextDouble());
            } else {
                message("Аргумент не определен");
            }
        }

        input.nextLine();

        return request;
    }

    private void doResponse(Request request) {
        switch (request.getOperator()) {
            case PLUS:
                 setResult(request.getArgumentA() + request.getArgumentB());
                 break;
            case MINUS:
                setResult(request.getArgumentA() - request.getArgumentB());
                break;
            case MUL:
                setResult(request.getArgumentA() * request.getArgumentB());
                break;
            case DIV:
                if (request.getArgumentB() == 0) {
                    setResult(Double.NaN);
                } else {
                    setResult(request.getArgumentA() / request.getArgumentB());
                }
                break;
            case CLEAR:
                setResult(0d);
                break;
        }
    }

    private void setResult(Double result) {
        this.result = result;
        message(String.format("Результат: %s", result));
    }

    private void message(String text) {
        System.out.println(text);
    }
}
