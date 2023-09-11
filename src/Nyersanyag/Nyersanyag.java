package Nyersanyag;

import Jatekmenet.*;
import Etel.*;
import Palya.*;
import java.util.*;

/**
 * Nyersanyag osztaly
 * @version 1.0
 * @author hb
 * A Nyersanyag osztalyban valositok meg minden nyersanyaggal kapcsolatos metodust, amit aztan meghivhatok a Jatek osztalyban.
 */
public class Nyersanyag {
    protected int nyersanyagTavolsag;
    int mennyiseg;
    protected String tipus;
    protected int x;
    protected int y;
    public ArrayList<Nyersanyag> osszTengerenNyersanyagok = new ArrayList<Nyersanyag>();
    public ArrayList<Nyersanyag> ujTengerenNyersanyagok = new ArrayList<Nyersanyag>();
    public ArrayList<Nyersanyag> felvettTengerenNyersanyagok = new ArrayList<Nyersanyag>();

    public Nyersanyag(int nyersanyagTavolsag, String tipus, int x, int y) {
        this.nyersanyagTavolsag = nyersanyagTavolsag;
        this.tipus = tipus;
        this.x = x;
        this.y = y;
        this.mennyiseg = 0;
    }
    public Nyersanyag(){}

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public int getNyersanyagTavolsag() {
        return nyersanyagTavolsag;
    }

    public void setNyersanyagTavolsag(int nyersanyagTavolsag) {
        this.nyersanyagTavolsag = nyersanyagTavolsag;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    /**
     * NyersanyagokTengeren metodus
     * @author hb
     * @param nyersanyag ez a Jatek.nyersanyagGeneralas metodusbol erkezo parameter, ami belekerul az ujTengerenNyersanyagok listaba
     * celja, hogy a parameterben kapott nyersanyag az ujTengerenNyersanyagok listaba keruljon
     */
    public void NyersanyagokTengeren(Nyersanyag nyersanyag){
        ujTengerenNyersanyagok.add(nyersanyag);
    }

    /**
     * nyersanyagGeneralas metodus
     * @author hb
     * a felteteleknek megfeleloen letrehozok egy random nyersanyagot
     */
    public void nyersanyagGeneralas(){
        nyersanyagFolyas();
        Random r = new Random();
        int randomSzam2 = r.nextInt(120); //ez azt hatarozza meg, hogy az adott korben hany nyersanyag generalodik majd
        int generaltNyersanyagok = 0;
        if(randomSzam2 < 30) { generaltNyersanyagok = 0; }
        else if(randomSzam2 < 60) { generaltNyersanyagok = 1; }
        else if(randomSzam2 < 90) { generaltNyersanyagok = 2; }
        else { generaltNyersanyagok = 3; }

        int j = 1;
        while (j <= generaltNyersanyagok) {
            int randomSzam1 = r.nextInt(100000); // ez a 4 nyersanyag kivalasztasahoz kell
            if (randomSzam1 < 32000) {
                Deszka deszka = new Deszka(1, "DDDD", 0, 0);
                NyersanyagokTengeren(deszka);
                j++;
            }
            else if (randomSzam1 < 64000) {
                Hulladek hulladek = new Hulladek(1, "HULL", 0, 0);
                NyersanyagokTengeren(hulladek);
                j++;
            }
            else if (randomSzam1 < 96000) {
                Level level = new Level(1, "LLLL", 0, 0);
                NyersanyagokTengeren(level);
                j++;
            }
            else {
                Jatek.hordo = new Hordo(1, "HHHH", 0, 0);
                NyersanyagokTengeren(Jatek.hordo);
                int i = 0;
                while (i < 5) {
                    int randomSzam3 = r.nextInt(1000); //ez a hordon belul hatarozza meg a nyersanyagokat
                    if(randomSzam3 < 250) {
                        Jatek.hordo.hordoFeltoltes(new Deszka(1, "DDDD", 0, 0));
                    }
                    else if (randomSzam3 < 500) {
                        Jatek.hordo.hordoFeltoltes(new Level(1, "LLLL", 0, 0));
                    }
                    else if (randomSzam3 < 750) {
                        Jatek.hordo.hordoFeltoltes(new Hulladek(1, "HULL", 0, 0));
                    }
                    else {Jatek.hordo.hordoFeltoltesBurgonya(new Burgonya("BURG", 60));}
                    i++;
                }
                j++;
            }
        }
    }

    /**
     * szamlalas metodus
     * @author hb
     * ez a mektodus a felvett nyersanyagokkal foglalkozik. Amikor felveszek gy nyersanyagot, azt el kell tudni tarolni. Igy a felvett nyersanyagokat egy listaban mentem el, amin aztan
     * vegigmegyek es megvizsgalom, hogy milyen nyersanyag van a listamban. Azt vegul visszaadom.
     */
    public void szamlalas(){
        for(Nyersanyag ny : felvettTengerenNyersanyagok){
            if(ny.getTipus().equals("DDDD")){
                Jatek.jatek.setDeszkadb(Jatek.jatek.getDeszkadb()+1);
            }
            else if(ny.getTipus().equals("HULL")){
                Jatek.jatek.setHulladekdb(Jatek.jatek.getHulladekdb()+1);
            }
            else if(ny.getTipus().equals("LLLL")){
                Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()+1);
            }
            else if(ny.getTipus().equals("HHHH")){
                for(Nyersanyag ny2: Jatek.hordo.hordobanNyersanyag) {
                    if(ny2.getTipus().equals("DDDD")) {
                        Jatek.jatek.setDeszkadb(Jatek.jatek.getDeszkadb()+1);
                    }
                    if(ny2.getTipus().equals("HULL")){
                        Jatek.jatek.setHulladekdb(Jatek.jatek.getHulladekdb()+1);
                    }
                    if(ny2.getTipus().equals("LLLL")){
                        Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()+1);
                    }
                }
                Jatek.jatek.setBurgonyadb(Jatek.jatek.getBurgonyadb() + Jatek.hordo.hordobanBurgonya.size());

                Jatek.hordo.hordobanNyersanyag.clear();
                Jatek.hordo.hordobanBurgonya.clear();
            }
        }
        felvettTengerenNyersanyagok.clear();

    }

    /**
     * milyenNyersanyag metodus
     * @author hb
     * @param ny az parameterben kapott nyersanyagrol megmondja, hogy milyen.
     * @return visszaadja a nyersanyag tipusat
     */

    public String milyenNyersanyag(Nyersanyag ny){
        if(ny.getTipus().equals("DDDD")) { //deszka
            return "DDD ";

        }
        else if(ny.getTipus().equals("LLLL")) { //level
            return "LLL ";
        }
        else if(ny.getTipus().equals("HULL")) { //hulladek
            return "HUL ";
        }
        else {//hordo
            return "HHH ";
        }
    }

    /**
     * nyersanyagElhelyezes metodus
     * @author hb
     * a nyersanyagGeneralas metodusban legeneralt nyersanyagot elhelyezi egy random poziciora az elso sorban
     */
    public void nyersanyagElhelyezes(){
        Random random = new Random();
        for(Nyersanyag ny : ujTengerenNyersanyagok){
            int randomszam = random.nextInt(26);
            Jatek.palya.tomb[0][randomszam] = milyenNyersanyag(ny);
            ny.setX(0);
            ny.setY(randomszam);
            osszTengerenNyersanyagok.add(ny);
        }
        ujTengerenNyersanyagok.clear();
    }

    /**
     * nyersanyagFolyas metodus
     * @author hb
     * ez a metodus felelos azert, hogy a generalt nyersanyagok "lefollyanak" a tengeren
     */

    public void nyersanyagFolyas(){
        for(int i = 0; i < 36; i++) {
            Jatek.palya.tomb[0][i] = "*** ";
            Jatek.palya.tomb[25][i] = "*** ";
        }
        for(Nyersanyag ny : osszTengerenNyersanyagok){
            Jatek.palya.tomb[ny.getX()][ny.getY()] = "*** ";
            if(ny.getX()==25){
                ny.setX(ny.getX());
                //tomb[ny.getX()][ny.getY()] = milyenNyersanyag(ny);
            } else {
                ny.setX(ny.getX() + 1);
                Jatek.palya.tomb[ny.getX()][ny.getY()] = milyenNyersanyag(ny);
            }
        }
        Jatek.tutaj.tutajSeged();
    }

    /**
     * nyersanyagotGyujt metodus
     * @author hb
     * ezt a metodust a Jatek osztaly main fuggvenyeben meghivva be tudom gyujteni a felteteleknek megfelelo nyersanyagot
     */

    public void nyersanyagotGyujt(){
        Nyersanyag seged = null;
        boolean logikai=false;
        for(Nyersanyag ny : osszTengerenNyersanyagok){
            if(tavolsagMeghatarozas(ny)) {
                Jatek.jatekos.eleteroCsokkentes();
                System.out.println(ny.getTipus());
                ny.setMennyiseg(ny.getMennyiseg()+1);
                felvettTengerenNyersanyagok.add(ny);
                Jatek.palya.tomb[ny.getX()][ny.getY()] = "*** ";
                seged = ny;
                ny.setX(0);
                ny.setY(0);
                logikai = true;
            }
        }
        if(logikai){
            Jatek.palya.tomb[seged.getX()][seged.getY()] = "*** ";
            osszTengerenNyersanyagok.remove(seged);
        }
        szamlalas();
    }

    /**
     * tavolsagMeghatarozas metodus
     * @author hb
     * @param ny a kapott nyersanyagrol meg kell mondani, hogy milyen tavolsagra van a karaktertol
     * @return igazat ad vissza, ha a nyersanyag eleg kozel van ahhoz, hogy begyujtsunk egy nyersanyagot. Hamisat, ha nincs eleg kozel.
     */
    public boolean tavolsagMeghatarozas(Nyersanyag ny){
        int xTavolsag = Jatek.jatekos.getJatekosX() - ny.getX();
        int yTavolsag = Jatek.jatekos.getJatekosY() - ny.getY();
        if((Math.abs(xTavolsag) == 1 && Math.abs(yTavolsag) == 1) || (Math.abs(xTavolsag) == 1 && Math.abs(yTavolsag) == 0) || (Math.abs(xTavolsag) == 0 && Math.abs(yTavolsag) == 1) ) {
            return true;
        } else {
            return false;
        }
    }
}
