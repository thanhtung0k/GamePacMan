package com.thanhtungpc.gamepacman.model;

import com.thanhtungpc.gamepacman.manager.ImageStore;

import java.awt.*;
import java.util.Random;

public class Ghost extends Pacman {
    public static final int BLINKY = 0;
    public static final int CLYDE = 1;
    public static final int INKY = 2;
    public static final int PINKY = 3;
    Random random;
    private int type;
    private int index;


    public Ghost(int x, int y, int orient, int type, int delay) {
        super(x, y, orient, delay);
        this.type = type;
        index = 0;

        random = new Random();
        rectangle = new Rectangle(x, y, MapItem.SIZE, MapItem.SIZE);
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        switch (type) {
            case BLINKY:
                switch (orient) {
                    case LEFT:
                        if (index < ImageStore.IMG_GHOST_BLINKY_LEFT.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_BLINKY_LEFT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case UP:
                        if (index < ImageStore.IMG_GHOST_BLINKY_UP.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_BLINKY_UP[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case RIGHT:
                        if (index < ImageStore.IMG_GHOST_BLINKY_RIGHT.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_BLINKY_RIGHT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case DOWN:
                        if (index < ImageStore.IMG_GHOST_BLINKY_DOWN.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_BLINKY_DOWN[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    default:
                        break;

                }
                break;
            case CLYDE:

                switch (orient) {
                    case LEFT:
                        if (index < ImageStore.IMG_GHOST_CLYDE_LEFT.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_CLYDE_LEFT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case UP:
                        if (index < ImageStore.IMG_GHOST_CLYDE_UP.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_CLYDE_UP[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case RIGHT:
                        if (index < ImageStore.IMG_GHOST_CLYDE_RIGHT.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_CLYDE_RIGHT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case DOWN:
                        if (index < ImageStore.IMG_GHOST_CLYDE_DOWN.length) {
                            graphics2D.drawImage(ImageStore.IMG_GHOST_CLYDE_DOWN[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    default:
                        break;
                }
                break;
            case INKY:

                switch (orient){
                    case LEFT :
                        if(index < ImageStore.IMG_GHOST_INKY_LEFT.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_INKY_LEFT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case UP :
                        if(index < ImageStore.IMG_GHOST_INKY_UP.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_INKY_UP[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case RIGHT :
                        if(index < ImageStore.IMG_GHOST_INKY_RIGHT.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_INKY_RIGHT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case DOWN :
                        if(index < ImageStore.IMG_GHOST_INKY_DOWN.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_INKY_DOWN[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                        default:
                            break;
                }
                break;
            case PINKY:
                switch (orient){
                    case LEFT :
                        if (index < ImageStore.IMG_GHOST_PINKY_LEFT.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_PINKY_LEFT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case UP :
                        if (index < ImageStore.IMG_GHOST_PINKY_UP.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_PINKY_UP[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case RIGHT :
                        if (index < ImageStore.IMG_GHOST_PINKY_RIGHT.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_PINKY_RIGHT[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                    case DOWN :
                        if (index < ImageStore.IMG_GHOST_PINKY_DOWN.length){
                            graphics2D.drawImage(ImageStore.IMG_GHOST_PINKY_DOWN[index], x, y, SIZE, SIZE, null);
                        }
                        break;
                        default:
                            break;
                }

                break;
            default:
                break;

        }
    }

    public void runGhost(long totalSleep) {
        if (totalSleep % DELAY  !=0){
            return;
        }
        index++;
        if (index >= ImageStore.IMG_GHOST_BLINKY_LEFT.length ||
                index >= ImageStore.IMG_GHOST_BLINKY_UP.length ||
                index >= ImageStore.IMG_GHOST_BLINKY_RIGHT.length ||
                index >= ImageStore.IMG_GHOST_BLINKY_DOWN.length ||
                index >= ImageStore.IMG_GHOST_CLYDE_LEFT.length ||
                index >= ImageStore.IMG_GHOST_CLYDE_UP.length ||
                index >= ImageStore.IMG_GHOST_CLYDE_RIGHT.length ||
                index >= ImageStore.IMG_GHOST_CLYDE_DOWN.length ||
                index >= ImageStore.IMG_GHOST_INKY_LEFT.length ||
                index >= ImageStore.IMG_GHOST_INKY_UP.length ||
                index >= ImageStore.IMG_GHOST_INKY_RIGHT.length ||
                index >= ImageStore.IMG_GHOST_INKY_DOWN.length ||
                index >= ImageStore.IMG_GHOST_PINKY_LEFT.length ||
                index >= ImageStore.IMG_GHOST_PINKY_UP.length ||
                index >= ImageStore.IMG_GHOST_PINKY_RIGHT.length ||
                index >= ImageStore.IMG_GHOST_PINKY_DOWN.length
                ) {
            index = 0;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }
}
