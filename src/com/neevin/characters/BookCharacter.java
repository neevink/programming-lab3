package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.exceptions.CharacterNotFoundException;
import com.neevin.interfaces.IDocument;
import com.neevin.misc.Mood;
import com.neevin.enums.MoodType;
import com.neevin.misc.Place;
import com.neevin.misc.Signature;
import com.neevin.misc.Think;

import java.util.ArrayList;
import java.util.Objects;

public abstract class BookCharacter{
    public final CharacterType type;
    public final String name;
    public final Mood mood;

    protected Place place;
    protected Signature signature;

    public BookCharacter(String name, CharacterType type, Signature signature){
        this.name = name;
        this.type = type;
        this.signature = signature;
        mood = new Mood();
    }

    public Place getPlace(Place p){
        return place;
    }

    public void moveToPlace(Place p) {
        this.leavePlace();
        place = p;
        place.addCharacters(this);
    }

    public void leavePlace(){
        if(place != null && place.contains(this)) {
            try {
                place.removeCharacter(this);
            }
            catch (CharacterNotFoundException e){

            }
        }
        place = null;
    }

    // Оглянуться по сторонам
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

    // Хлопать в ладоши
    public void clap(){
        System.out.println(this.name+" захлопал в лодоши");
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

    // Сказать что-то шёпотом
    public void whisper(String phrase){
        System.out.println(this.name + " прошептал: " + phrase + "\"");
    }

    public void thinkAbout(Think t){
        t.think(this);
    }

    public void signDocument(IDocument document){
        document.sign(this.signature.clone());
    }

    //Сказать какую-то фразу
    public abstract void sayPhrase(String phrase);
}
