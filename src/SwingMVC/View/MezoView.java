package SwingMVC.View;

import Mezo.*;
import Mozgathato.*;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import SwingMVC.Eventhandling.Events.*;
import Targy.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class MezoView extends JPanel {

    private Mezo mezo;
    private HashMap<Object, JLabel> picLabels;
    private BufferedImage backgroundImage;

    public MezoView(Mezo mezo){

        picLabels = new HashMap<>();

        this.mezo = mezo;
        setBackgroundImage();
        addMenuListener();

        GridLayout layout = new GridLayout();
        layout.setColumns(3);
        layout.setRows(3);
        layout.setHgap(3);
        layout.setVgap(3);
        setLayout(layout);

        drawEntities();
        legyenHo();

        setupMezoListener();
    }

    public Mezo getMezo() {

        return mezo;
    }

    private void drawEntities() {

        for(Karakter k : mezo.getKarakterek())
            addEntityImage(new EntityImage(k));

        if(mezo.getJegesmedve() != null)
            addEntityImage(new EntityImage(mezo.getJegesmedve()));
    }

    private void setBackgroundImage(){

        URL path = mezo.getClass().getResource(mezo.getClass().getSimpleName() + ".png");

        try { backgroundImage = ImageIO.read(path); }
        catch (IOException e) { System.out.println("A f�jl nem tal�lhat�: '" + path + "'");}
        setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
        repaint();
        revalidate();
    }

    public void setBackgroundImage(Object mezotipus){

        URL path = mezotipus.getClass().getResource(mezotipus.getClass().getSimpleName() + ".png");

        try { backgroundImage = ImageIO.read(path); }
        catch (IOException e) { System.out.println("A f�jl nem tal�lhat�: '" + path + "'");}
        setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
        repaint();
        revalidate();
    }

    private void legyenHo(){

        if(mezo.getHoreteg() != 0){

            String path = "src\\SwingMVC\\View\\Ho.png";

            try { backgroundImage = ImageIO.read(new FileInputStream(path)); }
            catch (IOException e) { System.out.println("A f�jl nem tal�lhat�: '" + path + "'");}
            setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));

            if(!mezo.getClass().equals(Lyuk.class)) {

                Targy targy = ((Jegtabla) mezo).getTargy();
                if(targy != null)
                    removeEntityImage(targy);
            }
            repaint();
            revalidate();
        }

        else{
            setBackgroundImage(mezo);

            if(!mezo.getClass().equals(Lyuk.class)) {
                if(!picLabels.containsKey(((Jegtabla) mezo).getTargy())) {

                    Targy targy = ((Jegtabla) mezo).getTargy();
                    if (targy != null)
                        addEntityImage(new EntityImage(targy));
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(backgroundImage , 0, 0, null);
    }

    private void addEntityImage(EntityImage image){

        JLabel picLabel = new JLabel(new ImageIcon(image.getImage()));
        picLabels.putIfAbsent(image.getEntity(), picLabel);
        add(picLabel);
    }

    private void removeEntityImage(Object entity){

        if(picLabels.get(entity) != null) {

            remove(picLabels.get(entity));
            picLabels.remove(entity);
        }
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

    private void setupMezoListener(){

        MezoEventListener mezoEventListener = new MezoEventListener() {

            @Override
            public void atfordult(AtfordulasEvent event) {

                if (mezo.equals(event.getSource())) {
                    mezo = new Lyuk(false);
                    setBackgroundImage();
                }
            }

            @Override
            public void astak(AsasEvent event) {

                if(((Karakter)event.getSource()).getMezo().equals(mezo)) {

                    legyenHo();
                    repaint();
                    revalidate();
                }
            }

            @Override
            public void epites(EpitesEvent event) {

                if(event.getSource().equals(mezo))
                    addEntityImage(new EntityImage(event.epulet));

                repaint();
                revalidate();
            }

            @Override
            public void kimentettek(KimentesEvent event) {

                if(event.megmentett.getMezo().equals(mezo))
                    removeEntityImage(event.megmentett);

                else if(event.megmento.getMezo().equals(mezo))
                    addEntityImage(new EntityImage(event.megmentett));
            }

            @Override
            public void kutatoKepesseg(KutatoKepessegEvent event) {

                JOptionPane.showMessageDialog(null, "A mezo kapacitasa " + event.celpont.getKapacitas());
            }

            @Override
            public void leptek(LepesEvent event) {

                if (mezo.equals(event.honnan)) {

                    removeEntityImage(event.getSource());
                    repaint();
                    revalidate();
                }

                else  if(mezo.equals(event.hova)) {

                    addEntityImage(new EntityImage(event.getSource()));
                    repaint();
                    revalidate();
                }
            }

            @Override
            public void targyfelvetel(TargyfelvetelEvent event) {

                Targy targy = ((Jegtabla)((Karakter)event.getSource()).getMezo()).getTargy();

                if(((Karakter)event.getSource()).getMezo().equals(mezo)) {

                    removeEntityImage(targy);
                    JOptionPane.showMessageDialog(getParent(), "A " + targy.tipus() + " felv�ve.", "T�rgyfelv�tel" , JOptionPane.PLAIN_MESSAGE);

                    repaint();
                    revalidate();
                }
            }

            @Override
            public void vihar(ViharEvent event) {

                legyenHo();
                if(mezo.getKapacitas() > 0)
                    if(picLabels.containsKey(((Jegtabla)mezo).getEpulet()))
                        removeEntityImage(((Jegtabla)mezo).getEpulet());
            }

            @Override
            public void targyhasznalat(TargyhasznalatEvent event) {

                if(((Targy)event.getSource()).tipus().equals(Targytipus.ELELEM))
                    JOptionPane.showMessageDialog(getParent(), "Az elelem felhasznalva.", "T�rgyhaszn�lat" , JOptionPane.PLAIN_MESSAGE);
            }
        };

        Controller.getInstance().addMezoEventListener(mezoEventListener);
    }
}
