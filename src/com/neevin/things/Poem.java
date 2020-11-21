package com.neevin.things;

import com.neevin.interfaces.IReadable;

public class Poem implements IReadable {
    public final String name;
    protected String innerText;

    public Poem(String name,String text){
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
    public boolean equals(Object other) {
        if(other instanceof Poem){
            Poem poem = (Poem)other;

            if(name.equals(poem.name) && innerText.equals(poem.innerText)){
                return true;
            }
        }
        return false;
    }
}
