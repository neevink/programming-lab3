package com.neevin.misc;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.characters.BookCharacter;
import com.neevin.exceptions.CharacterNotFoundException;

import java.util.ArrayList;

public class Place{
    protected String name;
    protected ArrayList<BookCharacter> characters = new ArrayList<BookCharacter>();

    public Place(String name){
        if(name == null){
            ExceptionHelper.nullArgument("name");
        }
        this.name = name;
    }

    //Описать сцену
    public void describe(){
        if(characters.isEmpty()){
            System.out.println("На местности \"" + name + "\" никого нет.");
            return;
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
        if(character == null){
            ExceptionHelper.nullArgument("character");
        }

        for(BookCharacter e : characters){
            if(e.equals(character)){
                return true;
            }
        }
        return false;
    }

    //Получить персонажа места
    public BookCharacter getCharacter(String characterName) throws CharacterNotFoundException {
        if(characterName == null){
            ExceptionHelper.nullArgument("characterName");
        }

        for(BookCharacter e : characters){
            if(e.toString().equals(characterName)){
                return e;
            }
        }

        throw new CharacterNotFoundException(characterName, "Персонажа нет на локации.");
    }

    public void addCharacters(BookCharacter... chs){
        if(chs == null){
            ExceptionHelper.nullArgument("chs");
        }
        if(chs.length == 0){
            ExceptionHelper.emptyArray("chs");
        }

        for(BookCharacter e : chs){
            characters.add(e);
        }
    }

    public void removeCharacter(BookCharacter character) throws CharacterNotFoundException {
        if(character == null){
            ExceptionHelper.nullArgument("character");
        }
        if(!contains(character)){
            throw new CharacterNotFoundException(character.name, "Персонажа нет на локации.");
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
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof Place){
            Place other = (Place)otherObject;
            return this.name.equals(other.name);
        }
        return false;
    }
}