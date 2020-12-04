package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IDocument;
import com.neevin.misc.Signature;

public class Bear extends BookCharacter{
    public Bear(String name, CharacterType type, Signature signature){
        super(name, type, signature);
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
        System.out.println(this.name + " съел мёда.");
    }
}