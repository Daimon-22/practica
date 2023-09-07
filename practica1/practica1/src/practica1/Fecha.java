package practica1;

import java.io.Serializable;

public class Fecha implements Serializable{
	private static final long serialVersionUID = 5153805335154147730L;
	private int dd;
    private int mm;
    private int aa;

    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return "Fecha {" +
                "día =" + dd +
                ", mes =" + mm +
                ", año =" + aa +
                '}';
    }
}
