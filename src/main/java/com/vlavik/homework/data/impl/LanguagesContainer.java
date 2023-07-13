package com.vlavik.homework.data.impl;

import com.vlavik.homework.data.ObjectContainer;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class LanguagesContainer implements ObjectContainer {

    private static final List<String> OBJECTS = new CopyOnWriteArrayList<>(
            Arrays.asList("Java", "Python", "Ruby", "C++", "JavaScript", "C#",
                    "Assembler", "Go", "Scala", "Kotlin", "Basic", "PHP",
                    "Perl", "C", "MATLAB", "Fortran", "Pascal", "SQL",
                    "Prolog", "LabVIEW", "R", "F", "Groovy"
            )
    );
    private static final int OBJECTS_AMOUNT = OBJECTS.size();

    private final Random random = new SecureRandom();
    private List<String> objectsCopy;

    public LanguagesContainer(int listSize) {
        this.objectsCopy = fillOutListAtRandom(listSize);
    }

    private List<String> fillOutListAtRandom(int listSize) {
        if (listSize > OBJECTS_AMOUNT) {
            listSize = OBJECTS_AMOUNT;
        }
        List<String> shuffledList = new CopyOnWriteArrayList<>(OBJECTS);
        Collections.shuffle(shuffledList);
        return shuffledList.subList(0, listSize);
    }

    @Override
    public List<String> getList() {
        return objectsCopy;
    }

    /**
     * Inserts a random item and mixes the list.
     *
     * @return mixed list
     */
    @Override
    public List<String> getOne() {
        objectsCopy.add(getRandomElement());
        Collections.shuffle(objectsCopy);
        return objectsCopy;
    }

    /**
     * Inserts a random item at the head of the list.
     *
     * @return updated list
     */
    @Override
    public List<String> postOne() {
        objectsCopy.add(0, getRandomElement());
        return objectsCopy;
    }

    /**
     * Inserts a random item at the tail of the list.
     *
     * @return updated list
     */
    @Override
    public List<String> putOne() {
        objectsCopy.add(getRandomElement());
        return objectsCopy;
    }

    private String getRandomElement() {
        return OBJECTS.get(getRandomIndex());
    }

    /**
     * Removes a random item from the list.
     *
     * @return updated list
     */
    @Override
    public List<String> deleteOne() {
        if (!objectsCopy.isEmpty()) {
            objectsCopy.remove(getRandomIndex());
        }
        return objectsCopy;
    }

    private int getRandomIndex() {
        return random.nextInt(OBJECTS_AMOUNT);
    }

    @Override
    public int getSize() {
        return objectsCopy.size();
    }
}
