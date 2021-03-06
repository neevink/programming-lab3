package com.neevin.things;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.interfaces.IReadable;

// Стихотворение
public class Poem implements IReadable {
    public final String name;
    protected String innerText;

    public Poem(String name,String text){
        if(name == null){
            ExceptionHelper.nullArgument("name");
        }
        if(text == null){
            ExceptionHelper.nullArgument("text");
        }

        this.innerText = text;
        this.name = name;
    }

    @Override
    public String getInnerText(){
        return innerText;
    }

    @Override
    public String toString(){
        return ("стихотворение \"" + name +"\"");
    }

    @Override
    public int hashCode() {
        return (innerText+name).hashCode();
    }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject == this){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof Poem){
            Poem other = (Poem)otherObject;
            return name.equals(other.name) && innerText.equals(other.innerText);
        }
        return false;
    }
}
