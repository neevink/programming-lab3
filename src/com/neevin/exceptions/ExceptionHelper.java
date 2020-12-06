package com.neevin.exceptions;

public final class ExceptionHelper {

    // Выбросить исключение, что аргумент метода/конструктора не может быть null
    public static void nullArgument(String argName){
        if(argName == null){
            throw new IllegalArgumentException("Аргумент \'argName\' метода/конструктора не может быть null.");
        }

        throw new IllegalArgumentException("Аргумент \'" + argName + "\' метода/конструктора не может быть null.");
    }

    // Выбросить сиключение, что массив, переданный в качестве аргумента не может быть пустым
    public static void emptyArray(String argName){
        if(argName == null){
            throw new IllegalArgumentException("Аргумент \'argName\' метода/конструктора не может быть null.");
        }

        throw new IllegalArgumentException("Аргумент \'" + argName + "\' метода/конструктора должен содержать хотя бы один элемент.");
    }
}
