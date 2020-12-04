package com.neevin.misc;

import com.neevin.characters.BookCharacter;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IReadable;


// Подпись персонажа, может быть прочитана
public class Signature implements IReadable {
    protected SignatureStyle style;
    protected String text;

    protected BookCharacter owner;

    public Signature(SignatureStyle style, String text){
        this.style = style;
        this.text = text;
    }

    public void setOwner(BookCharacter owner){
        this.owner = owner;
    }

    public BookCharacter getOwner(){
        return this.owner;
    }

    @Override
    public String getInnerText() {
        return this.text;
    }

    @Override
    public String toString(){
        return "подпись: \"" + this.text + "\"";
    }

    @Override
    public int hashCode(){
        return this.text.hashCode();
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof Signature){
            Signature other = (Signature)otherObject;
            return this.text.equals(other.text);
        }
        return false;
    }
}
