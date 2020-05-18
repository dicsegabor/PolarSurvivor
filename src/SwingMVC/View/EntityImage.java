package SwingMVC.View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class EntityImage {

    private BufferedImage image;
    private Object entity;

    public EntityImage(Object entity, boolean highlighted){

        this.entity = entity;
        getGraphics(entity, highlighted);
    }

    private void getGraphics(Object entity, boolean highlighted){

        URL path;

        if(!highlighted)
            path = entity.getClass().getResource(entity.getClass().getSimpleName() + ".png");

        else
            path = entity.getClass().getResource("H" + entity.getClass().getSimpleName() + ".png");

        try { image = ImageIO.read(path); }
        catch (IOException e) { System.out.println("A fájl nem található: '" + path + "'");}
    }

    public Object getEntity() {

        return entity;
    }

    public BufferedImage getImage() {

        return image;
    }
}
