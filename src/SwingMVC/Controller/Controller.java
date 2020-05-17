package SwingMVC.Controller;

import Mezo.Mezo;
import Mozgathato.Karakter;
import SwingMVC.Model.Model;

public class Controller {

    private static Controller instance;
    private Model model;
    private Karakter activeKarakter;

    public static Controller getInstance() {

        if(instance == null)
            return new Controller();

        return instance;
    }

    public Controller(){

        instance = this;

        model = new Model();
        activeKarakter = model.getKarakter(0);
    }

    public void lep(Mezo mezo){

        activeKarakter.lep(mezo);
    }
}
