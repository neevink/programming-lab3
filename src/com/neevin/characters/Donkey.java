package com.neevin.characters;

import com.neevin.enums.CharacterType;

public class Donkey extends BookCharacter{
    public Donkey(String name, CharacterType type){
        super(name, type);
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
}