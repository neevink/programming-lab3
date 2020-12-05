package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

public class Pig extends BookCharacter {
    public Pig(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    //Хрюкнуть
    public void grunt(){
        //Хрюканье поднимает настроение свинке
        if(mood.canImprove()){
            mood.improve();
        }
        System.out.println(name + " смачно хрюкнул");
    }
}
