package stuff;

public class DriverProgram {
	
	/*
	 * Program to approximate the root of a given polynomial.
	 */
	
	public static void main(String args[]) {
		double a = 0;
		double b = 100;
		doBisectionMethod(a, b);
	}
	
	/*
	 * This method is responsible for narrowing down the initial 
	 * interval of [0,100] through the conventional Bisection Method
	 * procedure. Towards the end of the method, the midpoint 
	 * of the shortened interval is saved to a variable and then 
	 * passed to another method, which will eventually approximate our root.
	 */
	
	private static void doBisectionMethod(double a, double b) {
		
		System.out.print("Starting Bisection Method\n");
		System.out.print("--------------------------\n");
		
		
		while ((b - a) > 1) {
			
			System.out.print("Value of A: " + a + '\n');
			System.out.println("Value of B: " + b + '\n');
			double c = (a + b) / 2;
			
			if (eval(c) == 0) 
				System.out.print("C is: " + c + '\n');
			
			if ((eval(c) < 0 && eval(a) < 0) || (eval(c) > 0 && eval(a) > 0)) 
				a = c;
			else
				b = c;
		
		} 
		System.out.print("Ending Bisection Method\n");
		System.out.print("--------------------------\n\n");
		System.out.print("//////////////////////////\n\n");
		double x0ForNewton = (a + b) / 2;
		doNewtonMethod(x0ForNewton);
	
	}
	
	/*
	 * Standard Newton method procedure. Some input
	 * validation has been implemented, such as exiting
	 * once the value for two successive iterations are 
	 * a certain distance apart. Method prints out the 
	 * values at each iteration. Also, it prints out the
	 * original value of x naught.  
	 */

	private static void doNewtonMethod(double x0ForNewton) {
		System.out.print("Starting Newton's Method\n");
		System.out.print("--------------------------\n");
		
		boolean solutionFound = false;
		double x1 = 0;
		int counter = 0;
		System.out.println("Original value of x0: " + x0ForNewton);
		while (solutionFound == false) {
			
			double y = eval(x0ForNewton);
			double yPrime = evalPrime(x0ForNewton);
			
			if (yPrime < Math.pow(10.0, -5)) 
				System.out.println("Warning! Get out of here!");
			
			x1 = x0ForNewton - (y / yPrime);
			
			if (Math.abs(x0ForNewton - x1) <= Math.pow(10.0, -8)) 
				solutionFound = true;
			else {
				System.out.println("Value of x" + (counter + 1) + " : " + x1);
				counter++;
			}
			
			x0ForNewton = x1;
		
		}
		
		if (solutionFound) 
			System.out.println("\nRoot is (approximately) : " + x1 + "\n");
		else
			System.out.println("Did not converge, unfortunately...");
		
		System.out.print("Ending Newton's Method\n");
		System.out.print("--------------------------");
	}
	
	/*
	 * Two methods whose sole purpose is to take a number
	 * as input into the function and evaluate it at said
	 * number. It will return the value, as a double, back
	 * to the caller method.
	 */
	
	private static double eval(double c) {
		return Math.pow(c - 30, 2) * Math.pow(c - 60, 2) * (Math.pow(c, 2) - 2) - 10;
	}
	
	private static double evalPrime(double x0ForNewton) {
		return 2.0 * (x0ForNewton - 30) * (x0ForNewton - 60) * (3*(Math.pow(x0ForNewton, 3)) - 180*(Math.pow(x0ForNewton, 2)) + 1796*Math.pow(x0ForNewton, 1) + 180);
	}
}
