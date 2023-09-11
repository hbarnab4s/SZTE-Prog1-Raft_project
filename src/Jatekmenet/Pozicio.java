package Jatekmenet;

public class Pozicio {
    private int magassag;
    private int szelesseg;

    public Pozicio(int magassag, int szelesseg) {
        this.magassag = magassag;
        this.szelesseg = szelesseg;
    }



    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public int getSzelesseg() {
        return szelesseg;
    }

    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }
}
