/*
 * CLASS: Operand
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class represents an Operand: a numeric value (double). 
 */
	
	public class Operand extends Token{
		
		private double mValue;
		
		//Constructor:
		public Operand(double pValue) {
			mValue = pValue;
		}
		//Getter method:
		public double getValue(){
			return mValue;
		}
		//Setter method:
		public void setValue(double pValue) {
			mValue = pValue;
		}
	}
