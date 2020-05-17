package SwingMVC.View;

import Mezo.Mezo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class MezoView extends JPanel {

    private Mezo mezo;
    private HashMap<Integer, JLabel> picLabels;
    private BufferedImage backgroundImage;

    public MezoView(Mezo mezo){

        picLabels = new HashMap<>();

        this.mezo = mezo;
        addMenuListener();
    }

    public Mezo getMezo() {

        return mezo;
    }

    public void setBackgroundImage(String path){

        try { backgroundImage = ImageIO.read(new FileInputStream(path)); }
        catch (IOException e) { System.out.println("A fájl nem található: '" + path + "'");}
        setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(backgroundImage , 0, 0, null);
    }

    private void addEntityImage(EntityImage image){

        JLabel picLabel = new JLabel(new ImageIcon(image.getImage()));
        picLabels.putIfAbsent(image.getID(), picLabel);
        add(picLabel);
    }

    private void removeEntityImage(int ID){

        remove(picLabels.get(ID));
        picLabels.remove(ID);
    }

    private void addMenuListener(){

        MezoView view = this;

        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(SwingUtilities.isRightMouseButton(e)) {

                    MezoMenu menu = new MezoMenu(view);
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        };

        addMouseListener(listener);
    }
}
