/*
 * CLASS: Expression
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents an inserted expression to be evaluated.
 */
public class Expression {

	    /**
	     * A queue which stores the tokens of the infix expression in the order in which they were input.
	     */
	   private Queue<Token> mTokenQueue;

	    /**
	     * Constructor:
	     *pExprStr is a string representing an infix expression, such as "(1 + 2) * -3". 
	     * uses the tokenizer class to break the string into 
	     * Token objects which are stored in the token queue instance
	     * variable
	     */
	    public Expression(String pExprStr) {
	    	setTokenQueue(new Queue<Token>());
	    	Tokenizer tokenizer = new Tokenizer(pExprStr);
	    	Token prevToken = null;
	    	Token token = tokenizer.nextToken();
	    	while (token != null) {
	    		if (token instanceof SubtractOperator) {
	    			token = negationCheck(token, prevToken);
	    		}
	    		getTokenQueue().enqueue(token);
	    		prevToken = token;
	    		token = tokenizer.nextToken();
	    	}
	    }

	    /**
	     * evaluate method:
	     * Evaluates the expression,returns a double.
	     */
	    public Double evaluate() {
	    	Stack<Operator> operatorStack = new Stack<>();
	    	Stack<Operand> operandStack = new Stack<>();
	    	
	    	while(!getTokenQueue().isEmpty()){
	    		Token token = getTokenQueue().dequeue();
	    		if(token instanceof Operand) {
	    			operandStack.push((Operand) token);
	    		}
	    		else 
	    			if (token instanceof LeftPar) {
	    				operatorStack.push((LeftPar) token);
	    		}
	    			else
	    				if (token instanceof RightPar) {
	    					while (!(operatorStack.peek() instanceof LeftPar)) {
	    						topEval(operatorStack, operandStack);
	    					}
	    					operatorStack.pop();
	    				}
	    				else {
	    					Operator operator = (Operator) token;
	    					
	    					while (keepEvaluating(operatorStack, operator)) {
	    						topEval(operatorStack, operandStack);
	    					}
	    					operatorStack.push(operator);
	    				}
	    	}
	    	while (!operatorStack.isEmpty()) {
	    		topEval(operatorStack, operandStack);
	    	}
	    	return operandStack.pop().getValue();
	    }

	    /**
	     * Accessor method.
	     */
	    protected Queue<Token> getTokenQueue() {
	        return mTokenQueue;
	    }

	    /**
	     * keepEvaluating method:
	     * 
	     * Returns true when need to pop the operator to top of the operator stack and evaluate it. If the stack
	     * is empty, returns false since there is no operator to pop. Otherwise, return true if the operator on top
	     * of the operator stack has stack precedence greater than or equal to the normal precedence of pOperator.
	     */
	    private boolean keepEvaluating(Stack<Operator> pOperatorStack, Operator pOperator) {
	        if (pOperatorStack.isEmpty()) return false;
	        else return pOperatorStack.peek().stackPrecedence() >= pOperator.precedence();
	    }

	    /**
	     * negationCheck method:
	     * 
	     * Checks to see if operator is a negation and not a subtraction
	     */
	    private Token negationCheck(Token pToken, Token pPrevToken) {
	        if (pPrevToken == null || pPrevToken instanceof BinaryOperator || pPrevToken instanceof LeftPar) {
	            pToken = new NegationOperator();
	        }
	        return pToken;
	    }

	    /**
	     * setTokenQueue method
	     * 
	     * Mutator method for mTokenQueue.
	     */
	    protected void setTokenQueue(Queue<Token> pTokenQueue) {
	        mTokenQueue = pTokenQueue;
	    }

	    /**
	     * topEval method;
	     *
	     * Evaluates the top of the stack. If the top operator on the operator stack is a unary operator, pop
	     * from the operand stack, evaluate the result, and push the result onto the operand stack. If
	     * the top operator on the operator stack is a binary operator, pop two operands from the operand stack,
	     * evaluate the result of the operation, and push the result onto the operand stack.
	     */
	    private void topEval(Stack<Operator> pOperatorStack, Stack<Operand> pOperandStack) {
	    	
	    	Operand right = pOperandStack.pop();
	    	Operator operator = pOperatorStack.pop();
	    	
	    	if (operator instanceof UnaryOperator) {
	    		pOperandStack.push(((UnaryOperator) operator).evaluate(right));
	    	}
	    	else {
	    		Operand left = pOperandStack.pop();
	    		pOperandStack.push(((BinaryOperator) operator).evaluate(left, right));
	    	}
	    		
	    }
}


