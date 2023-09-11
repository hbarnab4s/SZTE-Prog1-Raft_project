package Jatekmenet;

import java.util.ArrayList;

public class Viztisztito {
    private int viztisztitopozX;
    private int viztisztitopozY;
    private boolean van = false;
    private int elteltLepesek;
    public ArrayList<Pozicio> tisztitopoziciok = new ArrayList<>();

    public Viztisztito() {

    }

    public int getElteltLepesek() {
        return elteltLepesek;
    }

    public void setElteltLepesek(int elteltLepesek) {
        this.elteltLepesek = elteltLepesek;
    }

    public boolean isVan() {
        return van;
    }

    public void setVan(boolean van) {
        this.van = van;
    }

    public int getViztisztitopozX() {
        return viztisztitopozX;
    }

    public void setViztisztitopozX(int viztisztitopozX) {
        this.viztisztitopozX = viztisztitopozX;
    }

    public int getViztisztitopozY() {
        return viztisztitopozY;
    }

    public void setViztisztitopozY(int viztisztitopozY) {
        this.viztisztitopozY = viztisztitopozY;
    }

    public void viztisztitoKeszites(int magassag, int szelesseg){
        if(Jatek.jatek.getLeveldb() >= 2 && Jatek.jatek.getHulladekdb() >= 4 ) {
            Jatek.palya.tomb[magassag][szelesseg] = "VVV ";
            this.viztisztitopozX = magassag;
            this.viztisztitopozY = szelesseg;
            tisztitopoziciok.add(new Pozicio(magassag, szelesseg));
            Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()-2);
            Jatek.jatek.setHulladekdb(Jatek.jatek.getHulladekdb()-4);
            van = true;
            Jatek.jatekos.eleteroCsokkentes();
            this.elteltLepesek++;
        }
    }
}
