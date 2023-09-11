package Etel;

/**
 * Etel osztaly
 * @author hb
 * @version 1.0
 * Az Etel osztalybol szarmazik ketto gyerekosztaly, a Hal es a Burgonya. Azert van ra szukseg, hogy letre tudjam hozni az eheto dolgokat a palyan.
 */
public class Etel {
    String nev;
    int ehsegCsillapitas;

    public Etel(String nev, int ehsegCsillapitas) {
        this.nev = nev;
        this.ehsegCsillapitas = ehsegCsillapitas;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEhsegCsillapitas() {
        return ehsegCsillapitas;
    }

    public void setEhsegCsillapitas(int ehsegCsillapitas) {
        this.ehsegCsillapitas = ehsegCsillapitas;
    }
}
