package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IDocument;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

public class Tiger extends BookCharacter {

    public Tiger(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    public void growl(){
        System.out.println(this.name + " зарычал");
    }
}
