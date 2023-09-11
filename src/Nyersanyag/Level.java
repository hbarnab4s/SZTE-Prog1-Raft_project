package Nyersanyag;

import java.util.Random;
/**
 * Level osztaly
 * @author hb
 * @version 1.0
 * a tengerben es a hordoban is nyersanyagok generalodnak. az egyik a level. Ebbol az osztalybol keszulnek el az objektumok, ez az osztaly a Nyersanyag osztaly gyerekosztalya.
 */
public class Level extends Nyersanyag{
    public Level(int nyersanyagTavolsag, String tipus, int x, int y) {
        super(nyersanyagTavolsag, tipus, x, y);
        mennyiseg = 0;
    }
}
