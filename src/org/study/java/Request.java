package org.study.java;

public class Request {

    private Operator operator;

    private Double argumentA;

    private Double argumentB;

    public Operator getOperator() { return operator; }

    public void setOperator(Operator operator) { this.operator = operator; }

    public Double getArgumentA() {
        return argumentA;
    }

    public void setArgumentA(Double argumentA) { this.argumentA = argumentA; }

    public Double getArgumentB() {
        return argumentB;
    }

    public void setArgumentB(Double argumentB) { this.argumentB = argumentB; }

    public boolean isValid() {
        return operator == Operator.CLEAR
            || operator == Operator.EXIT
            || (operator != null && argumentA != null && argumentB != null);
    }

}
