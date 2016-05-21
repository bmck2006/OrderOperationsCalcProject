/*
 * CLASS: BinaryOperator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class creates the binary operator, the superclass for other specific operators.
 */
	
	public abstract class BinaryOperator extends Operator {

	    public BinaryOperator() {
	    }

	    /**
	     * evaluate method: evaluates the operator.
	     */
	    public abstract Operand evaluate(Operand pLhsOperand, Operand pRhsOperand);

	    /**
	     * isBinaryOperator method: 
	     * returns true since all subclasses of BinaryOperator are binary operators.
	     */
	    @Override
	    public boolean isBinaryOperator() {
	        return true;
	    }

	}
