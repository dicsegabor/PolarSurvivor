package SwingMVC.View;

import Mozgathato.Eszkimo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class EntityImage {

    private BufferedImage image;
    private Object entity;

    public EntityImage(Object entity){

        this.entity = entity;
        getGraphics(entity);
    }

    private void getGraphics(Object entity){

        URL path = entity.getClass().getResource(entity.getClass().getSimpleName() + ".png");

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
