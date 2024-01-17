package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.println("Enter the number of shapes: ");
        int n = ler.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Shape #" + i + "data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char ch = ler.next().charAt(0);
            System.out.print("Color (BLACK, BLUE, RED): ");
            Color color = Color.valueOf(ler.next());

            if (ch == 'r'){
                System.out.println("Width: ");
                double width = ler.nextDouble();
                System.out.println("Height: ");
                double height = ler.nextDouble();
                list.add(new Rectangle(color, width, height));
            }
            else {
                System.out.println("Radius: ");
                double radius = ler.nextDouble();
                list.add(new Circle(color, radius));
            }
        }

        System.out.println();
        System.out.println("Shape AREAS:");
        for (Shape shape : list) {
            System.out.println(String.format("%.2f", shape.area()));
        }

        ler.close();
    }
}
