/*
 * CLASS: Main
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * The Main class containing the main() and run() methods.
 */
import javax.swing.JFrame;

public class Main {

    private View mView; // refers to View object.

    public static void main(String[] args) {
        new Main().run(); 
    }

    /**
     * exit method:
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * getView method: Accessor
     */
    private View getView() {
        return mView;
    }

    /**
     * run method:.
     */
    private void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setView(new View(this));
    }

    /**
     * setView method: Mutator.
     */
    private void setView(View pView) {
        mView = pView;
    }

}

