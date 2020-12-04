package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IDocument;
import com.neevin.interfaces.IReadable;
import com.neevin.interfaces.IReader;
import com.neevin.misc.Signature;

public class Donkey extends BookCharacter implements IReader {
    public Donkey(String name, CharacterType type, Signature signature){
        super(name, type, signature);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " по-ослиному сказал: \"" + phrase + "\"");
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
}