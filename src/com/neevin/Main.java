package com.neevin;

import com.neevin.characters.*;
import com.neevin.enums.CharacterType;
import com.neevin.misc.Place;
import com.neevin.things.Poem;

public class Main {

    public static void main(String... args) {
        Place glade = new Place("Поляна");

        Bear winny = new Bear("Винни-Пух", CharacterType.MAIN);
        Human christopher = new Human("Кристофер Робин", CharacterType.MAIN);
        Donkey ia = new Donkey("Иа", CharacterType.SECONDARY);
        Pig pig = new Pig("Пятачок", CharacterType.SECONDARY);

        winny.moveToPlace(glade);
        christopher.moveToPlace(glade);
        ia.moveToPlace(glade);
        pig.moveToPlace(glade);

        glade.describe();

        ia.wagTail();
        ia.sayPhrase("Прости, Кристофер, мы уходим.");
        ia.leavePlace();
        pig.grunt();
        pig.leavePlace();

        Poem poem = new Poem("Смешной стих","Душа воспламенилась страстно:\nона была из пенопласта!");

        christopher.read(poem);
        christopher.lookAround();
        glade.describe();
    }
}