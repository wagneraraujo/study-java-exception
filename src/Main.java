import model.entities.Reservation;
import model.entities.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("CheckIn data dd/mm/yyyy: ");
            Date checkIn = sdf.parse(sc.next());

            System.out.print("checkout data dd/mm/yyyy: ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkout);
            System.out.println("Reservation" + reservation);

            System.out.println();
            System.out.println("Enter date update reservation");

            System.out.print("CheckIn data dd/mm/yyyy: ");
            checkIn = sdf.parse(sc.next());

            System.out.print("checkout data dd/mm/yyyy: ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkIn,checkout);
            System.out.print("Update reservatin" + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date");
        }
        catch (DomainException e){
            System.out.println("Erro in reservation" + e.getMessage());
        }


        sc.close();

    }
}