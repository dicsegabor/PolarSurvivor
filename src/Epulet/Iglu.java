package Epulet;

import Proto.LogAndTesting.Logger;

public class Iglu implements Epulet {

    @Override
    public Epulettipus epulettipus() {

        Logger.log();

        return Epulettipus.IGLU;
    }
}
