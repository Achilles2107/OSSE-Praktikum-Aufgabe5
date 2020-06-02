package de.hfu;

// Autor: siringst

import java.util.Scanner;

/**
 * Main Class is for all the fun
 */

public class Main

{

    /**
     * Makes input great again!
     */

    public static void UpperCase(){


        Scanner scan = new Scanner(System.in);

        String input;

        while (true) {

            System.out.println("Please type in some Words: ");
            input = scan.nextLine();

            System.out.println(input.toUpperCase());
        }
    }


    public static void main( String[] args )
    {
        /**
         * Using UpperCase function
         */
        UpperCase();

    }
}
