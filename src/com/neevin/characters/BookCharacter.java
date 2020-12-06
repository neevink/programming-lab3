package com.neevin.characters;

import com.neevin.exceptions.ExceptionHelper;
import com.neevin.enums.CharacterType;
import com.neevin.exceptions.CharacterNotFoundException;
import com.neevin.interfaces.IDocument;
import com.neevin.interfaces.ISignatureMaker;
import com.neevin.misc.*;

import java.util.ArrayList;
import java.util.Objects;

// Персонаж сказки
public class BookCharacter{
    public final CharacterType type;
    public final String name;
    
    // Настроение персонажа
    public final Mood mood;

    // Место, где находится персонаж
    protected Place place;

    // Функциональный интерфейс, который говорит как персонаж расписывается
    protected ISignatureMaker signatureMaker;

    public BookCharacter(String name, CharacterType type, ISignatureMaker signature){
        if(name == null){
            ExceptionHelper.nullArgument("name");
        }
        if(type == null){
            ExceptionHelper.nullArgument("type");
        }
        if(signature == null){
            ExceptionHelper.nullArgument("signature");
        }

        this.name = name;
        this.type = type;
        this.signatureMaker = signature;

        mood = new Mood();
    }

    public Place getPlace(){
        return place;
    }

    public void moveToPlace(Place p) {
        if(p == null){
            ExceptionHelper.nullArgument("p");
        }

        this.leavePlace();
        place = p;
        place.addCharacters(this);
    }

    public void leavePlace(){
        if(place != null && place.contains(this)) {
            try {
                place.removeCharacter(this);
            }
            catch (CharacterNotFoundException e){}
        }
        place = null;
    }

    // Оглянуться по сторонам
    public void lookAround(){
        if(place == null){
            System.out.println(name + " оглянулся по сторонам и понял, что рядом никого нет.");
            return;
        }

        ArrayList<BookCharacter> characters = place.peek();
        if (characters.size() == 1){
            System.out.println(name + " оглянулся по сторонам, но никого рядом не увидел.");
            return;
        }

        String output = name +" оглянулся по сторонам и увидел рядом с собой:";
        for(BookCharacter e : characters){
            //Персонаж не должен видеть самого себя, а только людей вокруг
            if(!this.equals(e)){
                output += " \"" + e.name + "\"";
            }
        }
        System.out.println(output);
    }

    // Хлопать в ладоши
    public void clap(){
        System.out.println(this.name+" захлопал в лодоши");
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type.ordinal(), this.name);
    }

    @Override
    public boolean equals(Object otherObject) {
        if(otherObject == this){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof BookCharacter) {
            BookCharacter other = (BookCharacter) otherObject;
            return name.equals(other.name) && type.equals(other.type);
        }
        else{
            return false;
        }
    }

    // Заставить персонажа задуматься о чём-то
    public void thinkAbout(Think think){
        if(think == null){
            ExceptionHelper.nullArgument("think");
        }
        think.think(this);
    }

    // Подписать документ
    public void signDocument(IDocument document){
        if(document == null){
            ExceptionHelper.nullArgument("document");
        }

        Signature newSignature = signatureMaker.makeSignature();
        newSignature.setOwner(this);
        document.sign(newSignature);
    }

    // Сказать что-то шёпотом кому-то
    public void whisper(Phrase phrase, BookCharacter character){
        if(phrase == null){
            ExceptionHelper.nullArgument("phrase");
        }
        if(character == null){
            ExceptionHelper.nullArgument("character");
        }

        System.out.println(this.name + " прошептал: " + phrase + "\"" + " персонажу "+character.name);
        phrase.spell(character);
    }

    // Сказать какую-то фразу кому-то
    public void sayPhrase(Phrase phrase, BookCharacter... characters) {
        if(phrase == null){
            ExceptionHelper.nullArgument("phrase");
        }
        if(characters == null){
            ExceptionHelper.nullArgument("characters");
        }
        if(characters.length == 0){
            ExceptionHelper.emptyArray("characters");
        }

        if(characters.length == 1){
            System.out.println(this.name + " сказал: \"" + phrase + "\"" + " персонажу "+characters[0].name);
            phrase.spell(characters[0]);
        }
        else {
            String sentence = this.name + " сказал: \"" + phrase + "\"" + " персонажам";
            for(BookCharacter ch : characters){
                sentence += " " + ch.name;
            }
            System.out.println(sentence);
            phrase.spell(characters);
        }
    }
}
