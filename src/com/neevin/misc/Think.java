package com.neevin.misc;

import com.neevin.characters.BookCharacter;
import com.neevin.interfaces.ICharacterEffect;

import java.util.Objects;

// Мысль
public class Think {
    public final String description;
    ICharacterEffect func;

    public Think(String description, ICharacterEffect f){
        this.description = description;
        this.func = f;
    }

    public void think(BookCharacter b){
        System.out.println(b.name + " думает о "+ this.description);
        func.invoke(b);
    }

    @Override
    public String toString(){
        return this.description;
    }

    @Override
    public int hashCode() {
        return this.description.hashCode();
    }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject == this){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof Think) {
            Think other = (Think) otherObject;
            return this.description.equals(other.description);
        }
        return false;
    }

}
