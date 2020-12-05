package com.neevin.misc;

import com.neevin.characters.BookCharacter;
import com.neevin.interfaces.ICharacterEffect;

public class Phrase {
    protected String text;
    protected ICharacterEffect effect;

    public Phrase(String text, ICharacterEffect effect){
        this.text = text;
        this.effect = effect;
    }

    // Сказать фразу персонажу
    public void spell(BookCharacter... characters){
        for (BookCharacter ch : characters){
            effect.invoke(ch);
        }
    }

    @Override
    public String toString(){
        return this.text;
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

        if(otherObject instanceof Phrase){
            Phrase other = (Phrase)otherObject;
            return this.text.equals(other.text);
        }
        return false;
    }
}
