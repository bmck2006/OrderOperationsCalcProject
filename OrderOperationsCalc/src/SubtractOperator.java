/*
 * CLASS: SubtractOperator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents the subtraction operator which is a subclass of BinaryOperator
 */
public class SubtractOperator extends BinaryOperator {

    public SubtractOperator() {
    }

    /**
     * evaluate method:
     * Returns the difference of the left-hand side operand and the right-hand side operand.
     */
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() - pRhsOperand.getValue());
    }

    /**
     * precedence method:
     * Returns the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 2;
    }

    /**
     * stackPrecedence method:
     * Returns the precedence level of this operator when on the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 2;
    }

}