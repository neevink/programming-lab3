package com.neevin.misc;

import com.neevin.characters.BookCharacter;

import java.util.ArrayList;

public class Place{
    protected String name;
    protected ArrayList<BookCharacter> characters = new ArrayList<BookCharacter>();

    public Place(String name){
        this.name = name;
    }

    public void describe(){
        if(characters.isEmpty()){
            System.out.println("На местности \"" + name + "\" никого нет.");
        }

        String output = "На местности \"" + name + "\" собрались";
        var names = peek();
        for (var e : names){
            output += " \"" + e + "\"";
        }
        System.out.println(output);
    }

    //Возвращает список имён персонажей на сцене
    public ArrayList<String> peek(){
        var names = new ArrayList<String>();
        for(var e : characters){
            names.add(e.name);
        }
        return names;
    }

    public boolean contains(String characterName){
        for(var e : characters){
            if(e.name == characterName){
                return true;
            }
        }
        return false;
    }

    public BookCharacter getCharacter(String characterName){
        for(var e : characters){
            if(e.name == characterName){
                return e;
            }
        }

        throw new IllegalArgumentException("Персонажа нет на локации.");
    }

    public void addCharacters(BookCharacter... chs){
        for(var e : chs){
            characters.add(e);
        }
    }

    public void removeCharacter(String characterName){
        if(!contains(characterName)){
            throw new IllegalArgumentException("Персонажа нет на локации.");
        }

        for(var e : characters){
            if(e.name == characterName){
                characters.remove(e);
                return;
            }
        }
    }
}