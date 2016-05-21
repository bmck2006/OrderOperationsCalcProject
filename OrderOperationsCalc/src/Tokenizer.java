/*
 * CLASS: Tokenizer
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class scans a string and breaks it into "tokens".
 */
public class Tokenizer {
	
	// These constants are used to represent the state the scanner is in.
    private static final int STATE_DOUBLE = 0;
    private static final int STATE_END    = 1;
    private static final int STATE_START  = 2;

    private int mIndex; // this keeps track of position while scanning string to split into tokens. 
    private String mString; // the string that will be scanned.

    /**
     * Constructor:
     */
    public Tokenizer(String pString) {
        setIndex(-1);
        setString(pString);
    }

    /**
     * getIndex method: accessor for index. 
     */
    protected int getIndex() {
        return mIndex;
    }

    /**
     * getString method: accessor for scanned or to-be-scanned string.  
     * 
     */
    protected String getString() {
        return mString;
    }

    /**
     * nextToken method: 
     * uses Finite State Machine. 
     */
    public Token nextToken() {
        boolean scanning = true;
        int state = STATE_START, nextState = STATE_START;
        StringBuffer buffer = new StringBuffer();
        Token token = null;

        while (state != STATE_END) {
            Character ch = nextChar();
            switch (state) {
            case STATE_START:
                // Check for the end of the expression string.
                if (ch == null) {
                    token = null;
                    nextState = STATE_END;

                // checking for double literal
                } else if (Character.isDigit(ch) || ch == '.') {
                    buffer.append(ch);
                    nextState = STATE_DOUBLE;

                // checking for addition operator
                } else if (ch == '+') {
                    token = new AdditionOperator();
                    nextState = STATE_END;

                // checking for subtraction operator
                } else if (ch == '-') {
                    token = new SubtractOperator();
                    nextState = STATE_END;

                // checking for multiplication operator
                } else if (ch == '*') {
                    token = new MultiplyOperator();
                    nextState = STATE_END;

                // checking for division operator
                } else if (ch == '/') {
                    token = new DivisionOperator();
                    nextState = STATE_END;

                // checking for left parenthesis
                } else if (ch == '(') {
                    token = new LeftPar();
                    nextState = STATE_END;

                // checking for right parenthesis
                } else if (ch == ')') {
                    token = new RightPar();
                    nextState = STATE_END;
                }
                break;

            // scanning the characters of a double literal.
            case STATE_DOUBLE:
                // Checks for the end of the expression string
                if (ch == null) {
                    nextState = STATE_END;

                // keep scanning a double literal if digits or '.' detected.
                } else if (Character.isDigit(ch) || ch == '.') {
                    buffer.append(ch);
                    nextState = state;

                // end of the double literal. Ungets the character that we just scanned and stops.
                } else {
                    ungetChar();
                    nextState = STATE_END;
                }

                // Converts to Operand for return.
                if (nextState == STATE_END) {
                    token = new Operand(Double.parseDouble(buffer.toString()));
                }
                break;
            }
            state = nextState;
        }
        return token;
    }

    /**
     * nextChar method:
     * Returns the next Character in mString and updates mIndex.
     */
    private Character nextChar() {
        Character next = null;
        if (getIndex() < getString().length() - 1) {
            setIndex(getIndex() + 1);
            next = getString().charAt(getIndex());
        }
        return next;
    }

    /**
     * peekNext method:
     * Returns the next Character in mString without updating mIndex.
     */
    private Character peekNext() {
        Character next = null;
        if (getIndex() < getString().length()) {
            next = getString().charAt(getIndex() + 1);
        }
        return next;
    }

    /**
     * setIndex method: mutator
     */
    protected void setIndex(int pIndex) {
        mIndex = pIndex;
    }

    /**
     * setString method: mutator
     */
    protected void setString(String pString) {
        mString = pString;
    }

    /**
     * ungetChar method:
     * Moves mIndex back to point to the previous character in mString.
     */
    private void ungetChar() {
        setIndex(getIndex() - 1);
    }

}

