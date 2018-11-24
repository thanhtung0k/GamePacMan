package com.thanhtungpc.gamepacman.view;

import com.thanhtungpc.gamepacman.manager.ImageStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends BasePanel {

    private OnMenuItemClickListener onMenuItemClickListener;
    private JLabel lbStartGame;
    private JLabel lbPacMan;

    @Override
    public void initContainer() {
        setLayout(null);
        setBackground(Color.BLACK);
    }

    @Override
    public void initCompunents() {
        lbPacMan = new JLabel();
        lbPacMan.setText("Pacman");
        lbPacMan.setBounds(20, 0, 480, 125);
        lbPacMan.setForeground(Color.WHITE.darker());
        lbPacMan.setFont(new Font(".VnGothicH", Font.ITALIC, 90));
        add(lbPacMan);

        lbStartGame = new JLabel();
        lbStartGame.setText("Bắt Đầu");
        lbStartGame.setBounds(220, 200, 125, 50);
        lbStartGame.setForeground(Color.WHITE.darker());
        lbStartGame.setFont(new Font("Arial", Font.BOLD, 25));
        add(lbStartGame);

    }

    @Override
    public void registerListener() {
        lbStartGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                onMenuItemClickListener.onMenuItemClick("GAME_PLAY");
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                lbStartGame.setForeground(Color.YELLOW.darker());
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                lbStartGame.setForeground(Color.WHITE.darker());
            }
        });

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(ImageStore.IMG_PACMAN_START, 0, 0, GUI.WIDTH_FRAME, GUI.HEIGTH_FRAME, null);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

}
