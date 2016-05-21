/*
 * CLASS: Multiply Operator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents an the multiply operator which is a subclass of BinaryOperator.
 */
public class MultiplyOperator extends BinaryOperator {
    public MultiplyOperator() {
    }

    /**
     * evaluate method:
     * Returns the product of the left-hand side operand and the right-hand side operand.
     */
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() * pRhsOperand.getValue());
    }

    /**
     * precedence method:
     * Returns the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 3;
    }

    /**
     * stackPrecedence method:
     * Returns the precedence level of this operator when on it is on the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 3;
    }

}