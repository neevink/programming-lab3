package com.neevin.misc;

import com.neevin.characters.BookCharacter;

import java.util.ArrayList;

public class Place{
    protected String name;
    protected ArrayList<BookCharacter> characters = new ArrayList<BookCharacter>();

    public Place(String name){
        this.name = name;
    }

    //Описать сцену
    public void describe(){
        if(characters.isEmpty()){
            System.out.println("На местности \"" + name + "\" никого нет.");
        }

        String output = "На местности \"" + name + "\" собрались";
        ArrayList<BookCharacter> characters = peek();
        for (BookCharacter e : characters){
            output += " \"" + e.toString() + "\"";
        }
        System.out.println(output);
    }

    //Получить список персонажей на сцене
    public ArrayList<BookCharacter> peek(){
        return characters;
    }

    //Есть ли персонаж в этом месте?
    public boolean contains(BookCharacter character){
        for(BookCharacter e : characters){
            if(e.equals(character)){
                return true;
            }
        }
        return false;
    }

    //Получить персонажа места
    public BookCharacter getCharacter(String characterName){
        for(BookCharacter e : characters){
            if(e.toString().equals(characterName)){
                return e;
            }
        }

        throw new IllegalArgumentException("Персонажа нет на локации.");
    }

    public void addCharacters(BookCharacter... chs){
        for(BookCharacter e : chs){
            characters.add(e);
        }
    }

    public void removeCharacter(BookCharacter character){
        if(!contains(character)){
            throw new IllegalArgumentException("Персонажа нет на локации.");
        }

        for(BookCharacter e : characters){
            if(e.equals(character)){
                characters.remove(e);
                return;
            }
        }
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Place){
            Place place = (Place)other;

            if(name.equals(place.name)){
                return true;
            }
        }
        return false;
    }
}