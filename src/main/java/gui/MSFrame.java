package gui;

import logic.Field;

import javax.swing.*;
import java.awt.*;

public class MSFrame extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    public static final String APPLICATION_TITLE = "MinesSweeper";
    private static MSFrame instance = null;
    private Field field;
    private JPanel menuPanel;
    private JPanel gamePanel;

    private MSFrame(JPanel menuPanel, JPanel gamePanel){
        this.menuPanel = menuPanel;
        this.gamePanel = gamePanel;
        setFrameLocation();
        setUpFrameProperties();
        setUpFrameLayout();
    }

    private void setFrameLocation(){
        Dimension screensDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xLocation = (int) screensDimension.getWidth()/2 - FRAME_WIDTH/2;
        int yLocation = (int) screensDimension.getHeight()/2 - FRAME_HEIGHT/2;
        setLocation(xLocation, yLocation);
    }

    private void setUpFrameProperties(){
        setTitle(APPLICATION_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setUpFrameLayout(){
        setLayout(new BorderLayout());
//        add("North", menuPanel);
        add("North", gamePanel);

    }

    public static MSFrame createFrame(JPanel menuPanel, JPanel gamePanel) {
        if (instance == null)
            return (instance = new MSFrame(menuPanel, gamePanel));
        return instance;
    }


}
