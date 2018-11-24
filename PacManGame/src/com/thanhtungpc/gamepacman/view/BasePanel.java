package com.thanhtungpc.gamepacman.view;

import javax.swing.*;

public abstract class BasePanel extends JPanel implements ViewInitialer{
    public BasePanel(){
        initContainer();
        initCompunents();
        registerListener();
    }
}
