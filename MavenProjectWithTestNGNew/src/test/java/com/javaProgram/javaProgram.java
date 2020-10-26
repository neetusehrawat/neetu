package com.javaProgram;
import java.util.Random;

public class javaProgram {
	
 
 public String generateRandomString(int n) {
	    // create a string of all characters
	    String alphabet = "abcdefghijklmnopqrstuvwxyz"+"0123456789";

	    // create random string builder
	    StringBuilder sb = new StringBuilder(n);

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    // int length = 7;

	    for(int i = 0; i < n; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    //String inlowercase=randomString.toLowerCase();
	    System.out.println("Random String is: " + randomString);
	    return randomString;
	    

	  }

	
     public static void main(String[] args) {
    	 javaProgram j=new javaProgram();
    	 j.generateRandomString(7);
    	 
     }}



