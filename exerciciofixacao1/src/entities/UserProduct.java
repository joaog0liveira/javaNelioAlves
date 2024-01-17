package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserProduct extends Product{
    private LocalDate manufactureDate;

    public UserProduct(String name, double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        return "Usado $ " + String.format("%.2f", getPrice()) + "(Manufacture date: )" + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
