package com.example.lesson04;

import java.util.Scanner;

public class AreaTriangle {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input Side-1: ");
        int a = in.nextInt();
        System.out.print("Input Side-2: ");
        int b = in.nextInt();
        System.out.print("Input Side-3: ");
        int c = in.nextInt();
        System.out.println( is_Valid(a, b, c) ?
                "The area of the triangle is " + area_triangle(a, b, c) : "Invalid triangle" );
    }
    public static boolean is_Valid(int a, int b, int c) {
        if( a + b > c &&
                b + c > a &&
                a + c > b) return true;
        else return false;
    }
    public static double area_triangle(int a, int b, int c) {
        double area = 0;
        double p = (a + b + c)/2;
        area = Math.sqrt(p*(p - a)*(p - b)*(p - c));
        return area;
    }
}


