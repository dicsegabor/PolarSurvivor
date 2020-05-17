package MVC.View;

import MVC.View.Game.Mezo.MezoView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class WindowCanvas extends Pane {
    private Canvas canvas;
    private ArrayList<MezoView> mezoViews;
    private int mapHeight, mapWidth;

    public WindowCanvas(double w, double h) {
        this.setPrefSize(w, h);
        canvas = new Canvas(w, h);
        this.getChildren().add(canvas);
        draw();
    }

    public void setMapSize(int x, int y) { mapHeight = y; mapWidth = x; }

    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        double tileSize = this.getPrefHeight() / mapHeight;
        for(int i = 0; i < mapHeight; ++i) {
            for(int j = 0; j < mapWidth; ++j) {
                mezoViews.get(i * mapWidth + j).draw(canvas, i, j, tileSize, tileSize);
            }
        }
    }
}
