/*
 * CLASS: Negation Operator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents the negation operator, which is a subclass of UnaryOperator.
 */
public class NegationOperator extends UnaryOperator {
    public NegationOperator() {
    }

    /**
     * evaluate method:
     * Returns the product of the left-hand side operand and the right-hand side operand.
     */
    @Override
    public Operand evaluate(Operand pOperand) {
        return new Operand(pOperand.getValue()* -1);
    }

    /**
     * precedence method:
     * Returns the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 4;
    }

    /**
     * stackPrecedence method:
     * Returns the precedence level of this operator when on the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 4;
    }

}
