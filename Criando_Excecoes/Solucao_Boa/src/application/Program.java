package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        try {
            System.out.print("Room number: ");
            int number = ler.nextInt();

            System.out.print("Check-in date(dd/MM/yyyy): ");
            Date checkIn = sdf.parse(ler.next());

            System.out.print("Check-out date(dd/MM/yyyy): ");
            Date checkOut = sdf.parse(ler.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date(dd/MM/yyyy): ");
            checkIn = sdf.parse(ler.next());

            System.out.print("Check-out date(dd/MM/yyyy): ");
            checkOut = sdf.parse(ler.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error in reservation: " + e.getMessage());
            // o getMessage() é a mensagem que passei quando instanciei a exceção
            // no metodo updateDates na classe Reservation
        }

        ler.close();
    }
}
