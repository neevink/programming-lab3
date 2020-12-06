package com.neevin.characters;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.enums.CharacterType;
import com.neevin.interfaces.IReadable;
import com.neevin.interfaces.IReader;
import com.neevin.interfaces.ISignatureMaker;

public class Human extends BookCharacter implements IReader {
    public Human(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    @Override
    public void read(IReadable readable){
        if(readable == null){
            ExceptionHelper.nullArgument("readable");
        }

        System.out.println(name + " прочитал: \n\"" + readable.getInnerText() + "\"");
    }
}