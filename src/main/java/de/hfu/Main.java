package de.hfu;

// Autor: siringst

import java.util.Scanner;

import static de.hfu.Util.istErstesHalbjahr;


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

            if (input.equals("exit"))
                break;

            System.out.println(input.toUpperCase());
        }
        scan.close();
    }


    public static void main( String[] args )
    {
        /**
         * Using UpperCase function
         */
        //UpperCase();


    }
}
