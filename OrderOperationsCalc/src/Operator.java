/*
 * CLASS: Operator
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * Super Class of all binary and unary operators.
 */
public abstract class Operator extends Token {
	//Constructor:
	public Operator(){}
	
	//abstract methods:
	public abstract boolean isBinaryOperator();
	public abstract int precedence();
	public abstract int stackPrecedence();
}