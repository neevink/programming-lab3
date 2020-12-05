package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

public class Kangaroo extends BookCharacter {

    public Kangaroo(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    public void jump(){
        if(mood.canImprove()){
            mood.improve();
        }
        System.out.println(this.name + " запрыгал");
    }
}
