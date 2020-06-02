package de.hfu;

import java.util.Scanner;

public class Main
{
    public static void UpperCase(){

        Scanner scan = new Scanner(System.in);

        String input;

        while (true) {

            System.out.println("Bitte Text eingeben: ");
            input = scan.nextLine();

            System.out.println(input.toUpperCase());
        }
    }


    public static void main( String[] args )
    {
        UpperCase();
    }
}
