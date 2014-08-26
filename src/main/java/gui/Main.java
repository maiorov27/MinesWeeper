package gui;
import logic.*;
public class Main {

    public static void main(String[] args) {

        Field f = new Field(new RandomMiner(),5);
        GameField gf = new GameField(f);
        MSFrame frame = MSFrame.createFrame(null,gf);
    }
}
