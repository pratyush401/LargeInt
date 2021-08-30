# LargeInt

<h3> Contents of the Repository </h3>

This repository contains the LargeInt program and the Driver program, both written in Java.

LargeInt.java\
The file that contains the public class LargeInt. The class implements the algorithm to take in a large integer from the user, store it using an ArrayList<Integer>, 
and then help carry out basic operations on it.

Driver.java\
The file that contains the public Driver class. The class implements the algorithm to create and use instances of the LargeInt class. This is the file that is executed by the user
and it allows the user to carry out various operations on the LargeInt objects.

<h3> Description </h3>

<h5> Why is it needed? </h5>

The LargeInt program allows the user to store and carry out basic mathematical functions on large integers (integers greater than 2^31 - 1). 
This is important as the largest value that the primitive data type, integer, in java, can hold is 2^31 - 1 and hence, not very useful for a wide range of calculations 
that are necessary. For instance, the factorial of 13 is greater than this maximum limit of an integer type in java, 
clearly requiring another system of storing an integer so that higher factorials can be calculated and expressed.

<h5> How does it work? </h5>

I make use of an ArrayList of Integer type to store the digits of a large integer. This allows me to store integers that are upto 2^31 - 1 digits long. Storing each digit in 
seperate indices of the ArrayList allows for simple algorithms to compare, add, and multiply these LargeInt objects. 

<h5> Further Development </h5>

I am currently working on making the storage of the large integer more efficient by using base-256, that allows every bit to be used for storing the large integer, rather than 
storing it using 32 bits for a single decimal integer.

<h3> Using the Project </h3>

1. Pull the files into your local desktop
2. Compile the LargeInt.java file and Driver.java by running the commands\
javac LargeInt.java\
javac Driver.java

Then, you can run the Driver code by typing the command 'java Driver', or make your own Driver to allocate and use objects of the LargeInt class.

