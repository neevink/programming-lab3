package com.neevin;

import com.neevin.characters.*;
import com.neevin.enums.CharacterType;
import com.neevin.enums.SignatureStyle;
import com.neevin.misc.MagicPlace;
import com.neevin.misc.Place;
import com.neevin.misc.Signature;
import com.neevin.misc.Think;
import com.neevin.things.Resolution;

import java.util.ArrayList;

public class Main {

    public static void main(String... args) {
        // Кристофер робин находится у себя дома
        Place home = new Place("Дом Кристофера Робина");

        Human christopher = new Human("Кристофер Робин", CharacterType.MAIN, () -> new Signature(SignatureStyle.SERIF,"Робин"));
        christopher.moveToPlace(home);


        // В это время на поляне собрались звери
        Place glade = new Place("Поляна");

        Bear winny = new Bear("Винни-Пух", CharacterType.MAIN, () -> new Signature(SignatureStyle.SANS_SERIF,"ПУХ"));
        Donkey ia = new Donkey("Иа", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.SERIF,"ИА"));
        Pig pig = new Pig("Пятачок", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.MONOSPACE,"Пятачок"));
        Owl owl = new Owl("Сова", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.MONOSPACE,"Сова"));
        Rabbit rabbit = new Rabbit("Кролик", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.SANS_SERIF,"Кролик"));
        Kangaroo kenga = new Kangaroo("Кенга", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.SERIF,"Кенга"));
        Kangaroo ru = new Kangaroo("Крошка Ру", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.MONOSPACE,"..."));
        Tiger tiger = new Tiger("Тигра", CharacterType.SECONDARY, () -> new Signature(SignatureStyle.MONOSPACE,"."));

        winny.moveToPlace(glade);
        ia.moveToPlace(glade);
        pig.moveToPlace(glade);
        owl.moveToPlace(glade);
        rabbit.moveToPlace(glade);
        kenga.moveToPlace(glade);
        ru.moveToPlace(glade);
        tiger.moveToPlace(glade);

        // Описать кто собрался на поляне
        glade.describe();

        Resolution resolution = new Resolution("Резолюция", "Кристофер Робин, мы  пришли, чтобы сказать что нам не хочется, чтобы ты уезжал, нам без тебя грустно.");
        ia.read(resolution);
        ia.sayPhrase("Если кто-нибудь намерен аплодировать, то время настало");

        // Все по поляне захлопали
        for (BookCharacter b : glade.peek()){
            b.clap();
        }

        // Все по поляне подписали резолюцию
        for (BookCharacter b : glade.peek()){
            b.signDocument(resolution);
        }

        // Все подписали резолюцию и отправились к дому Кристофера Робина
        ArrayList<BookCharacter> chars = glade.peek();
        while (!chars.isEmpty()){
            chars.get(0).moveToPlace(home);

        }

        // Описать кто собрался у дома Кристофера Робина, а кто остался на поляне
        home.describe();
        glade.describe();

        christopher.sayPhrase("Здравствуйте, друзья");
        for (BookCharacter b : home.peek()){
            if(!b.equals(christopher)) {
                b.sayPhrase("Здравствуй");
            }
        }

        // Мысль о прощанье с Кристофером Робиным, это расстраивает
        Think goodbyeToChristopher = new Think("прощаньи с Кристофером", x -> {
            if(x.mood.canDeteriorate())
                x.mood.deteriorate();
        });

        for (BookCharacter b : home.peek()){
            if(!b.equals(christopher)){
                b.thinkAbout(goodbyeToChristopher);
            }
        }

        // Все, кроме Кристофера, шепчат друг другу
        for (BookCharacter b : home.peek()){
            if(!b.equals(christopher)){
                b.whisper("Ну, давай ты");
            }
        }

        christopher.sayPhrase("В чём дело, Иа?");

        // Помохал хвостом, чтобы себя подбодрить
        ia.wagTail();

        ia.sayPhrase("Кристофер Робин, мы  пришли, чтобы сказать что нам не хочется, чтобы ты уезжал, нам без тебя грустно.");
        ia.sayPhrase("Эх, я кажется понял, что Кристофер просто хочет побыть идин, а мы все сюда пришли и надоедаем ему...");

        //расходятся все, кроме Винни и Кристофера
        ia.leavePlace();
        pig.leavePlace();
        owl.leavePlace();
        rabbit.leavePlace();
        kenga.leavePlace();
        ru.leavePlace();
        tiger.leavePlace();

        // Кристофер читает резолюцию и оглядывается по сторонам
        christopher.read(resolution);
        christopher.lookAround();

        Place road = new Place("Дорога");

        christopher.moveToPlace(road);
        winny.moveToPlace(road);

        christopher.sayPhrase("Пух, что ты любишь делать больше всего на свете?");
        Think eatingHoney = new Think("мёде", x -> {
            x.sayPhrase("Я люблю, когда мы с Пятачком  придем к тебе в гости и ты говоришь: \"Ну как, не пора ли подкрепиться?\", а я говорю: \"Я бы не  возражал\"");
        });

        winny.thinkAbout(eatingHoney);

        Think differentThings = new Think("том, о сём", x -> {});
        christopher.thinkAbout(differentThings);
        winny.thinkAbout(differentThings);

        Place capitansBridge = new MagicPlace("Капитанский мостик");
        winny.moveToPlace(capitansBridge);
        christopher.moveToPlace(capitansBridge);

    }
}

/*
    Если кто-нибудь намерен аплодировать,-- сказал Иа, прочитав все это,-- то время настало. Все захлопали.
    И резолюция была подписана: Пух, Сова, Пятачок, Иа, Кролик, Кенга, Большая Клякса (это была подпись Тигры)
    и Три Маленькие Кляксы (это была подпись Крошки Ру). И Все-Все-Все отправились к дому Кристофера Робина.
    Все они сказали: "Здравствуй", и вдруг всем стало как-то грустно и не по себе-- ведь получалось, что они
    пришли прощаться, а им очень-очень не хотелось об этом думать. Они беспомощно сбились в кучу, ожидая,
    чтобы заговорил кто-нибудь другой, и только подталкивали друг друга, шепча: "Ну, давай ты", и мало-помалу
    вперед вытеснили Иа, а все остальные столпились за ним. Иа помахал хвостом, очевидно желая себя подбодрить,
    и начал. Сами хорошенько не понимая почему, остальные тоже начали расходиться, и когда Кристофер
    Робин закончил чтение Стихотворения и поднял глаза, собираясь сказать "спасибо", перед ним был один
    Винни Пух. Что ж, они пошли туда, и, после того как они прошли порядочный кусок, Кристофер Робин
    спросил: И тут ему пришлось остановиться и подумать, потому что хотя кушать мед-- очень приятное занятие,
    но есть такая минутка, как раз перед тем как ты примешься за мед, когда еще приятнее, чем потом,
    когда ты уже ешь, но только Пух не знал, как эта минутка называется. И еще он подумал, что играть с
    Кристофером Робином тоже очень приятное дело, и играть с Пятачком -- это тоже очень приятное дело, и
    вот когда он все это обдумал, он сказал: Они шли, думая о Том и о Сем, и постепенно они добрались до
    Зачарованного Места, которое называлось Капитанский Мостик, потому что оно было на самой вершине холма.
    Там росло шестьдесят с чем-то деревьев, и Кристофер Робин знал, что это место зачаровано, потому что
    никто не мог сосчитать, сколько тут деревьев-- шестьдесят три или шестьдесят четыре, даже если он
    привязывал к каждому сосчитанному дереву кусочек бечевки. Как полагается в Зачарованном Месте, и земля
    тут была другая, не такая, как в Лесу, где росли всякие колючки и папоротник и лежали иголки; здесь
    она вся росла ровной-ровной зеленой травкой, гладкой, как газон.
 */

/*
    Все, Кроме Кристофера Робина собираются на поляне.
    Иа читает резолюцию собственного сочинения (эту резолюцию должны подписать все животные).
    Иа говорит "Если кто-нибудь намерен аплодировать, то время настало."
    Все захлопали.
    Все подписывают резолюцию.

    Все отправились к дому Кристофера Робина.

    Кристофер Робин сказал: "Здравствуйте, друзья"
    Все они сказали: "Здравствуй"
    Всем становится грустно, после того как они думают о прощанье с Кистофером.
    Каждый из них подталкивает другого и шепчет "Ну, давай ты"

    Кристофер Робин сказал: "В чём дело, Иа?"
    Иа машет хвостом

    Иа сказал: "Кристофер Робин, мы  пришли, чтобы сказать что нам не хочется,
        чтобы ты уезжал, нам без тебя грустно."
    Иа сказал: "Эх, я кажется понял, что Кристофер просто хочет побыть идин,
        а мы все сюда пришли и надоедаем ему..."
    Все расходятся.

    Кристофер читает резолюцию.
    Кристофер смотрит по сторонам.
    Описание сцены.

    Кристофер говорит: "Это очень трогательно"
    Кристофер и Пух идут на дорогу.

    Кристофер спросил: "Пух, что ты любишь делать больше всего на свете?"
    Пух думает о мёде, об игре с Пяточком, об игре с Кристофером
    Пух отвечает: "Я люблю, когда мы с Пятачком  придем к тебе в гости и ты говоришь:
        "Ну как, не пора ли подкрепиться?", а я говорю: "Я бы не  возражал""

    Кристофер думает о том о сём.
    Винни пух думает о том о сём.

    Кристофер и Пух приходят в зачарованно место "Капитанский Мостик".


    Зачарованное место наследуется от места и имеет метод росчитать деревья (63 - 64).

    Мысли влияют на настроение и другие качества, накладывают эффекты
 */