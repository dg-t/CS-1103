package unit_one;
import java.util.Scanner;

public class SolveEquations {

   public static void main(String[] args) {
      
	   boolean isNext = false;
	   
	   // do-while statement to keep asking the user if wants to enter another equation
	   do {
		   
		   // Use scanner to get data from user and store in the variables a, b, and c
		   Scanner scan = new Scanner(System.in);
		   System.out.println("Input value of \"a\" = ");
		   double a = scan.nextInt();
		   System.out.println("Input value of \"b\" = ");
		   double b = scan.nextInt();
		   System.out.println("Input value of \"c\" = ");
		   double c = scan.nextInt();
		   
		   // Use try catch statement for handling exceptions
		   try {
			   double result = root(a,b,c);
               System.out.println("The result of this equation is: " + result);  
           }
		   catch (IllegalArgumentException error) {
			   System.out.println("Something went wrong...");
               System.out.println(error.getMessage());
           }
		   
		   // Ask user if wants to enter another equation until it replies yes or no
           boolean askAgain = true;
           while (askAgain) {
        	   System.out.print("Do you want to enter another equation? Please enter Yes or No.");
               String nextEquation = scan.next();
               if (nextEquation.toLowerCase().equals("yes")) {
            	   isNext = true;
            	   askAgain = false;
               } else if (nextEquation.toLowerCase().equals("no")) {
            	   isNext = false;
            	   askAgain = false;
            	   scan.close();
               } else {
            	   askAgain = true;
               }
           }
           
           
	   } while (isNext);
   }
   
 
   // root method from Subsection 8.3.3 of the textbook
   /**
    * Returns the larger of the two roots of the quadratic equation
    * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
    * if the discriminant, B*B - 4*A*C, is negative, then an exception
    * of type IllegalArgumentException is thrown.
    */
   static public double root( double A, double B, double C ) throws IllegalArgumentException {
       if (A == 0) {
         throw new IllegalArgumentException("A can't be zero.");
       }
       else {
          double disc = B*B - 4*A*C;
          if (disc < 0)  throw new IllegalArgumentException("Discriminant < zero.");
          return  (-B + Math.sqrt(disc)) / (2*A);
       }
   }  
} 