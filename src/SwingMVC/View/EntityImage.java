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
     * A k�p, ami az entit�shoz tartozik.
     */
    private BufferedImage image;

    /**
     * Az entit�s, amihez a k�p tartozik.
     */
    private Object entity;

    public EntityImage(Object entity, boolean highlighted){

        this.entity = entity;
        getGraphics(entity, highlighted);
    }

    /**
     * Lek�rdezi a megadot entit�shoz tartoz� grafik�t, az oszt�ly neve alapj�n.
     * @param entity Az entit�s
     * @param highlighted Ki van-e jel�lve. (csak karakter eset�n m�k�dik)
     */
    private void getGraphics(Object entity, boolean highlighted){

        URL path;

        if(!highlighted)
            path = entity.getClass().getResource(entity.getClass().getSimpleName() + ".png");

        else
            path = entity.getClass().getResource("H" + entity.getClass().getSimpleName() + ".png");

        try { image = ImageIO.read(path); }
        catch (IOException e) { System.out.println("A f�jl nem tal�lhat�: '" + path + "'");}
    }

    /**
     * Visszat�r az entit�ssal.
     */
    public Object getEntity() {

        return entity;
    }

    /**
     * Visszat�r a t�rolt k�ppel.
     */
    public BufferedImage getImage() {

        return image;
    }
}
