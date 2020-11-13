package com.neevin.enums;

public enum MoodType{
    DISGUSTING(0),
    BAD(1),
    NORMAL(2),
    GOOD(3),
    EXCELLENT(4);

    private int value;

    MoodType(int mood){
        value = mood;
    }

    public int getMood(){
        return value;
    }

    public boolean canImprove(){
        if(value < 4){
            return true;
        }
        else{
            return false;
        }
    }

    public void improve(){
        if(value < 4){
            value++;
        }
        else{
            throw new IllegalCallerException();
        }
    }

    public boolean canDeteriorate(){
        if(value > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void deteriorate(){
        if(value > 0){
            value--;
        }
        else{
            throw new IllegalCallerException();
        }
    }

    //@Override
    //public boolean equals(Object o) {
    //
    //}
}
