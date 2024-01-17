package application;

import entities.Fisica;
import entities.Juridica;
import entities.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        List<Pessoa> list = new ArrayList<Pessoa>();

        System.out.println("Digite o número de contribuintes ");
        int n = ler.nextInt();

        for (int i = 1 ; i <= n; i++){
            System.out.println("Contribuinte" + i + ": ");
            System.out.println("Pessoa Fisica ou Juridica (f/j)");
            char type = ler.next().charAt(0);
            System.out.println("Nome: ");
            String name = ler.next();
            System.out.println("Renda anual: ");
            double rendaAnual = ler.nextDouble();

            if (type == 'f'){
                System.out.println("Gastos com saude: ");
                double saude = ler.nextDouble();
                Fisica x = new Fisica(name, rendaAnual, saude);
                list.add(x);
            }
            else {
                System.out.println("Número de funcionários: ");
                Integer numFunc = ler.nextInt();
                list.add(new Juridica(name, rendaAnual, numFunc));
            }
        }

        System.out.println();
        System.out.println("Taxas: ");
        for (Pessoa tp : list){
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
        }

        double sum = 0;
        for (Pessoa tp : list){
            sum += tp.tax();
        }
        System.out.println("Total de taxas: " + String.format("%.2f", sum));
    }
}
