package com.music.MusicAppSpring.services;

import java.util.List;

public interface CRUDService <T, ID>{
    List<T> getAllElements();
    T saveElement(T element);
    T getElementById(ID id);
    T updateElement(T element, ID id);
    void deleteElement(ID id);
}
