package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.misc.Mood;
import com.neevin.enums.MoodType;
import com.neevin.misc.Place;

import java.util.ArrayList;
import java.util.Objects;

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
        if(place != null && place.contains(this)) {
            place.removeCharacter(this);
        }
        place = null;
    }

    //Оглянуться по сторонам
    public void lookAround(){
        if(place == null){
            System.out.println(name + " оглянулся по сторонам и понял, что рядом никого нет.");
            return;
        }

        ArrayList<BookCharacter> characters = place.peek();
        if (characters.size() == 1){
            System.out.println(name + " оглянулся по сторонам, но никого рядом не увидел.");
            return;
        }

        String output = name +" оглянулся по сторонам и увидел рядом с собой:";
        for(BookCharacter e : characters){
            //Персонаж не должен видеть самого себя, а только людей вокруг
            if(!this.equals(e)){
                output += " \"" + e.name + "\"";
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
        return Objects.hash(type.ordinal(), name);
    }

    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }

        if(other == null){
            return false;
        }

        if(getClass() != other.getClass()) {
            return false;
        }

        BookCharacter character = (BookCharacter)other;
        if(name.equals(character.name) && type.equals(character.type)){
            return true;
        }

        return false;
    }

    //Сказать какую-то фразу
    abstract void sayPhrase(String phrase);
}
