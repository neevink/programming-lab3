package com.neevin.things;

import com.neevin.characters.BookCharacter;
import com.neevin.interfaces.IDocument;
import com.neevin.misc.Signature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Resolution implements IDocument {
    public final String name;
    protected String innerText;
    ArrayList<Signature> signers = new ArrayList<Signature>();

    public Resolution(String name,String text) {
        this.innerText = text;
        this.name = name;
    }

    @Override
    public String getInnerText(){
        return innerText;
    }

    @Override
    public void sign(Signature signature) {
        //!!!!!!!!!!!!!! Не до конца реализованно!
        signers.add(signature);

        //System.out.println(character.name + " подписал " + this.name);
    }

    @Override
    public String toString(){
        return ("резолюция \"" + name +"\"");
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerText, name);
    }

    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }

        if(other == null){
            return false;
        }

        if(getClass() != other.getClass()){
            return false;
        }

        Poem poem = (Poem)other;
        if(name.equals(poem.name) && innerText.equals(poem.innerText)){
            return true;
        }
        return false;
    }
}
