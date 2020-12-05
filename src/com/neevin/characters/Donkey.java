package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.*;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

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
        System.out.println(this.name + " прочитал: \"" + readable.getInnerText() + "\"");
    }

    // Прочитать вслух текст персонажу(-ам) с применением эффекта
    public void readAloud(IReadable readable, ICharacterEffect effect, BookCharacter... characters) {
        Phrase phrase = new Phrase(readable.getInnerText(), effect);
        this.sayPhrase(phrase, characters);
    }
}