package com.neevin.misc;

public class MagicPlace extends Place{

    public MagicPlace(String name) {
        super(name);
    }

    public int countTrees() {
        if(getRandomBoolean()){
            return 63;
        }
        else{
            return 64;
        }
    }

    protected boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }
}
