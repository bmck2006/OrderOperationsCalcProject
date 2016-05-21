/*
 * CLASS: View
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class implements the GUI. 
 */
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame {

    public static final int FRAME_WIDTH  = 550;
    public static final int FRAME_HEIGHT = 450;

    // Declare instance variables
    private JButton mClearButton;
    private JButton mEvaluateButton;
    private JTextField mInputText;
    private JButton mExitButton;
    private Main mMain;
    private JLabel mResultLabel;

    
    public View(Main pMain) {
      
        mMain = pMain;

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new FlowLayout());
        JLabel mResultLabel = new JLabel("Welcome! Enter math below:");
        panelLabel.add(mResultLabel);
       
        JPanel imgPanel = new JPanel();
        imgPanel.setLayout(new FlowLayout());
        JLabel imgLabel = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("robot-trash-icon.png")).getImage();
        imgLabel.setIcon(new ImageIcon(img));
        imgLabel.setBounds(10,53,245,245);
        imgPanel.add(imgLabel); 
       
        
        
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
        final JTextField mInputText = new JTextField("",40);
        mInputText.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String text = mInputText.getText();
            	Expression expr = new Expression(text);
            	double result = expr.evaluate();
            	mResultLabel.setText("Result: " + result);
        	}
        });
        panelInput.add(mInputText);
        
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        
        JPanel panelButtons2 = new JPanel();
        panelButtons2.setLayout(new FlowLayout());
        
        JButton mEvaluateButton = new JButton("Evaluate");
        mEvaluateButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String text = mInputText.getText();
            	Expression expr = new Expression(text);
            	double result = expr.evaluate();
            	mResultLabel.setText("Result: " + result);
        	}
        });
        panelButtons.add(mEvaluateButton);
        
        JButton mClearButton = new JButton("Clear");
        mClearButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mInputText.setText("");
            	mResultLabel.setText("Enter math below:");
        	}
        });
        panelButtons.add(mClearButton);

       
       JButton mInfoButton = new JButton("Info");
       mInfoButton.addActionListener(new ActionListener(){
       	@Override
       	public void actionPerformed(ActionEvent e) {
       		String title = "Info";
       		String msg = "Order of Operations Calculator (beta)\nCreated by: Brian McKeown\n"
       				+ "For: CSE 205: Object-Oriented Programming and Data Structures\n"
       				+ "Spring 2016: B Session\n"
       				+ "Arizona State University\n"
       				+ "Ira A. Fulton Schools of Engineering";
       		messageBox(msg, title);
       		}
       });
      panelButtons2.add(mInfoButton);
      
      JButton mHelpButton = new JButton("Help");
      mHelpButton.addActionListener(new ActionListener(){
      	@Override
      	public void actionPerformed(ActionEvent e) {
      		String title = "Help";
      		String msg = "This program performs basic math funcions:\n\n\t"
      				+ "- Uses only operators: + - * /\n\t"
      				+ "- Does not perform exponents, log, or other advanced functions\n\t"
      				+ "- Does not multiply with parenthesis, example 2(3)\n\t"
      				+ "- an operator (+-*/) must be used before and after parenthesis\n\t"
      				+ "- Don't use the = symbol. Just click Evaluate, or press the ENTER key\n\t"
      				+ "- Kalkutron-9001 follows order of operations rules (PEMDAS!)\n\t"
      				+ "- Will solve long problems, but don't get too crazy!\n\t"
      				+ "- Example: 4*6+(5+5)/10 (The answer will return 25)";
      		messageBox(msg, title);
      		}
      });
     panelButtons2.add(mHelpButton);
     
     JButton mExitButton = new JButton("Exit");
     mExitButton.addActionListener(new ActionListener(){
     	@Override
     	public void actionPerformed(ActionEvent e) {
     		mMain.exit();
     	}
     });
    panelButtons2.add(mExitButton);
        

       JPanel panelMain = new JPanel();
       panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
       panelMain.add(Box.createVerticalGlue());
       panelMain.add(imgPanel);
       panelMain.add(panelLabel);
       panelMain.add(panelInput);
       panelMain.add(panelButtons);
       panelMain.add(panelButtons2);

        setTitle("Order of Operations Calculator (beta)");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelMain);
        setVisible(true);
    }

    private void clear() {
    	mInputText.setText("");
    	mResultLabel.setText("");
    }


    private void evaluate() {
    	String text = mInputText.getText();
    	Expression expr = new Expression(text);
    	double result = expr.evaluate();
    	mResultLabel.setText("Result: " + result);
    }

    public void messageBox(String pMessage, String pTitle) {
        JOptionPane.showMessageDialog(this, pMessage, pTitle, JOptionPane.PLAIN_MESSAGE);
    }

}

