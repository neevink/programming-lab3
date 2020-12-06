package com.neevin.characters;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.enums.CharacterType;
import com.neevin.interfaces.*;
import com.neevin.misc.Phrase;

public class Donkey extends BookCharacter implements IReader {
    public Donkey(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    public void wagTail(){
        //Махание хвостом поднимает настроение ослу
        if(mood.canImprove()){
            mood.improve();
        }
        System.out.println(name + " помахал хвостом.");
    }

    @Override
    public void read(IReadable readable) {
        if(readable == null){
            ExceptionHelper.nullArgument("readable");
        }

        System.out.println(this.name + " прочитал: \"" + readable.getInnerText() + "\"");
    }

    // Прочитать вслух текст персонажу(-ам) с применением эффекта
    public void readAloud(IReadable readable, ICharacterEffect effect, BookCharacter... characters) {
        if(readable == null){
            ExceptionHelper.nullArgument("readable");
        }
        if(effect == null){
            ExceptionHelper.nullArgument("effect");
        }
        if(characters == null){
            ExceptionHelper.nullArgument("characters");
        }
        if(characters.length == 0){
            ExceptionHelper.emptyArray("characters");
        }

        Phrase phrase = new Phrase(readable.getInnerText(), effect);
        this.sayPhrase(phrase, characters);
    }
}