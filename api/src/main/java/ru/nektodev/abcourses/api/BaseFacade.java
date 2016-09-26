package ru.nektodev.abcourses.api;

import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public interface BaseFacade<T> {

    T get(String id);

    List<T> list();

    List<T> merge(List<T> tList);

    List<T> save(List<T> tList);

    void delete(List<String> tList);
}
