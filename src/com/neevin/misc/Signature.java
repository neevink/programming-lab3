package com.neevin.misc;

import com.neevin.characters.BookCharacter;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IReadable;

// Подпись персонажа, может быть прочитана
public class Signature implements IReadable {
    // Тип и сожержание подписи
    public final SignatureStyle style;
    public final String text;

    // Владелей подписи
    protected BookCharacter owner;

    public Signature(SignatureStyle style, String text){
        this.style = style;
        this.text = text;
    }

    public Signature(SignatureStyle style, String text, BookCharacter owner){
        this.style = style;
        this.text = text;
        this.owner = owner;
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
    public Signature clone(){
        Signature newSignature = new Signature(this.style, this.text, this.owner);
        return newSignature;
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
