package com.thanhtungpc.gamepacman.model;

import com.thanhtungpc.gamepacman.manager.ImageStore;

import java.awt.*;

public class Pacman extends BaseItem {
    public static final int SIZE = MapItem.SIZE;
    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;
    public static final int DIE = 4;
    public static final int DELAY = 10;
    public static final int LIFE = 5;

    public int orient;
    private int nextOrient;
    private int index;
    private int delay;
    private int die;

    public Pacman(int x, int y, int orient, int delay) {
        super(x, y);
        this.orient = orient;
        nextOrient = orient;
        this.delay = delay;
        rectangle = new Rectangle(x, y, MapItem.SIZE, MapItem.SIZE);
        index = 0;
    }

    public void move(long totalSleep) {
        if (totalSleep % (delay/6) != 0) {
            return;
        }
        switch (orient) {
            case LEFT:
                x--;
                rectangle.setLocation(x - 1, y);
                break;
            case UP:
                y--;
                rectangle.setLocation(x, y - 1);
                break;
            case RIGHT:
                x++;
                rectangle.setLocation(x + 1, y);
                break;
            case DOWN:
                y++;
                rectangle.setLocation(x, y + 1);
                break;
            default:
                break;
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (die < ImageStore.IMG_PACMAN_DIE.length) {
            graphics2D.drawImage(ImageStore.IMG_PACMAN_DIE[die], x, y, SIZE, SIZE, null);
        }
        switch (orient) {
            case LEFT:
                if (index < ImageStore.IMG_PACMAN_LEFT.length) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_LEFT[index], x, y, SIZE,SIZE , null);
                }
                break;
            case UP:
                if (index < ImageStore.IMG_PACMAN_UP.length) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_UP[index], x, y, SIZE, SIZE, null);
                }
                break;
            case RIGHT:
                if (index < ImageStore.IMG_PACMAN_RIGHT.length) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_RIGHT[index], x, y, SIZE, SIZE, null);
                }
                break;
            case DOWN:
                if (index < ImageStore.IMG_PACMAN_DOWN.length) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_DOWN[index], x, y, SIZE, SIZE, null);
                }
                break;

            case LIFE:
                    graphics2D.drawImage(ImageStore.IMG_LIFE, x, y, SIZE, SIZE, null);

                break;

            default:
                break;
        }
    }

    public void run(long totalSleep) {
        if (totalSleep % DELAY  != 0) {
            return;
        }
        die++;
        index++;
        if (index >= ImageStore.IMG_PACMAN_UP.length ||
                index >= ImageStore.IMG_PACMAN_LEFT.length ||
                index >= ImageStore.IMG_PACMAN_RIGHT.length ||
                index >= ImageStore.IMG_PACMAN_DOWN.length
                ) {
            index = 0;
        }
        if (die>=ImageStore.IMG_PACMAN_DIE.length){
            return;
        }
    }

    public void setOrient(int orient) {
        if (this.orient == orient) {
            return;
        }
        this.orient = orient;

        switch (orient) {
            case LEFT:
                rectangle.setLocation(x - 1, y);
                break;
            case UP:
                rectangle.setLocation(x, y - 1);
                break;
            case RIGHT:
                rectangle.setLocation(x + 1, y);
                break;
            case DOWN:
                rectangle.setLocation(x, y + 1);
                break;
            default:
                break;
        }

    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }


    public int getOrient() {
        return orient;
    }

    public int getNextOrient() {
        return nextOrient;
    }

    public void setNextOrient(int nextOrient) {
        if (this.nextOrient == nextOrient) {
            return;
        }
        this.nextOrient = nextOrient;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
