/*
 * CLASS: RightPar
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents right parenthesis in an expression.
 */
public class RightPar extends Parenthesis {

    public RightPar() {
    }

    /**
     * precedence method.
     * Right parenthesis does not have precedence, but method must be overridden.
     * Assigned 1 for lowest 
     */
    @Override
    public int precedence() {
        return 1;
    }

    /**
     * stackPrecedence:
     * See comments above
     */
    @Override
    public int stackPrecedence() {
        return 1;
    }

}