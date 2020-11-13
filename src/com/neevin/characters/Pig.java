package com.neevin.characters;

import com.neevin.enums.CharacterType;

public class Pig extends BookCharacter {
    public Pig(String name, CharacterType type){
        super(name, type);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " прохрюкал: \"" + phrase + "\".");
    }

    public void grunt(){
        //Хрюканье поднимает настроение свинке
        if(mood.canImprove()){
            mood.improve();
        }
        System.out.println(name + " смачно хрюкнул.");
    }
}
