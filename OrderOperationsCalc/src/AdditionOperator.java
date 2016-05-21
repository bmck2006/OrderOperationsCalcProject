/*
 * CLASS: AdditionOperator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class creates the addition operator, a subclass of BinaryOperator
 */
	public class AdditionOperator extends BinaryOperator {

	    public AdditionOperator() { 
	    }

	   /*
	    * evaluate method: evaluates the left and right hand side operands
	    */
	    @Override
	    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
	        return new Operand(pLhsOperand.getValue() + pRhsOperand.getValue());
	    }

	    
	   /*
	    * precedence method: Returns the normal precedence level of this operator.
	    */
	    @Override
	    public int precedence() {
	        return 2;
	    }

	    /**
	     * stackPrecedence method: 
	     * Returns the precedence level of this operator when on it's on the operator stack.
	     */
	    @Override
	    public int stackPrecedence() {
	        return 2;
	    }
}
