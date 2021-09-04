package org.study.java;

import java.util.Map;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    CLEAR("c"),
    EXIT("s");

    private final String value;

    public String getValue() { return value; }

    Operator(String value) { this.value = value; }

    private final static Map<String, Operator> operatorsMap = Map.of(
            PLUS.getValue(), PLUS,
            MINUS.getValue(), MINUS,
            MUL.getValue(), MUL,
            DIV.getValue(), DIV,
            CLEAR.getValue(), CLEAR,
            EXIT.getValue(), EXIT
    );

    public static String allValues() {
        return String.join("", operatorsMap.keySet());
    }

    public static Operator find(String value) {
        return operatorsMap.get(value);
    }
}
