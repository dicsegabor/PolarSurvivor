package MVC.View.Resources;

import javafx.scene.image.Image;

import java.util.HashMap;

public class ResourceProvider {
    private static HashMap<String, Image> images = new HashMap<>();
    private static String path = "file:src/MVC/View/Resources/";

    public static Image getResource(String fileName) {
        if(images.containsKey(fileName))
            return images.get(fileName);

        Image img = new Image(path + fileName);
        images.put(fileName, img);
        return img;
    }
}
