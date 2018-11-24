package com.thanhtungpc.gamepacman.model;

import java.awt.*;

public abstract class BaseItem {
    protected int x;
    protected int y;
    protected Rectangle rectangle;

    public BaseItem(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void draw(Graphics2D graphics2D);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
