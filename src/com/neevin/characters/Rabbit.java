package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

public class Rabbit extends BookCharacter {

    public Rabbit(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    public void eatCarrot(){
        //Поедание моркови поднимает настроение медведю
        if(mood.canImprove()){
            mood.improve();
        }
        System.out.println(name + " съел моркову.");
    }
}
