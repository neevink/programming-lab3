package com.neevin.interfaces;

import com.neevin.characters.BookCharacter;
import com.neevin.misc.Signature;

// Интерфейс, который должны реализовывать все документы, которые могут быть подписаны
public interface IDocument extends IReadable {

    // Подписть документ
    void sign(Signature signature);

    // Проверка подписал ли персонаж этот документ
    boolean signedBy(BookCharacter character);

}
