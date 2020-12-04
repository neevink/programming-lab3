package com.neevin.exceptions;

import com.neevin.characters.BookCharacter;

public class CharacterNotFoundException extends Exception {
    public final String characterName;

    public CharacterNotFoundException(String characterName){
        super("Персонаж \"" + characterName + "\" не был найден.");
        this.characterName = characterName;
    }

    public CharacterNotFoundException(String characterName, String message){
        super(message);
        this.characterName = characterName;
    }

}
