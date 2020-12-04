package com.neevin.characters;

import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.interfaces.IDocument;
import com.neevin.misc.Signature;

public class Tiger extends BookCharacter {

    public Tiger(String name, CharacterType type, Signature signature){
        super(name, type, signature);
    }

    @Override
    public void sayPhrase(String phrase) {
        System.out.println(this.name + " по-тигриному сказал: " + phrase + "\"");
    }


    // ИЗМЕНИ НАХЕР ИБО НИЧЕГО НЕ РАБОТАЕТ
    // ДОЛЖНА СОЗДАВАТЬСЯ НОВАЯ ПОДПИСЬ ПО ШАБЛОНУ, НАВЕРНОЕ ПРОТОТИП БУДЕТ ЛУЧШЕ
}
