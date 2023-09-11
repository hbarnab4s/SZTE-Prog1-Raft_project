package Jatekmenet;

import java.util.ArrayList;

/**
 * Tuzhely osztaly
 * @author hb
 * @version 1.0
 * ebben az osztalyban hozom letre a ,metodusokat, amelyek a tuzhellyel kapcsolatosak, pl.: elhelyezese a palyan, a fozes elkezdese
 */
public class Tuzhely {
    private int tuzhelyX;
    private int tuzhelyY;
    private boolean van = false;
    private int elteltLepes;
    public ArrayList<Pozicio> tuzhelypoziciok = new ArrayList<>();

    public Tuzhely() {
    }

    public boolean isVan() {
        return van;
    }

    public void setVan(boolean van) {
        this.van = van;
    }

    public int getElteltLepes() {
        return elteltLepes;
    }

    public void setElteltLepes(int elteltLepes) {
        this.elteltLepes = elteltLepes;
    }

    public int getTuzhelyX() {
        return tuzhelyX;
    }

    public void setTuzhelyX(int tuzhelyX) {
        this.tuzhelyX = tuzhelyX;
    }

    public int getTuzhelyY() {
        return tuzhelyY;
    }

    public void setTuzhelyY(int tuzhelyY) {
        this.tuzhelyY = tuzhelyY;
    }

    /**
     * tuzhelyKeszites osztaly
     * @author hb
     * @param magassag a tuzhely pozicioja magassag szerint
     * @param szelesseg a tuzhely pozicioja szelesseg szerint
     * itt hozom letre a tuzhelyet. Levonodnak a nyersanyagok, elhelyezem a palyan az objektumot
     */
    public void tuzhelyKeszites(int magassag, int szelesseg){
        if(Jatek.jatek.getLeveldb() >= 4 && Jatek.jatek.getHulladekdb() >= 3 && Jatek.jatek.getDeszkadb() >= 2 && (Jatek.palya.getPalya(Jatek.jatekos.getJatekosX(), Jatek.jatekos.getJatekosY()).equals("--- "))) {
            Jatek.palya.tomb[magassag][szelesseg] = "TTT ";
            this.tuzhelyX = magassag;
            this.tuzhelyY = szelesseg;
            tuzhelypoziciok.add(new Pozicio(magassag, szelesseg));
            Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()-4);
            Jatek.jatek.setHulladekdb(Jatek.jatek.getHulladekdb()-3);
            Jatek.jatek.setDeszkadb(Jatek.jatek.getDeszkadb()-2);
            van = true;
            Jatek.jatekos.eleteroCsokkentes();
        } else {
            System.out.println("Figyelj, hogy legyen eleg nyersanyagod! Csak a tutajra epitheted fel a tuzhelyedet!");
        }
    }

    public void elkezdesHal(){
        for(Pozicio elem : tuzhelypoziciok){
            if(Jatek.jatekos.getJatekosX() == elem.getMagassag() && Jatek.jatekos.getJatekosY() == elem.getSzelesseg() && elteltLepes == 0) {
                elteltLepes++;
                Jatek.hal.setHalmennyiseg(Jatek.hal.getHalmennyiseg()-1);
                Jatek.jatekos.eleteroCsokkentes();
            } else {
                System.out.println("Lepj a tuzhely mezojere, ha eppen nem keszul rajta etel es keszits halat.");
                Jatek.jatekos.eleteroCsokkentes();
            }
        }

    }

    public void elkezdesBurgonya(){
        for(Pozicio elem : tuzhelypoziciok){
            if(Jatek.jatekos.getJatekosX() == elem.getMagassag() && Jatek.jatekos.getJatekosY() == elem.getSzelesseg() && elteltLepes == 0) {
                elteltLepes++;
                Jatek.jatek.setBurgonyadb(Jatek.jatek.getBurgonyadb()-1);
                Jatek.jatekos.eleteroCsokkentes();
            } else {
                System.out.println("Lepj a tuzhely mezojere, ha eppen nem keszul rajta etel es keszits burgonyat.");
                Jatek.jatekos.eleteroCsokkentes();
            }
        }

    }

    public boolean hasznalom(){
        if(elteltLepes != 0) {
            return true;
        }
        return false;
    }
}
