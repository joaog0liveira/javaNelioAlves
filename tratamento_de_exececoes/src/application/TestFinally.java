package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestFinally {
    public static void main(String[] args) {
        File file = new File("D:\\Developer\\javaNelioAlves\\tratamento_de_exececoes\\src\\application\\in.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
            System.out.println("Finally block executed");
        }
    }
}