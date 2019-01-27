package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.LinkedStack;
import edu.isu.cs.cs3308.structures.Stack;
import static java.lang.Integer.parseInt;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 */
public class PostFix {

    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @author Andrew Aikens
     * @param infix A string representing an postfix notation expression where
     * each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix) {
        if(infix == null || infix.isEmpty() || infix.trim().isEmpty())
            return 0;
        Stack<String> postFix = new LinkedStack<>();
        String[] str = infix.split(" ");
        for (String s : str)
            postFix.push(s);
        return evaluate(postFix);
    }

    /**
     *  Evaluates the provided postfix Stack<String> or throws exceptions for
     *  improper/unsupported operands or if there are too few expressions for provided operands.
     *
     * @author Andrew Aikens
     * @param stack The stack representing a postfix notation expression with the top
     * being the final operand.
     * @return result of the postfix expression.
     */
    private static int evaluate(Stack<String> stack){
        if(stack == null || stack.isEmpty())
            throw new IllegalArgumentException("Too few expressions for a given operator.");
        String op = stack.pop();
        if(op.matches("-?\\d+"))
            return parseInt(op);
        int pexp1;
        int pexp2;
        switch (op) {
            case "+":
                pexp1 = evaluate(stack);
                pexp2 = evaluate(stack);
                return pexp2 + pexp1;
            case "-":
                pexp1 = evaluate(stack);
                pexp2 = evaluate(stack);
                return pexp2 - pexp1;
            case "*":
                pexp1 = evaluate(stack);
                pexp2 = evaluate(stack);
                return pexp2 * pexp1;
            case "/":
                pexp1 = evaluate(stack);
                pexp2 = evaluate(stack);
                return pexp2 / pexp1;
            default :
                throw new IllegalArgumentException("Unsupported operator.");

        }
    }
}
