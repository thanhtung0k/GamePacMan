package com.thanhtungpc.gamepacman.model;

import com.thanhtungpc.gamepacman.manager.ImageStore;

import java.awt.*;

public class MapItem extends BaseItem {
    public static final int SIZE = 25 ;
    public static final int TYPE_BEAN1 = 2;
    public static final int TYPE_STONE = 1;
    public static final int TYPE_BEAN3 = 3;

    private int type;


    public MapItem(int x, int y,int type) {
        super(x, y);
        this.type =type;
        rectangle = new Rectangle(x,y,SIZE,SIZE);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        switch (type){
            case TYPE_BEAN1 :
                graphics2D.drawImage(ImageStore.IMG_BEAN1,x,y,SIZE,SIZE,null);
                break;
            case TYPE_BEAN3:
                graphics2D.drawImage(ImageStore.IMG_BEAN3,x,y,SIZE,SIZE,null);
                break;
            case TYPE_STONE :
                graphics2D.drawImage(ImageStore.IMG_STONE,x,y,SIZE,SIZE,null);
                default:
                    break;
        }

    }


    public Rectangle getRectangle() {
        return rectangle;
    }
}
