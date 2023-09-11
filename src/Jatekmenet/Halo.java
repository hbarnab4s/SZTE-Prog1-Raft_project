package Jatekmenet;

import Nyersanyag.Nyersanyag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Halo {
    private int pozX;
    private int pozY;
    public ArrayList<Pozicio> halopoziciok = new ArrayList<>();
    public Halo() {
    }

    public int getPozX() {
        return pozX;
    }

    public void setPozX(int pozX) {
        this.pozX = pozX;
    }

    public int getPozY() {
        return pozY;
    }

    public void setPozY(int pozY) {
        this.pozY = pozY;
    }

    public void haloLetrehozas(){
        if(Jatek.jatek.getDeszkadb() >= 2 && Jatek.jatek.getLeveldb() >= 6) {
            Jatek.palya.tomb[Jatek.jatekos.getJatekosX()-1][Jatek.jatekos.getJatekosY()] = "HALO ";
            halopoziciok.add(new Pozicio(Jatek.jatekos.getJatekosX()-1, Jatek.jatekos.getJatekosY() ));
            Jatek.jatek.setDeszkadb(Jatek.jatek.getDeszkadb()-2);
            Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()-6);
            Jatek.jatekos.eleteroCsokkentes();
        }

    }

    public void haloNyersanyagotGyujt() {
        Nyersanyag seged = null;
        boolean logikai=false;
        for(Pozicio elem : halopoziciok) {
            for(Nyersanyag ny : Jatek.nyersanyag.osszTengerenNyersanyagok){
                if(Math.abs(elem.getMagassag()-ny.getX()) == 1 && Math.abs(elem.getSzelesseg()-ny.getY()) == 0) {
                    ny.setMennyiseg(ny.getMennyiseg()+1);
                    Jatek.nyersanyag.felvettTengerenNyersanyagok.add(ny);
                    Jatek.palya.tomb[ny.getX()][ny.getY()] = "*** ";
                    seged = ny;
                    ny.setX(0);
                    ny.setY(0);
                    logikai = true;
                }
            }
        }
        if(logikai){
            Jatek.palya.tomb[seged.getX()][seged.getY()] = "*** ";
            Jatek.nyersanyag.osszTengerenNyersanyagok.remove(seged);
        }
        Jatek.nyersanyag.szamlalas();
    }
}
