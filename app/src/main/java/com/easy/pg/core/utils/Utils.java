package com.easy.pg.core.utils;

public class Utils {

    public static <S, T extends Iterable<S>> boolean isEmpty(T argument)
    {
        return (argument == null) || !argument.iterator().hasNext();
    }
}
