/** File Name: LargeInt.java
 *  This is a file that contains the class LargeInt. This class implements the algorithm
 *  to take in a large number from a user, store it using a suitable data structure, and then
 *  help the user carry out operations on it.
 */

import java.util.*;
import java.io.*;

/** Class Name: LargeInt
 *  This is a class that can store an arbritary large number and help carry out operations on
 *  it, including addition and comparisions. This class contains various methods as well as member
 *  variables that help in implementing such an algorithm. The methods, along with the constructors
 *  are debugOn(), debugOff(), print(), compareTo(), add(), and multiply().
 */ 
public class LargeInt {

    // member variables of type boolean, int and ArrayList<Integer>
    private static boolean debug;
    private int occupancy;
    private ArrayList<Integer> num = new ArrayList<Integer> ();

    /** Method Name: public LargeInt (String SNumber)
     *  This is a constructor method that constructs the data structure and 
     *  stores the large integer.
     * 
     *  @param SNumber - the number in the form of a string
     */
    public LargeInt (String SNumber) throws IOException {
        // print debug message
        if (debug) {
            System.out.println("The input string passed to the constructor is ");
            System.out.println(SNumber);
        }
        // go through a loop of SNumber's length and pass in each digit to decin to convert
        // to int value.
        for (int i = 0; i < SNumber.length(); i++) {
            int single_digit = decin(SNumber.charAt(i));
            // if can't convert, throw exception
            if (single_digit == -1) {
                throw new IOException();
            }
            // if preceding 0's, then continue and not add to num
            if (single_digit == 0 && occupancy == 0 && SNumber.length() != 1) {
                continue;
            }
            // add the digit to arrayList and increment occupancy
            num.add(single_digit);
            occupancy++;
        }
        // print debug message
        if (debug) {
            System.out.println(Arrays.toString(num.toArray()));
        }
    }

    /** Method Name: public LargeInt (LargeInt copy)
     *  Copy Constructor that takes in another largeInt and makes a copy instance
     * 
     *  @param copy - LargeInt to be copied 
     */
    public LargeInt (LargeInt copy) {
        // store the shallow copy to of the LargeInt in num
        num = copy.getList();
        // copy the occupancy by calling getOccupancy method
        occupancy = copy.getOccupancy();
    }

    /** Method Name: public static void debugOff()
     *  This is a method that changes the debug value to false
     */
    public static void debugOff() {
        debug = false;
    }

    /** Method Name: public static void debugOn()
     *  This is a method that changes the debug value to true
     */
    public static void debugOn() {
        debug = true;
    }

    /** Method Name: private int getOccupancy()
     *  A getter method for occupancy
     * 
     *  @return occupancy - the number of digits in the arrayList
     */
    private int getOccupancy() {
        return occupancy;
    }

    /** Method Name: private int getVal (int i)
     *  A getter method that returns the value at certain index
     *  
     *  @param index - the index whose value to be returned
     *  @return int - the value at the index
     */
    private int getVal (int index) {
        return num.get(index);
    }

    /** Method Name: private ArrayList<Integer> getList()
     *  Getter method that returns the ArrayList
     * 
     *  @return num - the ArrayList<Integer> storing the LargeInt
     */
    private ArrayList<Integer> getList() {
        return num;
    }

    /** Method Name: private int decin (char c)
     *  This is a method that takes in a character and converts it into an integer
     *  value
     * 
     *  @param c - the character to be converted
     *  @return digit - the integer value of the character
     */
    private int decin (char c) {
        // declare int digit
        int digit;
        // check if not a char between '0' and '9'
        if (c < 48 || c > 57) {
            // return -1
            return -1;
        }
        // subtract ASCII value of '0' from character to convert to int
        digit = c - '0';
        // return the int value
        return digit;
    }

    /** Method Name: public void print()
     *  This method prints out the LargeInt using the ArrayList
     */
    public void print() {
        // loop through the arrayList and print the digit
        for (int i = 0; i < occupancy; i++) {
            System.out.print(num.get(i));
        }
        // print a new line char to go to new line
        System.out.print('\n');
    }

    /** Method Name: public int compareTo (LargeInt n)
     *  This method compares two LargeInts and returns an int to denote whether this 
     *  LargeInt is greater, smaller, or equal to the passed in LargeInt.
     * 
     *  @param n - the other LargeInt to be compared with this LargeInt
     *  @return int 1, 0, -1 - 1 denotes this is greater, -1 denotes this is lesser and 
     *                         0 denotes this is equal to the other LargeInt
     */
    public int compareTo (LargeInt n) {
        // declare index of type int and initialize to 0
        int index = 0;
        // check for which LargeInt has greater occupancy
        if (occupancy > n.getOccupancy()) {
            // if this has greater occupancy, this is greater
            return 1;
        }
        else if (occupancy < n.getOccupancy()) {
            // if n has greater occupancy, n is greater
            return -1;
        }
        // else if occupancy is equal
        else {
            // loop until index is equal or greater than occupancy
            while (index < occupancy) {
                // if the digit at index is greater, then this is greater
                if (num.get(index) > n.getVal(index)) {
                    return 1;
                }
                // if the digit at index is lesser, then n is greater
                else if (num.get(index) < n.getVal(index)) {
                    return -1;
                }
                // else just go to the next digit
                else {
                    index = index + 1;
                    continue;
                }
            }
            // if all of the digits are the same and they are of same occupancy,
            // then the LargeInt objects are equal
            return 0;
        }
    }

    /** Method Name: public LargeInt add (LargeInt n)
     *  This method adds the calling LargeInt to another LargeInt passed in as
     *  parameter and returns the LargeInt sum.
     * 
     *  @param n - the other LargeInt to be added to this 
     *  @return retSum - the sum of the two LargeInt objects
     */
    public LargeInt add (LargeInt n) throws IOException {
        // instantiate carry of type Stack<Integer> and totSum of type ArrayList<Integer>
        Stack<Integer> carry = new Stack<Integer> ();
        ArrayList<Integer> totSum = new ArrayList<Integer> ();
        // declare String SumS and int sum and index
        String sumS = "";
        int sum = 0;
        int index;
        // if occupancy of this is greater than n, pad zeroes to n in order to make 
        // size equal
        if (occupancy > n.getOccupancy()) {
            for (int i = 0; i < occupancy - n.getOccupancy(); i++) {
                n.getList().add(0, 0);
            }
            // make index one lesser than occupancy
            index = occupancy - 1;
        }
        // if occupancy of this is lesser than n, pad zeroes to this LargeInt to make
        // size equal
        else {
            for (int i = 0; i < n.getOccupancy() - occupancy; i++) {
                num.add(0, 0);
            }
            // make index 1 lesser than occupancy of n
            index = n.getOccupancy() - 1;
        }
        // loop through this LargeInt
        while (index != -1) {
            // make sum equal to index of num and n
            sum = num.get(index) + n.getVal(index);
            // check if carry is empty and if not add the top value to sum
            if (carry.empty() == false) {
                sum = sum + carry.pop();
            }
            // if sum is greater than 9 and index is lesser than 0, push 1 to carry
            // and decrement sum by 10
            if (sum > 9 && index != 0) {
                carry.push(1);
                sum = sum - 10;
            }
            // add sum to totSum and decrement index by 1
            totSum.add(sum);
            index = index - 1;
        }
        // reverse the totSum so that the totSum arrayList is correct order 
        Collections.reverse(totSum);
        // add the integers in totSum to sumS using toString()
        for (Integer s : totSum) {
            sumS += s.toString();
        }
        // create LargeInt retSum using sumS
        LargeInt retSum = new LargeInt (sumS);
        // remove the padded zeroes using a loop and checking which one has greater
        // occupancy
        if (occupancy > n.getOccupancy()) {
            for (int i = 0; i < occupancy - n.getOccupancy(); i++) {
                n.getList().remove(0);
            }
        }
        else {
            for (int i = 0; i < n.getOccupancy() - occupancy; i++) {
                num.remove(0);
            }
        }
        // return the LargeInt retSum
        return retSum;
    }

    /** Method Name: public LargeInt multiply (int mult)
     *  This method takes in an integer and multiplies the LargeInt with the 
     *  integer.
     *  
     *  @param mult - integer to be multiplied with the LargeInt
     *  @return retProduct - the product of the integer and LargeInt
     */
    public LargeInt multiply (int mult) throws IOException {
        // initialize index to last index of num
        int index = occupancy - 1;
        // declare int types digit and place and String productS
        int digit = 0;
        int place;
        String productS = "";
        // Instantiate carry of type Stack<Integer> and product of type ArrayList<Integer>
        Stack<Integer> carry = new Stack<Integer> ();
        ArrayList<Integer> product = new ArrayList<Integer> ();
        // go through num in a loop
        while (index != -1) {
            // multiply mult with digit of num at index
            digit = num.get(index) * mult;
            // if stack is not empty, add digit to top value of carry
            if (carry.empty() == false) {
                digit = digit + carry.pop();
            }
            // if digit is greater than 9 and index is not 0
            if (digit > 9 && index != 0) {
                // get the tens place of digit and push to carry
                place = (digit - (digit % 10)) / 10;
                carry.push(place);
                // update digit to its ones place
                digit = digit % 10;
            }
            // add digit to product and decrement index by 1
            product.add(digit);
            index = index - 1;
        }
        // reverse the product ArrayList
        Collections.reverse(product);
        // add the integers in product to productS using toString()
        for (Integer i : product) {
            productS += i.toString();
        }
        // create the LargeInt retProduct using productS and return
        LargeInt retProduct = new LargeInt (productS); 
        return retProduct;
    }
}

