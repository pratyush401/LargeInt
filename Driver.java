/** File Name: Driver.java
 *  This is a file that contains the class Driver. This class implements the algorithm
 *  to create and use instances of the LargeInt class, and interact with the user to allow them to 
 *  compare, add, and print out factorials using LargeInt objects.
 */

import java.util.*;
import java.io.*;

/** Class Name: Driver
 *  This is a class that contains the main method which instantiates and creates 
 *  LargeInt objects. Furthermore, this main method interacts with the user and 
 *  provides them with options to print, add or compare LargeInt numbers. Finally, 
 *  this class also prints out factorials up to an arbrirtarily large limit.
 */
public class Driver {

    /** Method Name: public static void main (String[] args)
     *  This is the main method that is run by the user when the program begins
     *  and creates and uses objects of LargeInt class.
     * 
     * @param args - the arguments in the command line
     */
    public static void main (String[] args) {

        // begin with no debug messages
        LargeInt.debugOff();

        // if there is '-x' as an argument by the user, print debug messages
        for (int index = 0; index < args.length; index++) {
            if (args[index].equals("-x")) {
                LargeInt.debugOn();
            }
        }

        // create sc of type Scanner and pass in System.in stream
        Scanner sc = new Scanner(System.in);

        // try to create LargeInt objects and catch and throw exceptions if not successful
        try {
            // infinite loop
            while (true) {
                // print the following to start interacting with user
                System.out.print("Please enter command:\n" 
                + "(p)rint, (e)nd, (c)ompareTo, "
                + "(a)dd, (f)actorial: ");
                // read command using sc
                String command = sc.nextLine();
                // if command is "e", break from loop and program
                if (command.equals("e")) {
                    break;
                }
                // else switch through the cases
                switch (command) {
                    // the 'print' case
                    case "p":
                        // print message for user and use sc to read in String
                        System.out.println("Please enter large number: ");
                        String sNumber = sc.nextLine();
                        // create LargeInt num using sNumber and print using the print method
                        LargeInt num = new LargeInt(sNumber); // collected by garbage collector
                        num.print();
                        break;

                    // the 'compare' case
                    case "c":
                        // print messages for user and use sc to read in the Strings
                        System.out.println("Please enter large number: ");
                        String sNumberFirst = sc.nextLine();
                        System.out.println("Please enter second large number: ");
                        String sNumberSecond = sc.nextLine();
                        // create LargeInt objects using the read in Strings
                        LargeInt num1 = new LargeInt(sNumberFirst); // collected by garbage collector
                        LargeInt num2 = new LargeInt(sNumberSecond); // collected by garbage collector
                        // call compareTo method and store the return value in comp
                        int comp = num1.compareTo(num2);
                        // based on the return value print message to user
                        if (comp == 1) {
                            System.out.println("First number is greater");
                        }
                        else if (comp == -1) {
                            System.out.println("Second number is greater");
                        }
                        else {
                            System.out.println("The numbers are equal");
                        }
                        break;

                    // the 'add' case
                    case "a":
                        // print messages for user and use sc to read in Strings
                        System.out.println("Please enter large number: ");
                        String sNumberThird = sc.nextLine();
                        System.out.println("Please enter second large number: ");
                        String sNumberFourth = sc.nextLine();
                        // create LargeInt objects using the read in Strings
                        LargeInt num3 = new LargeInt(sNumberThird); // collected by garbage collector
                        LargeInt num4 = new LargeInt(sNumberFourth); // collected by garbage collector
                        // call the add method and store return LargeInt object in sum
                        LargeInt sum = num3.add(num4); // collected by garbage collector
                        // print sum 
                        System.out.println("The sum is ");
                        sum.print();
                        break;

                    // the 'factorial' case
                    case "f": 
                        // create String for int 1
                        String sNumberFifth = Integer.toString(1);
                        // create LargeInt num5 passing in sNumberFifth and 
                        // LargeInt fact using num5
                        LargeInt num5 = new LargeInt(sNumberFifth); // collected by garbage collector
                        LargeInt fact = new LargeInt(num5); // collected by garbage collector
                        // initialize int to be 1
                        int mult = 1;
                        // an infinite loop
                        while (true) {
                            // call the multiply method for fact and pass in mult as integer
                            fact = fact.multiply(mult);
                            // print the fact, which is the factorial 
                            System.out.print("Factorial of " + mult + " is: ");
                            fact.print();
                            String next = sc.nextLine();
                            // increment mult by 1
                            mult++;
                            // check if next is equal to "e" using sc
                            if (next.equals("e")) {
                                // if "e" is entered, break
                                break;
                            }
                            else {
                                continue;
                            }
                        }
                }
            }
        }
        catch (IOException e) {
            // print exception message to user
            System.out.println("Error in constructing LargeInt Integer");
        }
        // close sc
        sc.close();
    }
}