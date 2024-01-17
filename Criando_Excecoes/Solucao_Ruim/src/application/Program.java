package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        /* o meu parse no checkin pode lançar uma exceção, então quando uso o
         * throws ParseException estou dizendo que o meu metodo main pode lançar uma exceção desse tipo! */
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = ler.nextInt();

        System.out.print("Check-in date(dd/MM/yyyy): ");
        Date checkIn = sdf.parse(ler.next());

        System.out.print("Check-out date(dd/MM/yyyy): ");
        Date checkOut = sdf.parse(ler.next());

        if (!checkOut.after(checkIn)) { // testando se a data de checkout é depois do checkin
            System.out.println("Error in reservation: Check-out date must be after Check-in date!");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date(dd/MM/yyyy): ");
            checkIn = sdf.parse(ler.next());

            System.out.print("Check-out date(dd/MM/yyyy): ");
            checkOut = sdf.parse(ler.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null) { // se for diferente de error, veio alguma string contendo um erro
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }

        ler.close();
    }
}
