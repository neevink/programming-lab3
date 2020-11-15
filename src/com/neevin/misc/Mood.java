package com.neevin.misc;

import com.neevin.enums.MoodType;

public class Mood {
    protected MoodType value;
    protected final static int statesCount;
    static {
        statesCount = MoodType.values().length;
    }

    public Mood(){
        value = MoodType.NORMAL;
    }

    public Mood(MoodType mood){
        value = mood;
    }

    public MoodType getMoodType(){
        return value;
    }

    //Можно ли обрадовать персонажа?
    public boolean canImprove(){
        if(value.ordinal() < statesCount -1){
            return true;
        }
        else{
            return false;
        }
    }

    //Обрадовать персонажа, повысить ему настроение
    public void improve(){
        if(value.ordinal() < statesCount - 1){
            int newIndex = value.ordinal()+1;
            value = MoodType.values()[newIndex];
        }
        else{
            throw new RuntimeException();
        }
    }

    //Можно ли расстроить персонажа?
    public boolean canDeteriorate(){
        if(value.ordinal() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    //Расстроить персонажа, понизить ему настроение
    public void deteriorate(){
        if(value.ordinal() > 0){
            int newIndex = value.ordinal()-1;
            value = MoodType.values()[newIndex];;
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public String toString(){
        return value.toString();
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Mood){
            Mood m = (Mood)other;

            if(value.equals(m.value)){
                return true;
            }
        }
        return false;
    }
}
