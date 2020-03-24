package Szkeleton.Menu.MenuPoints;

public class EndOfScenario extends MenuPoint{

    public EndOfScenario(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        System.out.println("Vége ennek a forgatókönyvnek!");
    }
}
