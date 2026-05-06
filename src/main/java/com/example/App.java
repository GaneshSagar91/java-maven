package com.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = sc.nextInt();

        

        System.out.println("\nAddition: " + calc.add(num1, num2));
        System.out.println("Subtraction: " + calc.subtract(num1, num2));

    }
}
