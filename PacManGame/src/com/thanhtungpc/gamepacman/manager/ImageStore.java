package com.thanhtungpc.gamepacman.manager;

import javax.swing.*;
import java.awt.*;

public class ImageStore {
    public static final Image IMG_STONE = getImage("/res/drawable/stone.jpg");
    public static final Image IMG_BEAN1 = getImage("/res/drawable/bean_1.png");
    public static final Image IMG_BEAN3 = getImage("/res/drawable/bean_3.png");
    public  static  Image IMG_LIFE = getImage("/res/drawable/pacman_right_1.png");

    public static final Image IMG_PACMAN_UP[] = {
            getImage("/res/drawable/pacman_0.png"),
            getImage("/res/drawable/pacman_top_1.png"),
            getImage("/res/drawable/pacman_top_2.png"),
            getImage("/res/drawable/pacman_top_3.png")};

    public static final Image IMG_PACMAN_LEFT[] = {
            getImage("/res/drawable/pacman_0.png"),
            getImage("/res/drawable/pacman_left_1.png"),
            getImage("/res/drawable/pacman_left_2.png"),
            getImage("/res/drawable/pacman_left_3.png")};

    public static final Image IMG_PACMAN_RIGHT[] = {
            getImage("/res/drawable/pacman_0.png"),
            getImage("/res/drawable/pacman_right_1.png"),
            getImage("/res/drawable/pacman_right_2.png"),
            getImage("/res/drawable/pacman_right_3.png")
    };
    public static final Image IMG_PACMAN_DOWN[] = {
            getImage("/res/drawable/pacman_0.png"),
            getImage("/res/drawable/pacman_down_1.png"),
            getImage("/res/drawable/pacman_down_2.png"),
            getImage("/res/drawable/pacman_down_3.png")};

    public static final Image IMG_PACMAN_DIE[] = {
            getImage("/res/drawable/pacman_die_1.png"),
            getImage("/res/drawable/pacman_die_2.png"),
            getImage("/res/drawable/pacman_die_3.png"),
            getImage("/res/drawable/pacman_die_4.png")
    };

    public static final Image IMG_GHOST_BLINKY_LEFT[] = {

            getImage("/res/drawable/blinky_7.png"),
            getImage("/res/drawable/blinky_8.png")
    };
    public static final Image IMG_GHOST_BLINKY_UP[] = {
            getImage("/res/drawable/blinky_1.png"),
            getImage("/res/drawable/blinky_2.png")
    };
    public static final Image IMG_GHOST_BLINKY_RIGHT[] = {
            getImage("/res/drawable/blinky_3.png"),
            getImage("/res/drawable/blinky_4.png")
    };
    public static final Image IMG_GHOST_BLINKY_DOWN[] = {
            getImage("/res/drawable/blinky_5.png"),
            getImage("/res/drawable/blinky_6.png")
    };

    public static final Image IMG_GHOST_CLYDE_LEFT[] = {
            getImage("/res/drawable/clyde_7.png"),
            getImage("/res/drawable/clyde_8.png")};

    public static final Image IMG_GHOST_CLYDE_UP[] = {
            getImage("/res/drawable/clyde_1.png"),
            getImage("/res/drawable/clyde_2.png")};

    public static final Image IMG_GHOST_CLYDE_RIGHT[] = {
            getImage("/res/drawable/clyde_3.png"),
            getImage("/res/drawable/clyde_4.png")};

    public static final Image IMG_GHOST_CLYDE_DOWN[] = {
            getImage("/res/drawable/clyde_5.png"),
            getImage("/res/drawable/clyde_6.png")};

    public static final Image IMG_GHOST_INKY_LEFT[] = {
            getImage("/res/drawable/inky_7.png"),
            getImage("/res/drawable/inky_8.png")
    };
    public static final Image IMG_GHOST_INKY_UP[] = {
            getImage("/res/drawable/inky_1.png"),
            getImage("/res/drawable/inky_2.png")
    };
    public static final Image IMG_GHOST_INKY_RIGHT[] = {
            getImage("/res/drawable/inky_3.png"),
            getImage("/res/drawable/inky_4.png")
    };
    public static final Image IMG_GHOST_INKY_DOWN[] = {
            getImage("/res/drawable/inky_5.png"),
            getImage("/res/drawable/inky_6.png")
    };

    public static final Image IMG_GHOST_PINKY_LEFT[] = {
            getImage("/res/drawable/pinky_7.png"),
            getImage("/res/drawable/pinky_8.png")
    };
    public static final Image IMG_GHOST_PINKY_UP[] = {
            getImage("/res/drawable/pinky_1.png"),
            getImage("/res/drawable/pinky_2.png")
    };
    public static final Image IMG_GHOST_PINKY_RIGHT[] = {
            getImage("/res/drawable/pinky_3.png"),
            getImage("/res/drawable/pinky_4.png")
    };
    public static final Image IMG_GHOST_PINKY_DOWN[] = {
            getImage("/res/drawable/pinky_5.png"),
            getImage("/res/drawable/pinky_6.png")
    };
    public static final Image IMG_PACMAN_START = getImage("/res/drawable/pacman_star1.jpg");

    private static final Image getImage(String path) {
        return getImageIcon(path).getImage();
    }

    private static final ImageIcon getImageIcon(String path) {
        return new ImageIcon(ImageStore.class.getResource(path));
    }

}
