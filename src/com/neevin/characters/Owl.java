package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Signature;

public class Owl extends BookCharacter{

    public Owl(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " по-совьиному сказал: " + phrase + "\"");
    }

    public void fly(){
        System.out.println(this.name + " полетел");
    }
}
