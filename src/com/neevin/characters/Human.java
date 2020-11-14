package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.interfaces.IReadable;
import com.neevin.interfaces.IReader;

public class Human extends BookCharacter implements IReader {
    public Human(String name, CharacterType type){
        super(name, type);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(name + " сказал: \"" + phrase + "\"");
    }

    @Override
    public void read(IReadable r){
        System.out.println(name + " прочитал: \n\"" + r.getInnerText() + "\"");
    }
}