package Palya;

import Jatekmenet.Jatek;

/**
 * Palya osztaly
 * @version 1.0
 * @author hb
 * Ebben az osztalyban keszultek el azok a metodusok, amik a palya megjelenesevel kapcsolatosak.
 * int szelesseg: a palya szelessege, int szelessegFele: a palya szelessegenek a fele
 * int magassag: a palya magassaga, int magassagFele: a palya magassaganak a fele
 * String[][] tomb: a palyat egy 2dimenzios tombben tarolom el.
 * String[][] tombMasolat: a palyarol keszult masolatot egy 2dimenzios tombben tarolom el
 */

public class Palya {
    private int szelesseg;
    private int magassag;
    private int magassagFele;
    private int szelessegFele;
    public String[][] tomb;
    public String[][] tombMasolat;
    public String[][] tomb2;

    /**
     * enum Color
     * @author hb
     * Celja, hogy a kulonbozo jelentessel biro karakterek kulonbozo szinekkel jelenjenek meg a jatek soran
     */
    enum Color {
        //Color end string, color reset
        RESET("\033[0m"),

        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m");    // WHITE

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    public Palya() {
        this.magassag = 26;
        this.szelesseg = 36;
        this.magassagFele = this.magassag/2;
        this.szelessegFele = this.szelesseg/2;

    }

    public Palya(int magassag, int szelesseg) {
        this.szelesseg = szelesseg;
        this.magassag = magassag;
    }

    public String[][] getTomb() {
        return tomb;
    }

    public void setTomb(String[][] tomb) {
        this.tomb = tomb;
    }

    public int getMagassagFele() {
        return magassagFele;
    }

    public void setMagassagFele(int magassagFele) {
        this.magassagFele = magassagFele;
    }

    public int getSzelessegFele() {
        return szelessegFele;
    }

    public void setSzelessegFele(int szelessegFele) {
        this.szelessegFele = szelessegFele;
    }

    public int getSzelesseg() {
        return szelesseg;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    /**
     * ujPalya metodus
     * @author hb
     * ebben a metodusban keszul el a palya, ami egy tomb. Feltoltom tengerrel (csillagokkal)
     */
    public void ujPalya() {
        tomb = new String[this.magassag][this.szelesseg];
        for(int i = 0; i < tomb.length; i++) {
            for (int j = 0; j < tomb[i].length; j++) {
                tomb[i][j] = "*** ";
            }
        }
    }

    public void ujPalyaJatekosNelkul() {
        tomb2 = new String[this.magassag][this.szelesseg];
        for(int i = 0; i < tomb2.length; i++) {
            for (int j = 0; j < tomb2[i].length; j++) {
                tomb2[i][j] = "*** ";
            }
        }
    }

    public void palyaFelepitesJatekosNelkul(){
        Jatek.tutaj.tutajEpites(2,2);
    }

    public void palyaFelepites(){
        Jatek.nyersanyag.nyersanyagGeneralas();
        Jatek.nyersanyag.nyersanyagElhelyezes();
        //Jatek.tutaj.holVanTutaj();
        Jatek.tutaj.tutajSeged();
        Jatek.jatekos.jatekosMegjelenites();
        //Jatek.capa.capaMozgas();
        Jatek.capa.capaElhelyezes();
        Jatek.palya.palyaMegjelenites();
    }

    public String getPalya(int magassag, int szelesseg) {
        return tomb[magassag][szelesseg];
    }

    /**
     * palyaMentes
     * @author hb
     * ebben a metodusban a tombrol keszul egy masolat
     */

    public void palyaMentes() {
        tombMasolat = new String[this.magassag][this.szelesseg];
        tombMasolat = tomb;
    }

    /**
     * palyaMegjelenites
     * @author hb
     * ugyan a palya tomb mar elkeszult, de meg nem irattam ki. Ebben a metodusban kerul kiirasra a palya, itt hatarozom meg, hogy az egyes elemeknek milyen szine legyen.
     */

    public void palyaMegjelenites() {
        for (int i = 0; i < tomb.length; i++) {
            for (int j = 0; j < tomb[i].length; j++) {
                if(tomb[i][j].equals("*** ")){
                    System.out.print(Color.BLUE);
                }
                else if(tomb[i][j].equals("--- ")){
                    System.out.print(Color.YELLOW);
                }
                else if(tomb[i][j].equals("KKK ")){
                    System.out.print(Color.RED);
                }
                else if(tomb[i][j].equals("DDD ")){
                    System.out.print(Color.YELLOW);
                }
                else if(tomb[i][j].equals("LLL ")){
                    System.out.print(Color.GREEN);
                }
                else if(tomb[i][j].equals("HUL ")){
                    System.out.print(Color.CYAN);
                }
                else if(tomb[i][j].equals("HHH ")){
                    System.out.print(Color.MAGENTA);
                } else {
                    System.out.print(Color.RESET);
                }
                System.out.print(tomb[i][j]);
            }
            System.out.print(Color.RESET);
            System.out.println();
        }
        System.out.print(Color.RESET);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
