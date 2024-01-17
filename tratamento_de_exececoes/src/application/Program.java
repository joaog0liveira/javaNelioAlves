package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        method1();

        System.out.println("End of program!");
    }

    public static void method1() {
        System.out.println("Method1 Start!");
        method2();
        System.out.println("Method1 END");
    }

    public static void method2() {
        System.out.println("Method2 Start!");
        Scanner ler = new Scanner(System.in);


        String[] vect = ler.nextLine().split(" ");
        int position = ler.nextInt();
        System.out.println(vect[position]);


        ler.close();
        System.out.println("Method2 End");
    }
}
