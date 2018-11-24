package com.thanhtungpc.gamepacman.view;

import com.thanhtungpc.gamepacman.manager.GameManager;
import com.thanhtungpc.gamepacman.model.Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;

public class GamePlayPanel extends BasePanel implements Runnable {

    private GameManager gameManager;
    private BitSet bitSet;
    private boolean isGamePlaying = false;
    private MenuPanel menuPanel;


    public GamePlayPanel() {
        super();
        startGame();
    }

    public void focusScreen() {
        requestFocusInWindow();
    }

    @Override
    public void initContainer() {
        setBackground(Color.BLACK);
        setFocusable(true);
        setLayout(null);

    }

    @Override
    public void initCompunents() {
        gameManager = new GameManager();
        bitSet = new BitSet();
    }

    @Override
    public void registerListener() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                bitSet.set(keyEvent.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                bitSet.set(keyEvent.getKeyCode(), false);
            }
        };
        addKeyListener(keyAdapter);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        gameManager.drawMapBean1(graphics2D);
        gameManager.drawStone(graphics2D);
        gameManager.drawPacman(graphics2D);
        gameManager.drawPoin(graphics2D);
        gameManager.drawGhost(graphics2D);
        gameManager.drawLifePacman(graphics2D);

    }

    public void startGame() {

        Thread thread = new Thread(this);

        thread.start();
        isGamePlaying = true;
    }


    @Override
    public void run() {
        long totalSleep = 0;
        while (isGamePlaying) {
            if (bitSet.get(KeyEvent.VK_LEFT)) {
                gameManager.changeMyPacmanOrient(Pacman.LEFT);
            }
            if (bitSet.get(KeyEvent.VK_UP)) {
                gameManager.changeMyPacmanOrient(Pacman.UP);

            }
            if (bitSet.get(KeyEvent.VK_RIGHT)) {
                gameManager.changeMyPacmanOrient(Pacman.RIGHT);

            }
            if (bitSet.get(KeyEvent.VK_DOWN)) {
                gameManager.changeMyPacmanOrient(Pacman.DOWN);

            }
            gameManager.tryChangeOrientMyPacman();
            gameManager.movePacMan(totalSleep);
            gameManager.moveGhosts(totalSleep);
            gameManager.countDownDelayTime4Fire();
            gameManager.runSleepImagePacMan(totalSleep);
            gameManager.runSleepGhost(totalSleep);
            gameManager.pacmanDie();


            if (totalSleep < Long.MAX_VALUE) {
                totalSleep++;
            } else {
                totalSleep = 0;
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gameManager.gameOver() == false) {
                int result = JOptionPane.showConfirmDialog(GamePlayPanel.this, "Gà vãi chưởng chơi lại đi !! ^-^", "game over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    gameManager.intnGame();
                    bitSet.clear();
                }
                else {
                    System.exit(0);
                }
            }


        }


    }

}
