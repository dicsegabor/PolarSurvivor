package SwingMVC.View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * A jegtablakon megjeleno enitasok kepeit tarolja, illetve kezeli azok betolteset.
 * Fõ funkciója az, hogy megadhatunk neki egy objectet és betölti az ahoz tartozó képet.
 */
public class EntityImage {

    /**
     * A kép, ami az objektumhoz tartozik.
     * Automatikusan betöltõdik a létrehozáskor
     */
    private BufferedImage image;

    /**
     * Az object, amihez a kép tartozik.
     * Ide csak olyanokat adjunk meg, amikhez van képünk.
     */
    private Object entity;

    public EntityImage(Object entity, boolean highlighted){

        this.entity = entity;
        getGraphics(entity, highlighted);
    }

    /**
     * Lekérdezi a megadot entitáshoz tartozó grafikát, az osztály neve alapján.
     * @param entity Az entitás
     * @param highlighted Ki van-e jelölve. (csak karakter esetén mûködik)
     */
    private void getGraphics(Object entity, boolean highlighted){

        URL path;

        //Ha ki van jelölve a karakter, akkor a kijelölt kéet tölti be hozzzá
        if(!highlighted)
            path = entity.getClass().getResource(entity.getClass().getSimpleName() + ".png");

        //Ha nincs kijelölve a karakter akkor a nem kjelöt képet tölti be hozzá
        else
            path = entity.getClass().getResource("H" + entity.getClass().getSimpleName() + ".png");

        //Az ImageIO segítségével beolvassuk a képet.
        try { image = ImageIO.read(path); }
        catch (IOException e) { System.out.println("A fájl nem található: '" + path + "'");}
    }

    /**
     * Visszatér az entitással,
     * így elérhetjük a kép modellbeli emgfelelõjét.
     */
    public Object getEntity() {

        return entity;
    }

    /**
     * Visszatér a tárolt képpel,
     * így elérhetjük az objektum view-beli megfelelõjét.
     */
    public BufferedImage getImage() {

        return image;
    }
}
