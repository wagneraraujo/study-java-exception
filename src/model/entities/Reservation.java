package model.entities;

import model.entities.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkout;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(Integer roomNumber, Date checkIn, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckout() {
        return checkout;
    }

    //retornar as datas em milisegundos e converter
    public long duration(){
        long diff = checkout.getTime() - checkIn.getTime();
       return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkout) throws DomainException{
        Date now = new Date();

        if(checkIn.before(now) || checkout.before(now)){
            throw new DomainException("Data antes da data atual");
        }

        if(checkout.after(checkIn)){
            throw new DomainException("Data futura demais");
        }
        this.checkIn = checkIn;
        this.checkout = checkout;


    }

    @Override
    public String toString(){
        return "Room " +
                roomNumber +
                ", checkIn: " +
                sdf.format(checkIn) +
                "checkout: "+
                sdf.format(checkout) +
                ", " +
                duration() +
                "nights." ;



    }


}
