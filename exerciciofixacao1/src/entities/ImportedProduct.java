package entities;

public class ImportedProduct extends Product{

    private double taxa;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, double price, double taxa) {
        super(name, price);
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double totalPrice(){
        return getPrice() + taxa;
    }

    @Override
    public String priceTag(){
        return getName()
                + " $ " + String.format("%.2f", totalPrice())
         + "Taxa: $ " + String.format("%.2f", taxa);
    }
}
