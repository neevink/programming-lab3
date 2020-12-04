package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.misc.Signature;

public class Kangaroo extends BookCharacter {

    public Kangaroo(String name, CharacterType type, Signature signature){
        super(name, type, signature);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " по-кенгуриному сказал: " + phrase + "\"");
    }

}
