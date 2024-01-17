package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UserProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Número de Produtos: ");
        int pd = ler.nextInt();

        for (int i = 1; i <=pd; i++){
            System.out.println("Produto #" + i + " : ");
            System.out.println("Comum, usado ou importado? (c/u/i) ");
            char ch = ler.next().charAt(0);

            System.out.println("Nome: ");
            ler.nextLine();
            String name = ler.nextLine();

            System.out.println("Valor: ");
            double price = ler.nextDouble();

            if (ch == 'i'){
                System.out.println("Valor da taxa de importação:");
                double taxa = ler.nextDouble();
                list.add(new ImportedProduct(name, price, taxa));
            } else if (ch == 'u'){
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(ler.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UserProduct(name, price, date));
            } else{
                list.add(new Product(name, price));
            }
        }


        System.out.println();
        System.out.println("Etiquetas de preço");
        for (Product prod: list){
            System.out.println(prod.priceTag());
        }

        ler.close();
    }
}
