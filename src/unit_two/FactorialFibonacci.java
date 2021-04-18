package unit_two;

import java.util.Scanner;

public class FactorialFibonacci {
   
   public static void main( String[] args ) {
	   
      Scanner scan = new Scanner( System.in );
      
      while (true) {
         System.out.print("Input only a positive number:  ");
         int n = scan.nextInt();
         
         System.out.println("\nThe fibonacci of " + n + " is: " + fibonacci(n));
         System.out.println("\nThe factorial of " + n + " is: " + factorial(n));
      }
   }   
   
   
   // Create recursive factorial function
   static int factorial( int n ) {
       if ( n == 0 ) {
           return 1;
       }
       else if (n > 0) {
           return n * factorial(n - 1) ;
       }
       else {
    	   return 0;
       }
   }

   
   // Create recursive Fibonacci function
   static int fibonacci( int n ) {
       if ( n == 0 || n == 1 ) {
           return 1;
       }
       else if (n > 1) {
           return fibonacci(n - 1) + fibonacci(n - 2);
       }
       else {
    	   return 0;
       }
   }
}