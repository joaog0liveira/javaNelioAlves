package entities;

public class Fisica extends Pessoa{
    private double gastosSaude;

    public Fisica(String name, Double rendaAnual, double gastosSaude) {
        super(name, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double tax() {

        // expresões ternárias
        //double basicTax = (getRendaAnual() < 20000) ? getRendaAnual() * 0.15 : getRendaAnual() * 0.25;

        double basicTax;

        if (getRendaAnual() < 20000) {
            basicTax = getRendaAnual() * 0.15;
        }
        else {
            basicTax = getRendaAnual() * 0.25;
        }

        basicTax = basicTax - (getGastosSaude() * 0.5);

        if (basicTax < 0) {
            return 0;
        }
        else {
            return basicTax;
        }
    }
}
