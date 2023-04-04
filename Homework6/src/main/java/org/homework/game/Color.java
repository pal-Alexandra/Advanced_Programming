package org.homework.game;

/**
 * @author Pal Alexandra
 * This enum describes the color of a line.
 */

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
public enum Color implements Serializable {
    RED, BLUE, GRAY;
}

