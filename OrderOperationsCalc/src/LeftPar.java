/*
 * CLASS: LeftPar
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents the left parenthesis in an expression
 */
public class LeftPar extends Parenthesis {

    public LeftPar() {
    }

    /**
     * precedence method: 
     * Returns the normal precedence level of LeftPar which is highest at 5.
     */
    @Override
    public int precedence() {
        return 5;
    }

    /**
     * stackPrecedence method:
     * Returns the precedence level of LeftPar when on the operator stack, it is lowest at 0.
     */
    @Override
    public int stackPrecedence() {
        return 0;
    }

}