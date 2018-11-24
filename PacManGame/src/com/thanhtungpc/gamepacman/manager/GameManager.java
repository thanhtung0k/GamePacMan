package com.thanhtungpc.gamepacman.manager;

import com.thanhtungpc.gamepacman.model.Ghost;
import com.thanhtungpc.gamepacman.model.MapItem;
import com.thanhtungpc.gamepacman.model.Pacman;
import com.thanhtungpc.gamepacman.view.GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    private static final int FIRE_INTERVAL_MAX = 200;
    public static int diem = 0;
    private List<MapItem> beans;
    private List<MapItem> stones;
    private List<Pacman> pacmens;
    private Pacman pacman;

    private Ghost[] ghosts;

    public int index;

    private int currentTime4Fire;
    Random random;

    public GameManager() {
        SoundWav starSound = new SoundWav("/res/raw/sound_111.wav");
        starSound.play();
        starSound.loop(2);
        index = 0;

        currentTime4Fire = FIRE_INTERVAL_MAX;
        beans = new ArrayList<>();
        stones = new ArrayList<>();
        pacmens = new ArrayList<>();

        creatMap();
        pacman = new Pacman(250, 275, Pacman.LEFT, Pacman.DELAY);

        ghosts = new Ghost[4];
        ghosts[0] = new Ghost(225, 225, Ghost.LEFT, Ghost.BLINKY, Pacman.DELAY);
        ghosts[1] = new Ghost(250, 225, Ghost.UP, Ghost.CLYDE, Pacman.DELAY);
        ghosts[2] = new Ghost(250, 175, Ghost.RIGHT, Ghost.INKY, Pacman.DELAY);
        ghosts[3] = new Ghost(275, 225, Ghost.DOWN, Ghost.PINKY, Pacman.DELAY);

        Pacman pacman1 = new Pacman(225, 0, Pacman.LIFE, 0);
        pacmens.add(pacman1);
        pacman1 = new Pacman(251, 0, Pacman.LIFE, 0);
        pacmens.add(pacman1);
        pacman1 = new Pacman(277, 0, Pacman.LIFE, 0);
        pacmens.add(pacman1);


        random = new Random();

    }

    public void intnGame(){
        SoundWav starSound = new SoundWav("/res/raw/sound_111.wav");
        starSound.play();
        starSound.loop(2);
        index = 0;

        currentTime4Fire = FIRE_INTERVAL_MAX;
        beans = new ArrayList<>();
        stones = new ArrayList<>();
        pacmens = new ArrayList<>();
        diem = 0;

        creatMap();
        pacman = new Pacman(250, 275, Pacman.LEFT, Pacman.DELAY);

        ghosts = new Ghost[4];
        ghosts[0] = new Ghost(225, 225, Ghost.LEFT, Ghost.BLINKY, Pacman.DELAY);
        ghosts[1] = new Ghost(250, 225, Ghost.UP, Ghost.CLYDE, Pacman.DELAY);
        ghosts[2] = new Ghost(250, 175, Ghost.RIGHT, Ghost.INKY, Pacman.DELAY);
        ghosts[3] = new Ghost(275, 225, Ghost.DOWN, Ghost.PINKY, Pacman.DELAY);

        Pacman pacman1 = new Pacman(225, 0, Pacman.LIFE, 0);
        pacmens.add(pacman1);
        pacman1 = new Pacman(251, 0, Pacman.LIFE, 0);
        pacmens.add(pacman1);
        pacman1 = new Pacman(277, 0, Pacman.LIFE, 0);
        pacmens.add(pacman1);


        random = new Random();
    }

    public void creatMap() {

        try {
            String path = getClass().getResource("/res/assets/map_1.txt").getPath();
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int row = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    int type = line.charAt(i) - 48;
                    int x = i * MapItem.SIZE;
                    int y = row * MapItem.SIZE;
                    MapItem mapItem = new MapItem(x, y, type);
                    switch (type) {
                        case MapItem.TYPE_STONE:
                            stones.add(mapItem);
                            break;
                        case MapItem.TYPE_BEAN1:
                        case MapItem.TYPE_BEAN3:
                            beans.add(mapItem);
                            break;
                        default:
                            break;
                    }

                }
                row++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMapBean1(Graphics2D g) {
        for (int i = 0; i < beans.size(); i++) {
            beans.get(i).draw(g);
        }
    }

    public void drawStone(Graphics2D g) {
        for (int i = 0; i < stones.size(); i++) {
            stones.get(i).draw(g);
        }
    }

    public void drawPacman(Graphics2D g) {
        pacman.draw(g);

    }

    public void drawLifePacman(Graphics2D g) {
        for (int i = 0; i < pacmens.size(); i++) {
            pacmens.get(i).draw(g);
        }
    }

    public void runSleepImagePacMan(long totalSleep) {
        pacman.run(totalSleep);

    }

    public void runSleepGhost(long totalSleep) {
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].runGhost(totalSleep);
        }
    }

    public void countDownDelayTime4Fire() {
        if (currentTime4Fire > 0) {
            currentTime4Fire -= 100;
        }

    }


    public void changeMyPacmanOrient(int orient) {
        pacman.setNextOrient(orient);
    }

    public void movePacMan(long totalSleep) {
        if (canPacmanMove(pacman)) {
            pacman.move(totalSleep);
            if (pacman.getX() + Pacman.SIZE < 0) {
                pacman.setX(GUI.WIDTH_FRAME - Pacman.SIZE);
            } else {
                if (pacman.getX() > GUI.WIDTH_FRAME + Pacman.SIZE / 2) {
                    pacman.setX(0 - Pacman.SIZE / 2 + 5);
                }

            }

            pacmanEatBean1();
        }
    }

    public void tryChangeOrientMyPacman() {
        int index = pacman.getOrient();
        int next = pacman.getNextOrient();
        pacman.setOrient(next);
        if (!canPacmanMove(pacman)) {
            pacman.setOrient(index);
        }
    }

    public void drawGhost(Graphics2D g) {
        for (int i = 0; i < ghosts.length; i++) {
            ghosts[i].draw(g);
        }
    }

    public int computeGhostOrient(int orient) {
        int next;
        do {
            next = random.nextInt(4);
        } while (next == orient);
        return next;
    }

    public void moveGhosts(long totalSleep) {

        for (int i = 0; i < ghosts.length; i++) {
            if (canGhostMove(ghosts[i])) {
                if (random.nextInt(100) > 1) {
                    int current = ghosts[i].getOrient();
                    int next = ghosts[i].getNextOrient();

                    ghosts[i].setOrient(next);

                    if (!canGhostMove(ghosts[i])) {
                        ghosts[i].setOrient(current);
                    }
                    ghosts[i].move(totalSleep);
                } else {
                    int next = computeGhostOrient(ghosts[i].getOrient());
                    if (random.nextInt(100) > 95) {
                        ghosts[i].setOrient(next);
                    } else {
                        ghosts[i].setNextOrient(next);
                    }
                }

            } else {
                int next = computeGhostOrient(ghosts[i].getOrient());
                ghosts[i].setOrient(next);
            }


        }

    }

    private boolean canPacmanMove(Pacman obj) {
        for (int i = 0; i < stones.size(); i++) {
            if (obj.getRectangle().intersects(stones.get(i).getRectangle())) {
                return false;
            }
        }
        return true;
    }

    private boolean canGhostMove(Ghost obj) {
        for (int j = 0; j < stones.size(); j++) {
            if (obj.getRectangle().intersects(stones.get(j).getRectangle())) {
                return false;
            }
        }
        return true;
    }

    private void pacmanEatBean1() {
        for (int i = 0; i < beans.size(); i++) {
            if (canPacmanEatBean(pacman.getRectangle(), beans.get(i).getRectangle())) {
                beans.remove(i);
                i--;
                SoundWav eatSound = new SoundWav("/res/raw/sound_115.wav");
                eatSound.play();
                diem = diem + 100;

            }
        }
    }

    public void drawPoin(Graphics2D g) {

        Font font = new Font("Arial", Font.BOLD, 19);
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString("Điểm : " + diem, 8, 13);

    }

    private boolean canPacmanEatBean(Rectangle rPacman, Rectangle rBean) {
        Rectangle r = rPacman.intersection(rBean);
        if (r.width >= MapItem.SIZE / 2 + 5 && r.height >= MapItem.SIZE / 2 + 5) {
            return true;
        }
        return false;
    }

    public void pacmanDie() {
        for (int i = 0; i < ghosts.length; i++) {
            if (canPacmanVsGhost(pacman, ghosts[i])) {
                for (int j = 0; j < pacmens.size(); j++) {
                    pacman.setOrient(Pacman.DIE);
                    SoundWav dieSound = new SoundWav("/res/raw/sound_112.wav");
                    dieSound.play();
                    pacman.setX(250);
                    pacman.setY(275);
                    pacmens.remove(j);

                }
            }
        }
    }


    private boolean canPacmanVsGhost(Pacman rPacman, Ghost rGhost) {

        return rPacman.getRectangle().intersects(rGhost.getRectangle());

    }
    public boolean gameOver(){
        if(pacmens.size() == 0){
            return false;
        }
        return true;
    }


}

