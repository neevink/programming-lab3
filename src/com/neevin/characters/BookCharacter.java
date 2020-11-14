package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.misc.Mood;
import com.neevin.enums.MoodType;
import com.neevin.misc.Place;

public abstract class BookCharacter{
    public final CharacterType type;

    protected Mood mood;
    protected String name;
    protected Place place;

    public BookCharacter(String name, CharacterType type){
        this.name = name;
        this.type = type;
        mood = new Mood();
    }

    public MoodType getMood(){
        return this.mood.getMoodType();
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

    //Оглянуться по сторонам
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

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof BookCharacter){
            var character = (BookCharacter)other;

            if(name == character.name && type == character.type){
                return true;
            }
        }
        return false;
    }

    //Сказать какую-то фразу
    abstract void sayPhrase(String phrase);
}
