package entities;

public class Juridica extends Pessoa{
    private Integer numFunc;

    public Juridica(String name, Double rendaAnual, Integer numFunc) {
        super(name, rendaAnual);
        this.numFunc = numFunc;
    }

    public Integer getNumFunc() {
        return numFunc;
    }

    public void setNumFunc(int numFunc) {
        this.numFunc = numFunc;
    }

    @Override
    public double tax() {
        if (numFunc > 10 ) {
            return getRendaAnual() * 0.14;
        }
        else {
            return getRendaAnual() * 0.16;
        }
    }
}
