package MVC.CanvasView;

import MVC.View.Resources.ResourceProvider;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Drawable {
    protected Image image;

    public Drawable(String imageFileName) {
        loadImage(imageFileName);
    }

    public Image getDrawable() {
        return image;
    }

    public void loadImage(String imageFileName) {
        image = ResourceProvider.getResource(imageFileName);
    }
}
