package com.neevin.exceptions;

public class MoodTypeOutOfRangeError extends Error {
    public MoodTypeOutOfRangeError(){
        super("MoodType вышел за границы!");
    }
}
