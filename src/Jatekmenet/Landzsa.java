package Jatekmenet;

public class Landzsa {
    private boolean vanLandzsa = false;

    public Landzsa() {
    }

    public boolean isVanLandzsa() {
        return vanLandzsa;
    }

    public void setVanLandzsa(boolean vanLandzsa) {
        this.vanLandzsa = vanLandzsa;
    }

    public void landzsakeszites(){
        if(Jatek.jatek.getDeszkadb() >= 4 && Jatek.jatek.getLeveldb() >= 4 && Jatek.jatek.getHulladekdb() >= 4) {
            Jatek.jatekos.eleteroCsokkentes();
            Jatek.jatek.setDeszkadb(Jatek.jatek.getDeszkadb()-4);
            Jatek.jatek.setLeveldb(Jatek.jatek.getLeveldb()-4);
            Jatek.jatek.setHulladekdb(Jatek.jatek.getHulladekdb()-4);
            vanLandzsa = true;
        } else {
            vanLandzsa = false;
        }
    }
}
