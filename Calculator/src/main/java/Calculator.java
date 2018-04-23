import java.util.List;
import java.util.Stack;

public class Calculator implements ICalculator {

    public float add(float per1, float per2) {
        return per1 + per2;
    }

    public float sub(float per1, float per2) {
        return per1 - per2;
    }

    public float mul(float per1, float per2) {
        return per1 * per2;
    }

    public float div(float per1, float per2) {
        if (per2 == 0) throw new ArithmeticException("Деление на ноль!");
        return per1 / per2;
    }

    //вычисление вырожения
    public float evaluationOfExpression(List<String> polStr) {
        Stack<Float> stack = new Stack<Float>();
        for (String el : polStr) {
            if (el.equals("+"))
                stack.push(add(stack.pop(), stack.pop()));
            else if (el.equals("-")) {
                float per2 = stack.pop(), per1 = stack.pop();
                stack.push(sub(per1, per2));
            }
            else if (el.equals("*"))
                stack.push(mul(stack.pop(), stack.pop()));
            else if (el.equals("/")) {
                float per2 = stack.pop(), per1 = stack.pop();
                stack.push(div(per1, per2));
            }
            else if (el.equals("u-")) stack.push(-stack.pop());
            else stack.push(Float.valueOf(el));
        }
        return stack.pop();
    }
}

