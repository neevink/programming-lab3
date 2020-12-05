package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IDocument;
import com.neevin.interfaces.IReadable;
import com.neevin.interfaces.IReader;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.Phrase;
import com.neevin.misc.Signature;

public class Human extends BookCharacter implements IReader {
    public Human(String name, CharacterType type, ISignatureMaker signature){
        super(name, type, signature);
    }

    @Override
    public void read(IReadable r){
        System.out.println(name + " прочитал: \n\"" + r.getInnerText() + "\"");
    }
}