package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    /*se eu não usar ele como static, sempre que criar um no objeto do reservation vai criar um novo
     * SimpleDateFormat */
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after Check-in date!");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public Date getCheckOut() {
        return checkOut;
    }

    /*Calculado duração em dias com base no checkin e no checkout */
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // diferença das duas data em milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // convertendo milissegundos em dias
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){
            // usamos essa exceção quando os argumentos que passamos para um metodo são invalidos
            throw new DomainException("Error in reservation: Reservation dates for updates must be future dates!");
            // caso aconteça algum erro eu vou lançar uma exceção e não retornar uma
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after Check-in date!");
        }

        this.checkIn = checkIn; // atualiza as datas
        this.checkOut = checkOut;  // atualiza as datas
    }

    @Override // sempre usar o override no toString pq ele é um caso de sobreposição
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nigths";
    }

}
