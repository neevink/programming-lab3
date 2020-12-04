package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.misc.Signature;

public class Pig extends BookCharacter {
    public Pig(String name, CharacterType type, Signature signature){
        super(name, type, signature);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " прохрюкал: \"" + phrase + "\".");
    }

    //Хрюкнуть
    public void grunt(){
        //Хрюканье поднимает настроение свинке
        if(mood.canImprove()){
            mood.improve();
        }
        System.out.println(name + " смачно хрюкнул.");
    }
}
