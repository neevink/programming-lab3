package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.MoodType;
import com.neevin.misc.Place;

public abstract class BookCharacter{
    public String name;
    protected MoodType mood;
    protected CharacterType type;
    protected Place place;

    public BookCharacter(String name, CharacterType type){
        this.name = name;
        this.type = type;
        mood = MoodType.NORMAL;
    }

    public CharacterType getCharacterType(){
        return this.type;
    }

    public void setMood(MoodType mood){
        this.mood = mood;
    }

    public MoodType getMood(){
        return this.mood;
    }

    public Place getPlace(Place p){
        return place;
    }

    public void moveToPlace(Place p){
        place = p;
        place.addCharacters(this);
    }

    public void leavePlace(){
        if(place.contains(this.name)) {
            place.removeCharacter(this.name);
        }
        place = null;
    }

    public void lookAround(){
        if(place == null){
            System.out.println(name + " оглянулся по сторонам и понял, что рядом никого нет.");
            return;
        }

        var names = place.peek();
        if (names.size() == 1){
            System.out.println(name + " оглянулся по сторонам, но никого рядом не увидел.");
            return;
        }

        String output = name +" оглянулся по сторонам и увидел рядом с собой:";
        for(var e : names){
            if(e != this.name){
                output += " \"" + e + "\"";
            }
        }
        System.out.println(output);
    }

    abstract void sayPhrase(String phrase);
}
