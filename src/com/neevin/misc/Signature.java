package com.neevin.misc;

import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IReadable;

public class Signature implements IReadable, Cloneable {
    public final SignatureStyle style;
    public final String text;


    public Signature(SignatureStyle style, String text){
        this.style = style;
        this.text = text;
    }

    @Override
    public String getInnerText() {
        return this.text;
    }

    @Override
    public Signature clone(){
        Signature newSignature = new Signature(this.style, this.text);
        return newSignature;
    }
}
