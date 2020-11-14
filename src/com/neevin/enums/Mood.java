package com.neevin.enums;

public class Mood {
    protected MoodType value;
    protected final int statesCount;
    {
        statesCount = MoodType.values().length;
    }

    public Mood(){
        value = MoodType.NORMAL;
    }

    public Mood(MoodType m){
        value = m;
    }

    public MoodType getMoodType(){
        return value;
    }

    //Можно ли обрадовать персонажа?
    public boolean canImprove(){
        if(value.ordinal() < statesCount){
            return true;
        }
        else{
            return false;
        }
    }

    //Обрадовать персонажа, повысить ему настроение
    public void improve(){
        if(value.ordinal() < statesCount){
            int newIndex = value.ordinal()+1;
            value = MoodType.values()[newIndex];
        }
        else{
            throw new IllegalCallerException();
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
            throw new IllegalCallerException();
        }
    }
}
