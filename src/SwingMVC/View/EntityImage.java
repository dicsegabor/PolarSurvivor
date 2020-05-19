package SwingMVC.View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * A jegtablakon megjeleno enitasok kepeit tarolja, illetve kezeli azok betolteset.
 */
public class EntityImage {

    /**
     * A kép, ami az entitáshoz tartozik.
     */
    private BufferedImage image;

    /**
     * Az entitás, amihez a kép tartozik.
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

        if(!highlighted)
            path = entity.getClass().getResource(entity.getClass().getSimpleName() + ".png");

        else
            path = entity.getClass().getResource("H" + entity.getClass().getSimpleName() + ".png");

        try { image = ImageIO.read(path); }
        catch (IOException e) { System.out.println("A fájl nem található: '" + path + "'");}
    }

    /**
     * Visszatér az entitással.
     */
    public Object getEntity() {

        return entity;
    }

    /**
     * Visszatér a tárolt képpel.
     */
    public BufferedImage getImage() {

        return image;
    }
}
