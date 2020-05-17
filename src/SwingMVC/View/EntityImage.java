package SwingMVC.View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class EntityImage {

    private BufferedImage image;
    private int ID;

    public EntityImage(String path, int ID){

        this.ID = ID;
        try { image = ImageIO.read(new FileInputStream(path)); }
        catch (IOException e) { System.out.println("A fájl nem található: '" + path + "'");}
    }

    public int getID() {

        return ID;
    }

    public BufferedImage getImage() {

        return image;
    }
}
