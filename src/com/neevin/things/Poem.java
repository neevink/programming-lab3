package com.neevin.things;

import com.neevin.interfaces.IReadable;

public class Poem implements IReadable {
    protected String innerText;

    public Poem(String text){
        innerText = text;
    }

    @Override
    public String getInnerText(){
        return innerText;
    }
}
