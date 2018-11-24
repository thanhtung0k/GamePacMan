package com.thanhtungpc.gamepacman.view;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements ViewInitialer,OnMenuItemClickListener
{
    public static final int WIDTH_FRAME = 525;
    public static final int HEIGTH_FRAME = 525;

    private GamePlayPanel gamePlayPanel;
    private MenuPanel menuPanel;



    public GUI(){
        initContainer();
        initCompunents();
        registerListener();
    }
    @Override
    public void initContainer() {
        setTitle("Game PacMan");
        setLayout(new CardLayout());
        Dimension dimension = new Dimension(WIDTH_FRAME,HEIGTH_FRAME);
        getContentPane().setPreferredSize(dimension);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void initCompunents() {
        menuPanel = new MenuPanel();
        menuPanel.setOnMenuItemClickListener(this);

        add(menuPanel);


    }

    @Override
    public void registerListener() {

    }

    @Override
    public void onMenuItemClick(String action) {
        switch (action){
            case "GAME_PLAY" :
                remove(menuPanel);
                gamePlayPanel = new GamePlayPanel();
                add(gamePlayPanel);

                revalidate();
                gamePlayPanel.focusScreen();
                break;
                default:
                    break;
        }
    }
}
