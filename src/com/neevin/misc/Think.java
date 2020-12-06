package com.neevin.misc;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.characters.BookCharacter;
import com.neevin.interfaces.ICharacterEffect;

// Мысль, о которой могут думать персонажы
public class Think {
    public final String description;
    ICharacterEffect effect;

    public Think(String description, ICharacterEffect eff){
        if(description == null){
            ExceptionHelper.nullArgument("description");
        }
        if(eff == null){
            ExceptionHelper.nullArgument("eff");
        }

        this.description = description;
        this.effect = eff;
    }

    // Заставить персонажа думать об этом
    public void think(BookCharacter character){
        if(character == null){
            ExceptionHelper.nullArgument("character");
        }

        System.out.println(character.name + " думает о "+ this.description);
        effect.invoke(character);
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
