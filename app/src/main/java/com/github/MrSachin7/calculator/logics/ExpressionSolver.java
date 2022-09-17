package com.github.MrSachin7.calculator.logics;

import java.util.Stack;

public class ExpressionSolver {
    public static double evaluate(String expression){

        // Stacks for oprators and operands
        Stack<Integer> operator = new Stack<>();
        Stack<Double> value = new Stack<>();

        // Temp stacks for operators and value
        Stack<Integer> tempOperators = new Stack<>();
        Stack<Double> tempValue = new Stack<>();

        expression = "0"+ expression;
        expression = expression.replaceAll("-" , "+-");

        // Store operators and operands
        String temp ="";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch =='-'){
                temp ="-"+ temp;
            } else if (ch!='+' && ch!= '*' && ch!= '/'){
                temp = temp+ch;
            }
            else{
                value.push(Double.parseDouble(temp));
                operator.push((int) ch);
                temp ="";
            }
        }
        value.push(Double.parseDouble(temp));

        // Operator precedence
        char operators[] = {'/', '*', '+'};

        // Evaluation

        for (int i = 0; i < 3; i++) {
            boolean it = false;

            while (!operator.isEmpty()){
                int optr = operator.pop();
                double v1 = value.pop();
                double v2 = value.pop();

                if (optr == operators[i]){
                    // if operator matches evaluate and store in the temp stack

                    if (i==0){
                        tempValue.push(v2/v1);
                        it = true;
                        break;
                    }else if(i ==1){
                        tempValue.push(v2*v1);
                        it = true;
                        break;
                    } else if (i ==2){
                        tempValue.push(v2+v1);
                        it= true;
                        break;
                    }
                }
                else{
                    tempValue.push(v1);
                    value.push(v2);
                    tempOperators.push(optr);

                }
            }
            while(!tempValue.isEmpty()){
                value.push(tempValue.pop());
            }
            while(!tempOperators.isEmpty()){
                operator.push(tempOperators.pop());
            }

            // Iterate again for the same operator
            if (it){
                i--;
            }

        }
        return value.pop();
    }

}
