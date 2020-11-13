package com.neevin.characters;

import com.neevin.enums.CharacterType;

public class Bear extends BookCharacter{
    public Bear(String name, CharacterType type){
        super(name, type);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " проревел: \"" + phrase + "\"");
    }

    public void eatHoney(){
        //Поедание мёда поднимает настроение медведю
        if(mood.canImprove()){
            mood.improve();
        }
    }
}