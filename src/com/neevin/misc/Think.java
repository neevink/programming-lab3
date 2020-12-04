package com.neevin.misc;

import com.neevin.characters.BookCharacter;
import com.neevin.interfaces.ICharacterEffect;

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

}
