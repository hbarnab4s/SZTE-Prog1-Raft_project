package Jatekmenet;

import Palya.*;
import Nyersanyag.*;
import Etel.*;
import java.util.*;

/**
 * Jatek osztaly
 * @version 1.0
 * @author hb
 * A Jatek osztaly foglalja egybe a projektet, ebben az osztalyban tortenik meg az iranyitas
 */


public class Jatek {
    public static Palya palya = new Palya(26,36);
    public static Jatekos jatekos = new Jatekos(13,18);
    public static Jatek jatek = new Jatek();
    public static Tutaj tutaj = new Tutaj(2,2);
    public static Hal hal = new Hal("Hal", 60);
    public static Viztisztito tisztito = new Viztisztito();
    public static Tuzhely tuzhely = new Tuzhely();
    public static Capa capa = new Capa();
    public static Nyersanyag nyersanyag = new Nyersanyag();
    public static Hordo hordo;
    public static Landzsa landzsa = new Landzsa();
    public static Halo halo = new Halo();
    private boolean gyozelem;
    private int deszkadb = 500;
    private int hulladekdb = 500;
    private int leveldb = 500;
    private int burgonyadb = 25;
    private static boolean vanBovites = false;

    public Jatek() {
    }

    public boolean isVanBovites() {
        return vanBovites;
    }

    public void setVanBovites(boolean vanBovites) {
        this.vanBovites = vanBovites;
    }

    public int getBurgonyadb() {
        return burgonyadb;
    }

    public void setBurgonyadb(int burgonyadb) {
        this.burgonyadb = burgonyadb;
    }

    public int getDeszkadb() {
        return deszkadb;
    }

    public void setDeszkadb(int deszkadb) {
        this.deszkadb = deszkadb;
    }

    public int getHulladekdb() {
        return hulladekdb;
    }

    public void setHulladekdb(int hulladekdb) {
        this.hulladekdb = hulladekdb;
    }

    public int getLeveldb() {
        return leveldb;
    }

    public void setLeveldb(int leveldb) {
        this.leveldb = leveldb;
    }

    public Jatek(boolean gyozelem) {
        this.gyozelem = gyozelem;
    }

    public boolean isGyozelem() {
        return gyozelem;
    }

    public void setGyozelem(boolean gyozelem) {
        this.gyozelem = gyozelem;
    }


    /**
     * kiiratas metodus
     * @author hb
     * megsporolok nehany sort a main-bol, ezt a metodust meghivom a mainben
     */

    public void kiiratas2(){
        System.out.println("*** -> tenger, --- -> tutaj, DDD -> deszka, LLL -> level, HUL -> hulladek, HHH -> hordo, KKK -> karakter, TTT -> tuzhely, VVV -> viztisztito, CCC -> capa.");
        System.out.println("Mozgasok: fel->w, balra->a, le->s, jobbra->d, atlosanFelJobbra->wd, atlosanFelBalra->wa, atlosanLeJobbra->sd, atlosanLeBalra->sa");
        System.out.println("Ha mar a vizben allsz es halat akarsz fogni: hal. Ha nyersanyag csak egy tavolsagra van toled: gyujt, ha ennel: eszem, ha innal: iszom.");
        System.out.println("Amennyiben a tuatjodat bovitened: bovit. Ha halot akarsz csatolni a tutajhoz: halo");
        System.out.println("Ehseg: " + jatekos.ehseg + ", szomjusag: " + jatekos.szomjusag + ".");
        System.out.println("Deszka: " + this.deszkadb + ". Hulladek: " + this.hulladekdb + ". Level: " + this.leveldb + ". Burgonya: " + this.burgonyadb + ", Hal: " + hal.getHalmennyiseg()+".");
        System.out.println("Landzsa: " + (landzsa.isVanLandzsa() ? "van." : "nincs."));
    }

    /**
     * a main fuggveny
     * @author hb
     * @param args nem kap arumentumokat
     * itt er ossze minden, ez a "vezerloje" a projektnek
     * letrehozom az objektumokat, meghivom az utasitasok alapjan szukseges metodusokat a tobbi osztalybol.
     */
    public static void main(String[] args) {
        int db=1;
        Scanner sc = new Scanner(System.in);
        palya.ujPalya();
        palya.ujPalyaJatekosNelkul();
        tutaj.tutajEpites(tutaj.getSzelessegTutaj(), tutaj.getMagassagTutaj());
        while(db <= 1000 && jatekos.ehseg >0 && jatekos.szomjusag >0) {
            int hatralevoKorok = 1000 - db;
            System.out.println();
            System.out.println(db + ". kor:");
            jatek.kiiratas2();
            System.out.println("Hatralevo korok szama: " + hatralevoKorok);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            palya.palyaFelepites();
            palya.palyaFelepitesJatekosNelkul();
            vanBovites = false;
            String utasitas;
            do{
                utasitas = sc.nextLine();
                if(!(utasitas.equals("w") || utasitas.equals("a") || utasitas.equals("s") || utasitas.equals("d") || utasitas.equals("wd") || utasitas.equals("wa") ||
                        utasitas.equals("sd") || utasitas.equals("sa") || utasitas.equals("hal") || utasitas.equals("gyujt") || utasitas.equals("tisztito") ||
                        utasitas.equals("tuzhely") || utasitas.equals("eszem") || utasitas.equals("iszom") || utasitas.equals("bovit") || utasitas.equals("landzsa") ||
                        utasitas.equals("halo") || utasitas.equals("tuzhely hal") || utasitas.equals("tuzhely burgonya"))) {
                    System.out.println("Ugy tunik, hogy nem jol irtad be a parancsot, probald ujra: ");
                }
            }while(!(utasitas.equals("w") || utasitas.equals("a") || utasitas.equals("s") || utasitas.equals("d") || utasitas.equals("wd") || utasitas.equals("wa") ||
                    utasitas.equals("sd") || utasitas.equals("sa") || utasitas.equals("hal") || utasitas.equals("gyujt") || utasitas.equals("tisztito") ||
                    utasitas.equals("tuzhely") || utasitas.equals("eszem") || utasitas.equals("iszom") || utasitas.equals("bovit") || utasitas.equals("landzsa") ||
                    utasitas.equals("halo") || utasitas.equals("tuzhely hal") || utasitas.equals("tuzhely burgonya")));
            if (utasitas.equals("w")) { jatekos.mozgasfel(); }
            else if (utasitas.equals("a")) { jatekos.mozgasbalra(); }
            else if (utasitas.equals("s")) { jatekos.mozgasle(); }
            else if (utasitas.equals("d")) { jatekos.mozgasjobbra(); }
            else if (utasitas.equals("wd")) { jatekos.mozgasAtlosanFelJobbra(); }
            else if (utasitas.equals("wa")) { jatekos.mozgasAtlosanFelBalra(); }
            else if (utasitas.equals("sd")) { jatekos.mozgasAtlosanLeJobbra(); }
            else if (utasitas.equals("sa")) { jatekos.mozgasAtlosanLeBalra(); }
            else if (utasitas.equals("hal")) { hal.horgaszik(); }
            else if (utasitas.equals("gyujt")) {nyersanyag.nyersanyagotGyujt(); }
            else if (utasitas.equals("tisztito")) { tisztito.viztisztitoKeszites(jatekos.getJatekosX()-1, jatekos.getJatekosY());}
            else if (utasitas.equals("tuzhely")) { tuzhely.tuzhelyKeszites(jatekos.getJatekosX()-1, jatekos.getJatekosY());}
            else if (utasitas.equals("tuzhely hal")) {tuzhely.elkezdesHal();}
            else if (utasitas.equals("tuzhely burgonya")) {tuzhely.elkezdesBurgonya();}
            else if (utasitas.equals("eszem")) { jatekos.eszik(); }
            else if (utasitas.equals("iszom")) { jatekos.iszik(); }
            else if (utasitas.equals("bovit")) {
                tutaj.tutajtBovit();
                vanBovites = true;
            }
            else if (utasitas.equals("landzsa")) { landzsa.landzsakeszites(); }
            else if (utasitas.equals("halo")) { halo.haloLetrehozas(); }
            else { jatekos.eleteroCsokkentes(); }
            if(tuzhely.hasznalom()) { tuzhely.setElteltLepes(tuzhely.getElteltLepes()+1); }
            if(tisztito.isVan()) {tisztito.setElteltLepesek(tisztito.getElteltLepesek()+1);}
            palya.palyaMentes();
            if (capa.capaKill()) {
                System.out.println("Sajnos a jatek veget ert, mert megevett egy capa! Vesztettel! :(");
                return;
            }
            halo.haloNyersanyagotGyujt();
            db++;
        }
    }
}
