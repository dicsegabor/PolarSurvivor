package SwingMVC.View;

import Mezo.Mezo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MezoView extends JPanel {

    private Mezo mezo;

    public MezoView(Mezo mezo){

        this.mezo = mezo;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.WHITE);
        addMenuListener();
    }

    public Mezo getMezo() {

        return mezo;
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
