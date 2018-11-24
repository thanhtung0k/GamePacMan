package com.thanhtungpc.gamepacman.manager;

public abstract class ISound {
    public ISound (String fileName){

    }
    public abstract void play();

    public abstract void stop();

    public abstract void loop(int count);
}
