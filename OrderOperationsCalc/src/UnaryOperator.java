/*
 * CLASS: UnaryOperator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This is the superclass of all unary operators. 
 */
public abstract class UnaryOperator extends Operator {

    public UnaryOperator() {
    }
    
    /**
     * evaluate method:
     */
    public abstract Operand evaluate(Operand pOperand);

    /**
     * isBinaryOperator method:
     */
    @Override
    public boolean isBinaryOperator() {
        return false; //always false because a unary operator is not a binary operator. 
    }

}
