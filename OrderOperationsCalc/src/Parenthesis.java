/*
 * CLASS: Parenthesis
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * Super Class of LeftPar and RightPar. 
 */
public abstract class Parenthesis extends Operator {

    public Parenthesis() {
    }
    
    @Override
    public boolean isBinaryOperator() {
        return false; // because parenthesis are not an operator. 
    }

}