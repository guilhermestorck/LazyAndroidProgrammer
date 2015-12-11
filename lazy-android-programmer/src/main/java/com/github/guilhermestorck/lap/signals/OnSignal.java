package com.github.guilhermestorck.lap.signals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
METHODS ANNOTATED WITH THIS MUST BE PUBLIC
DO NOT USE PRIMITIVES AS PARAM TYPES ON METHODS ANNOTATED WITH THIS INTERFACE
 */
@Target(ElementType.METHOD)
public @interface OnSignal {

    String value();

}
